package collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 9:49
 */

public class MyHashMap {
    public static void main(String[] args) {
        Map<String,Integer> haspMap = new HashMap<>();
        Integer a = haspMap.get("a");

        haspMap.put("a",10);
        haspMap.put("a",20);
        System.out.println(haspMap.get("a"));


    }
}
