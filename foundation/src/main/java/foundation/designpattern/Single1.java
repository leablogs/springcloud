package foundation.designpattern;

public class Single1 {
//	private volatile static Single1 single1;
	private static Single1 single1;

	private Single1() {
	};

	public static Single1 getInstance() {
		single1 = new Single1();
		return single1;
	}

	public static Single1 getInstance1() {
		if (single1 == null) {
			single1 = new Single1();
		}
		return single1;
	}

	public static synchronized Single1 getInstance2() {
		if (single1 == null) {
			single1 = new Single1();
		}
		return single1;
	}

	public static Single1 getInstance3() {
		if (single1 == null) {
			synchronized (Single1.class) {
				if (single1 == null) {
					single1 = new Single1();
				}
			}
		}
		return single1;
	}
}
