
package ru.rs.testcase.phones.server.rpc.handlers;

import java.util.ArrayList;
import java.util.List;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;
import ru.rs.testcase.phones.client.command.GetContactsAction;
import ru.rs.testcase.phones.client.command.GetContactsResult;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.ContactsException;
import ru.rs.testcase.phones.server.data.ContactsDao;
import ru.rs.testcase.phones.server.data.ContactsDaoImpl;

public class GetContactsHandler implements
ActionHandler<GetContactsAction, GetContactsResult>
{
    
    @Override
    public GetContactsResult execute(GetContactsAction arg0,
            ExecutionContext arg1) throws DispatchException
    {
    
        ContactsDao dao = new ContactsDaoImpl();
        String message = "";
        List<Contact> result = new ArrayList<>();
        try {
            result = dao.findAllContacts();
        } catch (ContactsException c) {
            message = c.getMessage();
        }
        
        return new GetContactsResult(result, message);
    }
    
    @Override
    public Class<GetContactsAction> getActionType() {

        // TODO Auto-generated method stub
        return GetContactsAction.class;
    }
    
    @Override
    public void rollback(GetContactsAction arg0, GetContactsResult arg1,
            ExecutionContext arg2) throws DispatchException
    {

        // TODO Auto-generated method stub

    }
    
}
