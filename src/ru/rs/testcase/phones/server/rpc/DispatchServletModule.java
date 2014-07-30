
package ru.rs.testcase.phones.server.rpc;

import com.google.inject.servlet.ServletModule;
import net.customware.gwt.dispatch.server.

public class DispatchServletModule extends ServletModule {
    
    @Override
    protected void configureServlets() {

        serve("/phonebook/dispatch").with(DispatchServiceServlet.class);
    }
}
