package com.leablogs;

import java.util.HashMap;
import java.util.Map;

public class TestStaticMain {
    public TestStaticMain(){
        System.out.println("test static main construct");
    }
    static {
        System.out.println("this is static");
    }
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","shilh");
        map.put("name","wang");
        map.put("null","2232");
        map.put("null","22322");
        System.out.println(map.toString());

        System.out.println(1 & 2);
        TestStaticMain testStaticMain = new TestStaticMain();
        System.out.println("---------------");
    }
}
