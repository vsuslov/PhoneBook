
package ru.rs.testcase.phones.server.rpc;

import net.customware.gwt.dispatch.client.standard.StandardDispatchService;
import net.customware.gwt.dispatch.server.DefaultActionHandlerRegistry;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.InstanceActionHandlerRegistry;
import net.customware.gwt.dispatch.server.SimpleDispatch;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.DispatchException;
import net.customware.gwt.dispatch.shared.Result;
import ru.rs.testcase.phones.server.rpc.handlers.GetContactsHandler;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DispatcherServlet extends RemoteServiceServlet implements
        StandardDispatchService
{
    
    /**
     *
     */
    private static final long serialVersionUID = -626039166305563461L;
    
    private Dispatch dispatch;
    
    public DispatcherServlet() {
    
        InstanceActionHandlerRegistry registry =
                new DefaultActionHandlerRegistry();
        registry.addHandler(new SimpleHandler());
        registry.addHandler(new GetContactsHandler());
        dispatch = new SimpleDispatch(registry);
    }
    
    @Override
    public Result execute(Action<?> action) throws DispatchException {
    
        try {
            return dispatch.execute(action);
        } catch (DispatchException e) {
            throw e;
        }
    }
}
