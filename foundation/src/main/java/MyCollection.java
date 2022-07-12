import java.util.*;

public class MyCollection {
    public static void main(String[] args) {
//        Map<String,Object> map = new HashMap<>();
////        map.entrySet().add("aa");
//        new Hashtable();
//        new LinkedList<String>();
        new ArrayList<>();
//        new TreeSet<>();
//        new HashSet<>();
//        new Vector<>();
////        Collection
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("c");
//        list.add("e");
//        list.add("f");
//        list.add("b");
//        list.add("z");
//        list.add("w");
//        list.add("u");
//        list.add("o");
//        System.out.println(list.toString());
//        Collections.sort(list);
//        System.out.println(list.toString());
        eee eee = new eee();
        eee e1 = new eee();
        String aa = "1234556";
        String ab = "1234556";
        System.out.println(eee == e1);
        System.out.println(eee.equals(e1));
        System.out.println(aa == ab);
        System.out.println(aa.equals(ab));
    }

    static {
        System.out.println("static================");
    }

    public MyCollection() {
        System.out.println("eeeeeeeeeee");
    }
}

class eee extends MyCollection {
    static {
        System.out.println("static3333333333333333333333");
    }

    public eee() {
        System.out.println("----------");

    }
}
