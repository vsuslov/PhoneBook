
package ru.rs.testcase.phones.server.rpc;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;
import ru.rs.testcase.phones.client.command.SimpleAction;
import ru.rs.testcase.phones.client.command.SimpleResult;

public class SimpleHandler implements ActionHandler<SimpleAction, SimpleResult>
{

    @Override
    public SimpleResult execute(SimpleAction arg0, ExecutionContext arg1)
            throws DispatchException
    {
    
        return new SimpleResult("Your request is:" + arg0.getParam());
    }

    @Override
    public Class<SimpleAction> getActionType() {

        // TODO Auto-generated method stub
        return SimpleAction.class;
    }

    @Override
    public void rollback(SimpleAction arg0, SimpleResult arg1,
            ExecutionContext arg2) throws DispatchException
    {
    
        // TODO Auto-generated method stub
        
    }

}
