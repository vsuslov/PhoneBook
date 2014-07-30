
package ru.rs.testcase.phones.client.command;

import net.customware.gwt.dispatch.shared.Action;

public class SimpleAction implements Action<SimpleResult> {
    
    private String param;

    public SimpleAction(String param) {
    
        this.param = param;
    }

    public SimpleAction() {

    }
    
    public String getParam() {

        return param;
    }

}
