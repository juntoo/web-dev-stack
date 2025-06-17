package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	/*
	 * 논리 연산자
	 * - 두 개의 논리값을 연산해주는 연산자
	 * - 논리연산한 결과마저 논리값
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true일 경우만 결과값이 true
	 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중 하나라도 true일 경우 결과값이 true
	 * */
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.practice();
	}
	
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
		System.out.print("정수값 입력 > ");
		int number = sc.nextInt();
		boolean result = number >= 1 && number <= 100;
		System.out.println(result);
	}
	
	public void method2() {
		int number = 10;
		boolean result = false;
		
		// Short Cut Evaluation
		// &&
		// true && true = true
		// true && false = false
		// false && true  = false
		// false && false = false
		// && 연산자를 기준으로 앞에서 이미 false 이면 뒤쪽 연산 실행 X
		result = (number < 5) && (++number > 0);
		
		System.out.println(result); // false
		System.out.println(number); // 10
		
		// ||
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		// || 연산자를 기준으로 앞에서 이미 true 이면 뒤쪽 연산 실행 X
		result = (number < 20) || (++number > 0);
		
		System.out.println(result); // true
		System.out.println(number); // 10
	}
	/*
	 * 문제
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
	 * */
	public void practice() {
		System.out.print("문자를 입력하세요 > ");
		char ch = sc.nextLine().charAt(0);
		
		System.out.println(ch);
//		boolean result = (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
		boolean result = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
		System.out.println("알파벳? : " + result);
	}
}
