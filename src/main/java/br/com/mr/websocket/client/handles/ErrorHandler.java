package br.com.mr.websocket.client.handles;

import br.com.mr.websocket.client.events.ErrorEvent;
import br.com.mr.websocket.client.WebSocket;



public interface ErrorHandler {
	void onError(WebSocket webSocket, ErrorEvent errorEvent);
}
