import lombok.Data;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ClassB {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException, InterruptedException {
//        Integer s = 128;
//        System.out.println(s);
//        String aa = "1231121";
//        String ab = new String("1231121");
//        ab.getBytes(StandardCharsets.UTF_8);
//        System.out.println(aa + "ssss");
        cloneTest cloneTest = new cloneTest();
        cloneTest cloneTest1 = (cloneTest) cloneTest.clone();
        System.out.println(cloneTest.equals(cloneTest1));
        System.out.println(cloneTest == cloneTest1);
        String aa = new String();
        aa.wait();

        cloneTest cloneTest2 = new cloneTest();

        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("d:/cloneTest.ser");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);

//            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(cloneTest2);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            outputStream.close();
//            System.out.println("Serialized data is saved in /d:/cloneTest.ser");
            cloneTest cloneTest3 = (cloneTest) objectInputStream.readObject();
            System.out.println(cloneTest3);
            System.out.println(cloneTest3.equals(cloneTest));
            System.out.println(cloneTest3 == cloneTest);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

//        FileInputStream fileInputStream = new FileInputStream("d:/cloneTest.ser");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        cloneTest cloneTest3 = (cloneTest) objectInputStream.readObject();
//        System.out.println(cloneTest3);

    }

    public void flay() {
        short s1 = 1;
        s1 += 1;
        int s2 = 1;
        s2 = s2 + s1;
    }
}

@Data
class cloneTest implements Cloneable, Serializable {
    private int id;
    private int age;

    @Override
    public Object clone() throws CloneNotSupportedException {
        cloneTest cloneTest = (cloneTest) super.clone();
        return cloneTest;
    }
}
