package com.leablogs.pojo;

public class TestNative {
    static {
        System.loadLibrary("native");
    }

    public static void main(String[] args) {
        new TestNative().hello();

    }
    private native void hello();
}

class Test{
    private static String aaa;
    private String bbb;
    private final Integer int1 = null;


    Test() {
        System.out.println("sssssssssssss");
    }

    public  static void bbb(){
        System.out.println("bbbbbbddddddddd");
    }

    public void ddd(){
        System.out.println("222222222222");
    }

    private void eee(){
        System.out.println("--------------");
    }

    protected void wwww(){
        System.out.println("_--------------");
    }
}