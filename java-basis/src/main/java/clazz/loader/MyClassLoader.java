package clazz.loader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
	private String path;

	public MyClassLoader(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classPath = path + name + ".class";
		System.out.println(classPath);
		InputStream inputStream = null;
		ByteArrayOutputStream outputStream = null;

		try {
			inputStream = new FileInputStream(classPath);
			outputStream = new ByteArrayOutputStream();
			int temp = 0;
			while ((temp = inputStream.read()) != -1) {
				outputStream.write(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		byte[] bytes = outputStream.toByteArray();

		return defineClass(name, bytes, 0, bytes.length);

	}
}
