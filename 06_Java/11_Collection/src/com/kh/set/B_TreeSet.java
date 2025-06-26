package com.kh.set;

import java.util.TreeSet;
/*
 * TreeSet
 * - 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)
 * - HashSet보다 데이터 추가, 삭제에 시간이 걸림
 * */
public class B_TreeSet {
	
	public void method1() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("전현무");
		set.add("박나래");
		set.add("기안84");
		set.add("키");
		set.add("박나래");
		
		System.out.println(set);
		System.out.println("몇 명이 들어있나요? " + set.size());
		System.out.println("기안84가 포함되어 있나요? " + set.contains("기안84"));
		
		set.remove("박나래"); // 삭제
		System.out.println(set);
		
		set.clear();
		System.out.println("비어있는가? " + set.isEmpty());
	}
	
	public static void main(String[] args) {
		B_TreeSet b = new B_TreeSet();
		b.method1();
	}

}
