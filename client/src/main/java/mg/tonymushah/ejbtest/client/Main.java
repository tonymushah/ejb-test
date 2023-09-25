package mg.tonymushah.ejbtest.client;

import mg.tonymushah.ejbtest.client.interceptor.ClientInterceptor;
import mg.tonymushah.ejbtest.server.interfaces.remote.People;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb.client.EJBClientConnection;
import org.jboss.ejb.client.EJBClientContext;

import jakarta.ejb.EJB;
import jakarta.ejb.embeddable.EJBContainer;

public class Main {
    public static void main(String[] args) throws NamingException {
        Properties prop = new Properties();
        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        // prop.put("jboss.naming.client.ejb.context", true);
        prop.put(Context.SECURITY_PRINCIPAL, "test");
        prop.put(Context.SECURITY_CREDENTIALS, "tonymushah");
        // prop.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
        // "false");

        Context context = new InitialContext(prop);
        People tony = (People) context
                .lookup("ejb:/server-0.0.1-SNAPSHOT/Tony!" + People.class.getName());
        System.out.println(tony.sayHello());
        context.close();
    }
}
