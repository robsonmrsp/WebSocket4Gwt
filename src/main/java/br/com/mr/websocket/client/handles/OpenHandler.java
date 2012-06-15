package br.com.mr.websocket.client.handles;

import br.com.mr.websocket.client.WebSocket;
import br.com.mr.websocket.client.events.OpenEvent;



public interface OpenHandler {
	void onOpen(WebSocket webSocket , OpenEvent openEvent);
}
