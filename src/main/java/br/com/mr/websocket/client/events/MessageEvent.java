package br.com.mr.websocket.client.events;

import com.google.gwt.dom.client.NativeEvent;

public class MessageEvent extends NativeEvent {
	
  protected MessageEvent() {
  }

  public final native String getData() /*-{
    return this.data;
  }-*/;
}
