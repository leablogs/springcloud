import java.util.List;

public class ClassA {
    public List<Child> children;
    public CellPhone cellPhone;
}

class Child {
    public ClassA classA(){
        return new ClassA();
    }
    public  void aa(){

    }
}

class CellPhone extends Child {
    public final  void  aa(){

    }
}
