
package ru.rs.testcase.phones.client.presenters;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditContactPresenter implements Presenter {

    public interface Display {
        
        HasClickHandlers okButton();
        
        HasValue<String> nameField();
        
        HasValue<String> phoneField();
    }
    
    @Override
    public void go(HasWidgets container) {
    
        // TODO Auto-generated method stub
        
    }

}
