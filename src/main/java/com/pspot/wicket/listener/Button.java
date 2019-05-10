package com.pspot.wicket.listener;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/27
 */
/**
 * 事件源
 * 注册监听器
 */
public class Button {

    private ButtonEventListener eventListener;


    public void registerEventListener(ButtonEventListener eventListener){
        this.eventListener = eventListener;
    }

    /**
     *
     */
    public void onClick(){
        System.out.println("execute......");
           if(eventListener != null){
               Event event = new Event();
               eventListener.callBack(event);
           }
    }
}
