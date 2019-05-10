package com.pspot.wicket.listener;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/27
 */
public class Event {

    private Button button;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void callBack(){
        System.out.println("event called");
    }
}
