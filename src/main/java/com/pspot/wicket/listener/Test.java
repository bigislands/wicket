package com.pspot.wicket.listener;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/27
 */
public class Test {

    public static void main(String[] args){
        Button button1 = new Button();
        button1.onClick();
        button1.registerEventListener(new ButtonEventListener() {
            @Override
            public void callBack(Event event) {
                event.callBack();
                //System.out.println("called========");
            }
        });

    }
}
