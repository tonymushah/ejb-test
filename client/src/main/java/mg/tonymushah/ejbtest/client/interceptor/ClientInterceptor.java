package mg.tonymushah.ejbtest.client.interceptor;

import java.util.logging.Logger;

import org.jboss.ejb.client.EJBClientInterceptor;
import org.jboss.ejb.client.EJBClientInvocationContext;

/**
 * Example of an interceptor at client side which can be configures with the {@link EJBClientContext#registerInterceptor(int
 * priority, new ClientInterceptor())}.
 *
 * @author <a href="mailto:wfink@redhat.com">Wolf-Dieter Fink</a>
 */
public class ClientInterceptor implements EJBClientInterceptor {
    private static final Logger LOGGER = Logger.getLogger(ClientInterceptor.class.getName());

    @Override
    public void handleInvocation(EJBClientInvocationContext context) throws Exception {
        String nodeName = System.getProperty("jboss.node.name");
        LOGGER.info("Adding jboss.node.name (" + nodeName + ") to the invocation context");
        context.getContextData().put("Client ", nodeName);
        context.sendRequest();
    }

    @Override
    public Object handleInvocationResult(EJBClientInvocationContext context) throws Exception {
        return context.getResult();
    }

}