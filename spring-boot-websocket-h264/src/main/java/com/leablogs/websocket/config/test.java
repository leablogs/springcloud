package com.leablogs.websocket.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("a", "aaaa");
		hashMap.put("b", "dddaaaa");
		hashMap.put("c", "aadwwwaa");
		Set sets = hashMap.entrySet();
//		System.out.println(sets);
		Iterator iterator = sets.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
	}
}
