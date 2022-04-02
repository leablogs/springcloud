package foundation.threadpool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;

import cn.hutool.core.date.DateUtil;
import lombok.extern.log4j.Log4j;

@Log4j
public class MyThreadPool {
	private static final Logger LOGGER = Logger.getLogger(MyThreadPool.class);
	public static void main(String[] args) {
//		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 0, 0, null, null);
//		ThreadLocal threadLocal = new ThreadLocal();
		Date date = DateUtil.date();
//		LOGGER.info(date);
		System.out.println(date);
	}
	
	
}
class ISODateFormate{
	private static final Logger LOG = Logger.getLogger(ISODateFormate.class);
	private static ThreadLocal<DateFormat> dfwithTzLocal = new ThreadLocal<DateFormat>() {
		public DateFormat get() {
			return super.get();
		}
		
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",Locale.ENGLISH);
			
		}
		
		public void remove() {
			super.remove();
		}
		
	};
	public static String converDateToString(Date date) {
		if(date==null) {
			return null;
		}
		try {
			return dfwithTzLocal.get().format(date);
		} catch (Exception e) {
			LOG.error("Error parsing dateString: "+date, e);
			return null;
		}
	}
	
}