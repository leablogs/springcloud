package com.leablogs.websocket.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.leablogs.websocket.service.WebSocketService;

import lombok.Data;

@ServerEndpoint("/ws")
@Component
@Data
public class WebSocketServiceImpl implements WebSocketService {
	private static int onlineCount = 0;
	private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocketSet = new CopyOnWriteArraySet<WebSocketServiceImpl>();
	private Session session;

	@Override
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this);
		addOnlineCount();
		System.out.println("有新链接加入！当前在线人数：" + getOnlineCount());
		try {
			sendMessage("有新的连接加入了！");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IO error");
		}
	}

	@Override
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		subOnlineCount();
		System.out.println("有一个连接关闭！当前在线人数：" + getOnlineCount());

	}

	@Override
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("来自客户端消息：" + message);
		for (WebSocketServiceImpl item : webSocketSet) {
			try {
				String userName = item.getSession().getUserPrincipal().getName();
				System.out.println(userName);
				item.sendMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	private void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	private static synchronized int getOnlineCount() {
		return onlineCount;
	}

	private static void addOnlineCount() {
		WebSocketServiceImpl.onlineCount++;
	}

	private static synchronized void subOnlineCount() {
		WebSocketServiceImpl.onlineCount--;
	}
}
