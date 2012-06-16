package br.com.mr.websocket.client;

import br.com.mr.websocket.client.data.ArrayBufferView;
import br.com.mr.websocket.client.data.JsBlob;
import br.com.mr.websocket.client.handles.CloseHandler;
import br.com.mr.websocket.client.handles.ErrorHandler;
import br.com.mr.websocket.client.handles.MessageHandler;
import br.com.mr.websocket.client.handles.OpenHandler;

import com.google.gwt.core.client.JavaScriptObject;

//[Constructor(DOMString url, optional (DOMString or DOMString[]) protocols)]
//interface WebSocket : EventTarget {
//  readonly attribute DOMString url;
//
//  // ready state
//  const unsigned short CONNECTING = 0;
//  const unsigned short OPEN = 1;
//  const unsigned short CLOSING = 2;
//  const unsigned short CLOSED = 3;
//  readonly attribute unsigned short readyState;
//  readonly attribute unsigned long bufferedAmount;
//
//  // networking
//  [TreatNonCallableAsNull] attribute Function? onopen;
//  [TreatNonCallableAsNull] attribute Function? onerror;
//  [TreatNonCallableAsNull] attribute Function? onclose;
//  readonly attribute DOMString extensions;
//  readonly attribute DOMString protocol;
//  void close([Clamp] optional unsigned short code, optional DOMString reason);
//
//  // messaging
//  [TreatNonCallableAsNull] attribute Function? onmessage;
//           attribute DOMString binaryType;
//  void send(DOMString data);
//  void send(ArrayBufferView data);
//  void send(Blob data);
//};
public class WebSocket extends JavaScriptObject {

	public static final int CONNECTING = 0;
	public static final int OPEN = 1;
	public static final int CLOSING = 2;
	public static final int CLOSED = 3;

	protected WebSocket() {
	}

	public static native WebSocket create(String url) /*-{
		return new WebSocket(url);
	}-*/;

	public static native WebSocket create(String url, String protocol) /*-{
		return new WebSocket(url, protocol);
	}-*/;

	public final native String getExtensions() /*-{
		return this.extensions;
	}-*/;

	public final native void close() /*-{
		this.close();
	}-*/;

	public final native int getBufferedAmount() /*-{
		return this.bufferedAmount;
	}-*/;

	public final native short getReadyState() /*-{
		return this.readyState;
	}-*/;

	public final native String getURL() /*-{
		return this.url;
	}-*/;

	public boolean send(String data) throws IncorrectStateException{
		if(getReadyState() != OPEN){
			throw new IncorrectStateException("Be Sure connected [ URL: " +getURL()+",state: "+getReadyState()+" ]");
		}
		return send(data);
	}
		
	private final native boolean _send(String data) /*-{
		return this.send(data);
	}-*/;

	public static final native void send(ArrayBufferView data) /*-{
		//TODO 
	}-*/;

	public static final native void send(JsBlob data) /*-{
		//TODO 
	}-*/;

	public native void setErrorHandler(ErrorHandler handler)/*-{
		var that = this;
		this.onerror = function(e) {
			handler.@br.com.mr.websocket.client.handles.ErrorHandler::onError(Lbr/com/mr/websocket/client/WebSocket;Lbr/com/mr/websocket/client/events/ErrorEvent;)(that, e);
		};
	}-*/;

	public native void setCloseHandler(CloseHandler handler)/*-{
		var that = this;
		this.onclose = function(e) {
			handler.@br.com.mr.websocket.client.handles.CloseHandler::onClose(Lbr/com/mr/websocket/client/WebSocket;Lbr/com/mr/websocket/client/events/CloseEvent;)(that, e);
		};
	}-*/;

	public native void setOpenHandler(OpenHandler handler)/*-{
		var that = this;
		this.onopen = function(e) {
			handler.@br.com.mr.websocket.client.handles.OpenHandler::onOpen(Lbr/com/mr/websocket/client/WebSocket;Lbr/com/mr/websocket/client/events/OpenEvent;)(that, e);
		};
	}-*/;

	public native void setMessageHandler(MessageHandler handler)/*-{
		var that = this;
		this.onmessage = function(e) {
			handler.@br.com.mr.websocket.client.handles.MessageHandler::onMessage(Lbr/com/mr/websocket/client/WebSocket;Lbr/com/mr/websocket/client/events/MessageEvent;)(that, e);
		};
	}-*/;
}