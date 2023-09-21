package mg.tonymushah.ejbtest.client;

import mg.tonymushah.ejbtest.client.interceptor.ClientInterceptor;
import mg.tonymushah.ejbtest.server.interfaces.remote.People;

import javax.naming.InitialContext;

import jakarta.ejb.EJB;
public class Main {
    @EJB
    private static People people;
    public static void main(String[] args) {
        EJBClientContext.Builder builder = new EJBClientContext.Builder();
        builder.addInterceptor(ClientInterceptor.class);
        EJBClientContext context = builder.build();
        System.out.println(people);
        context.close();
    }
}
