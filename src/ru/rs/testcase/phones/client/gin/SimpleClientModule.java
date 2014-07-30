
package ru.rs.testcase.phones.client.gin;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;
import ru.rs.testcase.phones.client.AppPresenter;
import ru.rs.testcase.phones.client.presenters.SimplePresenter;
import ru.rs.testcase.phones.client.views.SimpleView;
import com.google.inject.Singleton;

public class SimpleClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
    
        bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
        bind(PlaceManager.class).in(Singleton.class);
        
        bindPresenter(SimplePresenter.class, SimplePresenter.Display.class,
                SimpleView.class);

        bind(AppPresenter.class).in(Singleton.class);
        
    }
}
