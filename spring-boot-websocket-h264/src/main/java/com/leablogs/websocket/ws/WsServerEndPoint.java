package com.leablogs.websocket.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import org.apache.commons.lang3.StringUtils;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.log4j.Log4j;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 *                 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint(value = "/{devid}") // {}中的数据代表一个参数，多个参数用/分隔
@Component
//@Log4j
public class WsServerEndPoint {
	private static Logger log = LoggerFactory.getLogger(WsServerEndPoint.class);
	// 用来存放每个客户端对应的MyWebSocket对象.若要实现服务端与单一客户端通信的话,可以使用Map来存放,其中Key可以为用户标识
	public static final ConcurrentHashMap<String, WsServerEndPoint> dev_webSocket = new ConcurrentHashMap<>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	private static int onlineCount = 0;
	File file = null;
	/**
	 * 接收userId
	 */
	private String devid = "";

	/**
	 * 连接建立成功调用的方法
	 *
	 * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(@PathParam(value = "devid") String devid, Session session) {
		this.session = session;
		dev_webSocket.put(devid, this); // 加入map中
		addOnlineCount();
		this.devid = devid;
		sendMessage("连接成功");

		file = new File("F:\\JavaProject\\spring-cloud\\spring-boot-websocket-h264\\test1.h264");
//		sendMessage(file);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		dev_webSocket.remove(devid); // 从map中删除
		subOnlineCount();
		log.info(devid + "连接关闭");
//		try {
//			session.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 发生错误时调用
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误" + error.getMessage());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息,必须是json串
	 */
	@OnMessage
	public void onMessage(String message, Session session) {

		log.info("用户消息:" + devid + ",报文:" + message);
		// 可以群发消息
		JSONObject jsonObject = JSON.parseObject(message);
		System.out.println(jsonObject);

//		dev_webSocket.get("devid").
		sendMessage(file);
		// 消息保存到数据库、redis
//		if (StringUtils.isNotBlank(message)) {
//			// 解析发送的报文
//			JSONObject jsonObject = JSON.parseObject(message);
//			// 追加发送人(防止串改)
//			if (jsonObject != null) {
//				jsonObject.put("fromUserId", this.userId);
//				String toUserId = jsonObject.getString("toUserId");
//				// 传送给对应toUserId用户的websocket
//				if (StringUtils.isNotBlank(toUserId) && dev_webSocket.containsKey(toUserId)) {
//					dev_webSocket.get(toUserId).sendMessageByStr(jsonObject.toJSONString());
//				} else {
//					log.error("请求的userId:" + toUserId + "不在该服务器上");
//					// 否则不在这个服务器上，发送到mysql或者redis
//				}
//			}
//		}
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 */
	public void sendMessage(String message) {
		try {
			this.session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("websocket io exception");
		}
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 */
	public void sendMessage(String message, @PathParam("devid") String devid) {
		log.info("消息推送给 :" + devid + "推送消息为 :" + message);
		try {
			if (StringUtils.isNotBlank(message)) {
				for (WsServerEndPoint wsServerEndPoint : dev_webSocket.values()) {
					try {
						if (devid == null) {
							wsServerEndPoint.sendMessage(message);
						} else if (wsServerEndPoint.devid.equals(devid)) {
							wsServerEndPoint.sendMessage(message);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						continue;
					}
				}
			}
			this.session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("websocket io exception");
		}
	}

	public void sendMessage(byte[] video) {
		System.out.println("本帧数据长度为" + video.length);
		try {
			ByteBuffer bf = ByteBuffer.wrap(video);
			this.session.getBasicRemote().sendBinary(bf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessageByStr(String message) {
		if (StringUtils.isNotBlank(message)) {
			try {
				if (this.session.isOpen()) {
					this.session.getBasicRemote().sendText(message);
				}
			} catch (IOException e) {
				log.error("发送到用户：" + this.devid + "信息失败 ，信息是：" + message);
				log.error("websocket send str msg exception: ", e);
			}
		}
	}
//    public void sendMessage(File video) {
//        FileInputStream fi=null;
//        try {
//            fi=new FileInputStream(video);
//            FileChannel channel = fi.getChannel();
//            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
//            while (channel.read(byteBuffer)!=-1){
//                byteBuffer.flip();
//                this.session.getBasicRemote().sendBinary(byteBuffer);
//                byteBuffer.clear();
//                try {
//                    Thread.sleep(30);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (fi!=null){
//                try {
//                    fi.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

	/**
	 * sps / pps / 帧
	 * 
	 * @param file
	 */
	public void sendMessage(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);

			int len = fileInputStream.available();
			byte[] tmp = new byte[len];
			byte[] frame;
			ByteBuffer byteBuffer;
			// 找到帧
			int front = 0;
			int read = fileInputStream.read(tmp);
			System.out.println("读完为-1" + read);
			for (int i = 0; i < len; i++) {
				if (i + 3 > len) {
					return;
				}
				if (tmp[i] == 0 && tmp[i + 1] == 0 && tmp[i + 2] == 0 && tmp[i + 3] == 1) {// 非一次开头
					if (i - 4 < 0) {
						continue;
					}
					frame = new byte[i - front];
					System.arraycopy(tmp, front, frame, 0, frame.length);
					byteBuffer = ByteBuffer.wrap(frame);
					this.session.getBasicRemote().sendBinary(byteBuffer);
//                    System.out.println("发送数据帧长度"+Arrays.toString(frame));

					front = i;
//                    System.out.println("front: " + i);
//					try {
////						Thread.sleep(500);
//						System.out.println("发送一次");
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}
		} catch (IOException e) {
			System.out.println("用户退出网页");
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

//    public void sendMessage(File file) {
//        int count=0;
//        FileInputStream fileInputStream=null;
//        try {
//            fileInputStream= new FileInputStream(file);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int len=fileInputStream.available();
//            byte[] tmp=new byte[len];
//            byte[] frame;
//            ByteBuffer byteBuffer;
//            //找到帧
//            int front=0;
//            int read = fileInputStream.read(tmp);
//            System.out.println("读完为-1:"+read);
//            for (int i=0;i< len;i++){
//                if (i+4>len){
//                    frame=new byte[len-front];
//                    System.arraycopy(tmp,front,frame,0,frame.length);
//                    byteBuffer=ByteBuffer.wrap(frame);
//                    this.session.getBasicRemote().sendBinary(byteBuffer);
//    //                System.out.println("发送数据帧长度"+frame.length);
//                    System.out.println("发送数据帧长度"+Arrays.toString(frame));
//                    return;
//                }
//                if (tmp[i]==0&&tmp[i+1]==0&&tmp[i+2]==0&&tmp[i+3]==1&&tmp[i+4]==103){//非一次开头
//                    if (i-4<0){
//                        continue;
//                    }
//                    frame=new byte[i-front];
//                    System.arraycopy(tmp,front,frame,0,frame.length);
//                    byteBuffer=ByteBuffer.wrap(frame);
//                    this.session.getBasicRemote().sendBinary(byteBuffer);
//                    System.out.println("发送数据帧长度"+Arrays.toString(frame));
//                    try {
//                        Thread.sleep(30);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    front=i;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileInputStream!=null){
//                try {
//                    fileInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
	private static synchronized int getOnlineCount() {
		return onlineCount;
	}

	private static void addOnlineCount() {
		WsServerEndPoint.onlineCount++;
	}

	private static synchronized void subOnlineCount() {
		WsServerEndPoint.onlineCount--;
	}
}