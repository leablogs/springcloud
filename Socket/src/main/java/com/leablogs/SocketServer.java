package com.leablogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.ServerSocketChannel;

public class SocketServer {
	private int port = 8082;

	public static void main(String[] args) throws InterruptedException, IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverSocketChannel.socket();
		serverSocket.bind(new InetSocketAddress(9999));
		serverSocket.accept();
//			ServerSocket serverSocket = new ServerSocket(8082);
//			Socket socket = serverSocket.accept();
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			String getString = "";
//			while (!"".equals(getString = bufferedReader.readLine())) {
//				System.out.println(getString);
//			}
//			OutputStream outputStream = socket.getOutputStream();
//			outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
//			outputStream
//					.write("<html><body><a href='http://www.baidu.com'>i am baidu.com</a></body></html>".getBytes());
//			outputStream.flush();
//			outputStream.close();
//			socket.close();
//			serverSocket.close();
//		ServerSocket serverSocket = new ServerSocket(8082, 50);
		ServerSocket serverSock= new ServerSocket();
		serverSocket.bind(new InetSocketAddress(8082), 50);
		System.out.println(serverSocket.isBound());
		Thread.sleep(5000);
		for (int i = 0; i < 1000; i++) {
			System.out.println("accept beagin: " + (i + 1));
			Socket socket = serverSocket.accept();
			System.out.println("accept end: " + (i + 1));
		}
		serverSocket.close();
	}
}
