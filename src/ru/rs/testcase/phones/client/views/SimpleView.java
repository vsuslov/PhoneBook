
package ru.rs.testcase.phones.client.views;

import ru.rs.testcase.phones.client.presenters.SimplePresenter.Display;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SimpleView extends Composite implements Display {
    
    private Button simpleButton;
    
    private VerticalPanel p;
    
    private Label text;
    
    public SimpleView() {
    
        p = new VerticalPanel();
        initWidget(p);
        simpleButton = new Button("trololo");
        text.setText("Click Me");
        p.add(text);
        p.add(simpleButton);
        
    }
    
    @Override
    public Widget asWidget() {
    
        // TODO Auto-generated method stub
        return this;
    }
    
    @Override
    public HasClickHandlers goButton() {

        // TODO Auto-generated method stub
        return simpleButton;
    }
    
    @Override
    public Label text() {

        // TODO Auto-generated method stub
        return text;
    }
    
    @Override
    public void startProcessing() {

        // TODO Auto-generated method stub

    }
    
    @Override
    public void stopProcessing() {

        // TODO Auto-generated method stub

    }
    
}
