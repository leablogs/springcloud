package foundation.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

@TestAnnotation(request = { "asda", "ewew", "sdfew" })
public class TestAnn {
	@TestAnnotation(aa = 12)
	private int aa;
	private String bbString;

	@TestAnnotation(value = "wangjiawei")
	public void name() {
		System.err.println("this is name");
	}

	public void name(String s) {

	}

	public TestAnn() {

	}

//	public TestAnn(String s, int i) {
//
//	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException,
			ClassNotFoundException, InstantiationException, IllegalAccessException {
//		TestAnn ann = new TestAnn();
//		Field field = ann.getClass().getDeclaredField("aa");
//		TestAnnotation testAnnotation = field.getAnnotation(TestAnnotation.class);
////		testAnnotation.
//		ann.setAa(testAnnotation.aa());
//		System.out.println(ann.getAa());
//		TestAnn ann2 = new TestAnn();
//		TestAnnotation testAnnotation2 = ann.getClass().getAnnotation(TestAnnotation.class);
//		String[] a = testAnnotation2.request();
//		System.out.println(Arrays.toString(a));
//		Constructor constructor = ann.getClass().getDeclaredConstructor();
//		TestAnnotation coAnnotation = constructor.getClass().getAnnotation(TestAnnotation.class);
////		ann.bbString = coAnnotation.value();
//		System.out.println(coAnnotation.value());
////		TestAnnotation constructors = constructor.getClass().getAnnotation(TestAnnotation.class);
////		System.err.println("construct: " + constructors);
//		Class<Ref> class1 = (Class<Ref>) Class.forName("foundation.Annotation.Ref");
//		Method[] methods = class1.getMethods();
//		Constructor[] constructors = class1.getConstructors();
////		Field[] fields = class1.getFields();
//		Field[] fields = class1.getDeclaredFields();
////		System.out.println(Arrays.toString(methods));
//		for (Method method : methods) {
//			System.out.println(method);
//		}
//		System.out.println("========================");
//		for (Field method : fields) {
//			System.out.println(method);
//		}
//		System.out.println("========================");
//		for (Constructor method : constructors) {
//			System.out.println(method);
//		}
//		new sun.misc.Launcher();
		Annotation[] testAnn = new TestAnn().getClass().getAnnotations();

//		System.out.println(Arrays.toString(testAnn));
		for (Annotation annotation : testAnn) {
//			System.out.println(annotation);
		}
//		System.out.println("---------------");
		Method method;
		try {
			Constructor constructor = new TestAnn().getClass().getConstructor();
			System.err.println(constructor);
//			Constructor constructor1 = new TestAnn().getClass().getConstructor(String.class,int.class);
//			System.err.println(constructor1);
			Class clazz = Class.forName("foundation.Annotation.TestAnn");
			Constructor constructor2 = clazz.getConstructor(null);
			System.out.println(constructor2);
			System.out.println(clazz.getMethod("name", String.class));
			TestAnn testAnn2 = (TestAnn) clazz.newInstance();
			testAnn2.name();
//			method = TestAnn.class.getDeclaredMethod("name", null);
//			TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
//			System.out.println(testAnnotation.value());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Field[] ref = Ref.class.getDeclaredFields();
//		System.out.println(Arrays.toString(ref));
//		new Ref().getClass().getAnnotations();

	}

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

}

class Ref {
	private int aa;
	public int bb;
	protected int cc;

	public Ref() {

	}

	public Ref(int a) {

	}

	private void name() {

	}

	public void name1() {

	}

	protected void name2() {

	}
}
