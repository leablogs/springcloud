package foundation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseMain {
	public static void main(String[] args) throws ParseException {
		System.out.println(System.currentTimeMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new Date().getTime());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
		System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
		System.out.println(simpleDateFormat.parse("2012-02-25 12:21:32"));
		System.out.println(simpleDateFormat.parse("2012-02-25 12:21:32").getTime());

	}
}
