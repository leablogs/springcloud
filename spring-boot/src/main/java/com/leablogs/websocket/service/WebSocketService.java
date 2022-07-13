package com.leablogs.websocket.service;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.Session;

public interface WebSocketService {
//private static int onlineCount=0;
//private static CopyOnWriteArraySet<web>
	public void onOpen(Session session);

	public void onClose();

	public void onMessage(String message, Session session);

	public void onError(Session session, Throwable error);
}
