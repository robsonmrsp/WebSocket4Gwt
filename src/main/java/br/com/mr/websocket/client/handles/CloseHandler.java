package br.com.mr.websocket.client.handles;

import br.com.mr.websocket.client.WebSocket;
import br.com.mr.websocket.client.events.CloseEvent;

public interface CloseHandler {
	void onClose(WebSocket webSocket, CloseEvent closeEvent);
}
