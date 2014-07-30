
package ru.rs.testcase.phones.client.command;

import net.customware.gwt.dispatch.shared.Result;

public class SimpleResult implements Result {
    
    private String message;
    
    public SimpleResult() {
    
    }
    
    public SimpleResult(String message) {
    
        super();
        this.message = message;
    }
    
    public String getMessage() {
    
        return message;
    }
    
}
