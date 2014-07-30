
package ru.rs.testcase.phones.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import ru.rs.testcase.phones.client.presenters.SimplePresenter;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AppPresenter {

    private HasWidgets container;
    
    private SimplePresenter simplePresenter;
    
    @Inject
    public AppPresenter(final DispatchAsync dispatcher,

            final SimplePresenter simplePresenter)
    {

        this.simplePresenter = simplePresenter;
    }

    private void showMain() {

        container.clear();
        container.add(simplePresenter.getDisplay().asWidget());
    }

    public void go(final HasWidgets container) {

        this.container = container;

        showMain();
    }
}
