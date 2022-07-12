package foundation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.HandlerAdapter;
//import sun.misc.Unsafe;

public class BaseMain {
	private String ab;
	private String ac;
	@Override
	public int hashCode() {
		return Objects.hash(ab, ac);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseMain other = (BaseMain) obj;
		return Objects.equals(ab, other.ab) && Objects.equals(ac, other.ac);
	}
	public static void main(String[] args) throws ParseException, IOException {
//		System.out.println(System.currentTimeMillis());
//		System.out.println(Calendar.getInstance().getTimeInMillis());
//		System.out.println(new Date().getTime());
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
//		System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
//		System.out.println(simpleDateFormat.parse("2012-02-25 12:21:32"));
//		System.out.println(simpleDateFormat.parse("2012-02-25 12:21:32").getTime());
//		System.out.println((2 << 17) % 11);
//		System.out.println(Math.pow(2, 18));
		StringBuffer aaString = new StringBuffer("13052319890103023X");
		StringBuffer aString = aaString.reverse();
//		System.out.println(aString);
		char[] chars = aString.toString().toCharArray();
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(stringBuffer.append(chars));
//		System.out.println(chars.toString());
		AnnotatedType[] beanFactory = BeanFactory.class.getAnnotatedInterfaces();
		List arrayList = new  ArrayList<String>();
//		new LinkedList<>();
//		StringBuffer aaString = new StringBuffer("13052319890103023X");
//		StringBuffer aString = aaString.reverse();
////		System.out.println(aString);
//		char[] chars = aString.toString().toCharArray();
//		StringBuffer stringBuffer = new StringBuffer();
//		System.out.println(stringBuffer.append(chars));
////		System.out.println(chars.toString());
//		AnnotatedType[] beanFactory = BeanFactory.class.getAnnotatedInterfaces();
//		List arrayList = new  ArrayList<String>();
//		new LinkedList<>();
//		FileInputStream fileInputStream = new FileInputStream("");
//		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//		serverSocketChannel.accept();
//		serverSocketChannel.bind(null);
//		serverSocketChannel.configureBlocking(false);
//		SocketChannel socketChannel;
		Map map = new HashMap<>();
		map.put("ss", (int) 33);
//		System.out.println(map.toString());
		Queue<String> queue = new LinkedList<String>();
//		queue.add("aaaaa");
		queue.offer("aaaaaa");
//		System.out.println(queue.size());
//		System.out.println(queue.poll());
//		System.out.println(queue.size());
//		System.out.println(queue.poll());
//		System.out.println(queue.size());
//		System.out.println(queue.remove());
//		String aaString = "soft";
		Integer integer = aaString.hashCode();
		System.out.println("b 的hash code：" + integer.hashCode());
		System.out.println("b 的hash code 二进制：" + Integer.toBinaryString(integer));
		int right = integer.hashCode() >>> 16;
		System.out.println("b 的右移16位：" + right);
		System.out.println("b 的右移16位的二进制：" + Integer.toBinaryString(right));
		int aa = integer ^ right;
		System.out.println("b 的hashcode 和 b的hascode右移16位异或结果：" + aa);
		System.out.println("b 的hashcode 和 b的hascode右移16位异或结果二进制：" + Integer.toBinaryString(aa));
	}
}
