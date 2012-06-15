package br.com.mr.websocket.client;

import br.com.mr.websocket.client.events.CloseEvent;
import br.com.mr.websocket.client.events.MessageEvent;
import br.com.mr.websocket.client.events.OpenEvent;
import br.com.mr.websocket.client.handles.CloseHandler;
import br.com.mr.websocket.client.handles.MessageHandler;
import br.com.mr.websocket.client.handles.OpenHandler;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebSocket4Gwt implements EntryPoint {

	public void onModuleLoad() {
		WebSocket webSocket = WebSocket.create("");
		webSocket.setCloseHandler(new CloseHandler() {
			@Override
			public void onClose(WebSocket webSocket, CloseEvent closeEvent) {
				System.out.println("WebSocket4Gwt.onModuleLoad().new CloseHandler() {...}.onClose()");
			}
		});

		webSocket.setOpenHandler(new OpenHandler() {
			@Override
			public void onOpen(WebSocket webSocket, OpenEvent openEvent) {
				System.out.println("WebSocket4Gwt.onModuleLoad().new OpenHandler() {...}.onOpen()");
			}
		});
		webSocket.setMessageHandler(new MessageHandler() {

			@Override
			public void onMessage(WebSocket webSocket, MessageEvent messageEvent) {
				System.out.println("WebSocket4Gwt.onModuleLoad().new MessageHandler() {...}.onMessage() " + messageEvent.getData());
			}
		});
		
		webSocket.send("Olá do outro lado");
		
	}
}
