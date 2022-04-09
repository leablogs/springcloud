package foundation.designpattern;

public class SingleByInnerClass {
	public static void main(String[] args) {
		SingleByInnerClass singleByInnerClass = SingleByInnerClass.getInstance();
		SingleByInnerClass singleByInnerClass1 = SingleByInnerClass.getInstance();
		System.out.println(singleByInnerClass==singleByInnerClass1);
		System.out.println(singleByInnerClass.equals(singleByInnerClass1));
	}
	private SingleByInnerClass() {
	}

	private static class SingleInner {
		private static SingleByInnerClass innerClass = new SingleByInnerClass();
	}

	private static SingleByInnerClass getInstance() {
		return SingleInner.innerClass;
	}
}
