package foundation;

import java.lang.reflect.AnnotatedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;

public class BaseMain {
	public static void main(String[] args) throws ParseException {
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
		DispatcherServlet
	}
}
