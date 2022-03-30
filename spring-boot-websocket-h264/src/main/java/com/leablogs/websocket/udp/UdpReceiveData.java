package com.leablogs.websocket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.leablogs.websocket.ws.WsServerEndPoint;

public class UdpReceiveData extends Thread {
	private DatagramSocket server;
	public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 40, 30, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.DiscardPolicy());

	public UdpReceiveData(int rtpPort) {
		try {
			this.server = new DatagramSocket(rtpPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		openRtp();
	}

	public void startRun() {
		threadPoolExecutor.execute(this);
	}

	/**
	 * RTP的接收UDP 一般情况PT=96 为H264
	 */
	public void openRtp() {
		System.out.println("**********************rtp开始接收数据**********************");
		DatagramPacket client;
		// 一次接收数据的字节数组大小
		byte[] bytes = new byte[1500];
		RtpDataDeal rtpDataDeal = new RtpDataDeal();
		try {
			// 开始收数据
			while (true) {
				// 一次最大能接受2M 且每次需要重新定义否则，下一次的数据长度没这次长时，会将这次的数据填补
				client = new DatagramPacket(bytes, bytes.length);
				server.receive(client);
				// 本次传输数据的长度
				Iterator<Entry<String, WsServerEndPoint>> iterator = WsServerEndPoint.dev_webSocket.entrySet()
						.iterator();
				while (iterator.hasNext()) {
					Map.Entry<String, WsServerEndPoint> entrys = iterator.next();
					System.out.println(entrys.getKey());
					System.out.println(entrys.getValue());
				}
				WsServerEndPoint admin = WsServerEndPoint.dev_webSocket.get("admin");
				if (admin != null) {
					byte[] bytes1 = rtpDataDeal.convergeBytes(client.getData(), client.getLength());
					if (bytes1 != null) {
						admin.sendMessage(bytes1);
					}
				}
			}
		} catch (IOException ignored) {
		} finally {// 关闭
			server.close();
		}
	}
}
