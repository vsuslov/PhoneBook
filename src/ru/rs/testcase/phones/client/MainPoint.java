
package ru.rs.testcase.phones.client;

import ru.rs.testcase.phones.client.gin.SimpleGinjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class MainPoint implements EntryPoint {
    
    private final SimpleGinjector injector = GWT.create(SimpleGinjector.class);
    
    @Override
    public void onModuleLoad() {
    
        final AppPresenter ap = injector.getAppPresenter();
        ap.go(RootPanel.get());
        
        injector.getPlaceManager().fireCurrentPlace();
    }

}
