package com.kh.map;

import java.util.Map.Entry;

import com.kh.list.model.Person;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/*
 * Properties
 * - HashMap 구버전인 Hashtable(Object, Object)을 상속받아 구현한 것
 * - (String, String) 형태로 단순화된 컬렉션 클래스
 * - 주로 환경설정과 관련된 속성(property)을 저장하는데 사용
 * */
public class B_Properties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		
		Set<Entry<Object, Object>> entrySet = prop.entrySet();
		
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		Set<Object> keySet = prop.keySet();
		for(Object key : keySet) {
			System.out.println(key + " - " + prop.getProperty((String)key));
		}
		
		/*
		 * Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator 를 구현한 객체를 얻어서 사용 
		 * */
		Enumeration en = prop.propertyNames();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + " : " + value);
		}
		
	}

}
