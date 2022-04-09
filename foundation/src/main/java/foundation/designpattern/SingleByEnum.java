package foundation.designpattern;

public class SingleByEnum {
	public static void main(String[] args) {
//		SingleByEnum singleByEnum = new SingleByEnum();
//		SingleByEnums.INSTANCE;
	}
	
}

enum SingleByEnums {
	INSTANCE;
	SingleByEnums(){
		
	}

	public SingleByEnums getInstance() {
		return INSTANCE;

	}
}