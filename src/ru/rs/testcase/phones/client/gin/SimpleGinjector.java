
package ru.rs.testcase.phones.client.gin;

import net.customware.gwt.dispatch.client.gin.StandardDispatchModule;
import net.customware.gwt.presenter.client.place.PlaceManager;
import ru.rs.testcase.phones.client.AppPresenter;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ StandardDispatchModule.class, SimpleClientModule.class })
public interface SimpleGinjector extends Ginjector {
    
    AppPresenter getAppPresenter();
    
    PlaceManager getPlaceManager();
}
