package ru.rs.testcase.phones.client.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import ru.rs.testcase.phones.client.command.SimpleAction;
import ru.rs.testcase.phones.client.command.SimpleResult;
import ru.rs.testcase.phones.client.events.AlertEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Label;

public class SimplePresenter extends WidgetPresenter<SimplePresenter.Display> {

	private Display display;

	private DispatchAsync dispatcher;

	public interface Display extends WidgetDisplay {

		HasClickHandlers goButton();

		Label text();

	}

	public static final Place PLACE = new Place("Simple");

	public SimplePresenter(Display display, EventBus eventBus) {

		super(display, eventBus);
		// TODO Auto-generated constructor stub
	}

	public SimplePresenter(DispatchAsync dispatcher, Display display,
			EventBus eventBus) {

		super(display, eventBus);
		this.dispatcher = dispatcher;

		bind();
	}

	public void doGO() {

		dispatcher.execute(new SimpleAction("QQ"),
				new DisplayCallback<SimpleResult>(display) {

					@Override
					protected void handleFailure(Throwable e) {

						display.text().setText(e.getMessage());
					}

					@Override
					protected void handleSuccess(SimpleResult value) {

						display.text().setText(value.getMessage());
						eventBus.fireEvent(new AlertEvent());

					}
				});
	}

	@Override
	public void refreshDisplay() {

		// TODO Auto-generated method stub

	}

	@Override
	public void revealDisplay() {

		// TODO Auto-generated method stub

	}

	@Override
	protected void onBind() {

		display.goButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				doGO();
			}

		});
	}

	@Override
	protected void onUnbind() {

		// TODO Auto-generated method stub

	}

	@Override
	public Place getPlace() {

		// TODO Auto-generated method stub
		return PLACE;
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {

		String param = request.getParameter("name", null);
		if (param != null) {
			display.text().setText(param);
		}
	}

}
