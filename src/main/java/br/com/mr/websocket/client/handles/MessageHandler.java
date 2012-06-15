package br.com.mr.websocket.client.handles;

import br.com.mr.websocket.client.WebSocket;
import br.com.mr.websocket.client.events.MessageEvent;

public interface MessageHandler {
	void onMessage(WebSocket webSocket, MessageEvent messageEvent);
}
