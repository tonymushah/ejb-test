package mg.tonymushah.ejbtest.client;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mg.tonymushah.ejbtest.server.interfaces.remote.PeopleWithMemory;
import mg.tonymushah.ejbtest.server.interfaces.remote.People;

public class Main {
    public static Context getContext() throws NamingException {
        Properties prop = new Properties();
        prop.put(
                Context.INITIAL_CONTEXT_FACTORY,
                "org.wildfly.naming.client.WildFlyInitialContextFactory");
        prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        // prop.put("jboss.naming.client.ejb.context", true);
        prop.put(Context.SECURITY_PRINCIPAL, "test");
        prop.put(Context.SECURITY_CREDENTIALS, "tonymushah");
        // prop.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
        // "false");

        return new InitialContext(prop);
    }

    private static void toTony(Context context) throws NamingException {
        System.out.println("Main.toTony()");
        People tony = (People) context
                .lookup("ejb:/server-0.0.1-SNAPSHOT/Tony!" + People.class.getName());
        System.out.println(tony.sayHello());
        System.out.println(tony.think());
        System.out.println(tony.calculate(4, 2));
    }

    private static void toTomefy(Context context) throws NamingException {
        System.out.println("Main.toTomefy()");
        PeopleWithMemory tomefy = (PeopleWithMemory) context
                .lookup("ejb:/server-0.0.1-SNAPSHOT/Tomefy!" + PeopleWithMemory.class.getName() + "?stateful");
        System.out.println(tomefy.sayHello());
        System.out.println(tomefy.think());
        //System.out.println(tomefy.calculate(4, 2));
        tomefy.send("Lol");
        tomefy.send("Some args");
        Map<Date, String> memory = tomefy.getMemory();
        System.out.println(String.format("%d", memory.size()));
        for (Map.Entry<Date,String> memoryEntry : memory.entrySet()) {
            System.out.println(String.format("%s => %s", memoryEntry.getKey().toString(), memoryEntry.getValue()));
        }
    }

    public static void main(String[] args) throws NamingException {
        Context context = Main.getContext();
        try {
            Main.toTony(context);
            Main.toTomefy(context);
        } catch (NamingException e) {
            // TODO: handle exception
            System.out.println("Main.main()");
            e.printStackTrace(System.err);
        }finally{
            context.close();
        }
    }
}
