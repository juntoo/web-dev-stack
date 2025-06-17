package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식의 결과가 true이면 값1 반환
	 * - 조건식의 결과가 false이면 값2 반환
	 * */
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
//		f.practice1();
//		f.practice2();
		f.practice3();
	}
	
	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.print("정수값 >> ");
		int number = sc.nextInt();
		
		String result = number > 0 ? "양수" : "음수";
		System.out.println(result);
		
		// +) 0인 경우는 0입니다.		
		result = number > 0 ? "양수" : number == 0 ? "0입니다" : "음수";
		System.out.println(result);
	}
	
	/*
	 * 문제 1
	 * 사용자한테 두 개의 정수값을 입력 받아서 두 정수의 곱셈 결과 100보다 크거나 같은 경우
	 * "결과가 100 이상입니다" 아닌 경우 "결과가 100보다 작습니다" 출력
	 * */
	public void practice1() {
		System.out.print("첫번째 정수 입력 > ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 정수 입력 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		String result = num1 * num2 >= 100 ? "결과가 100 이상입니다" : "결과가 100보다 작습니다";
		System.out.println(result);
	}
	
	/*
	 * 문제 2
	 * 사용자한테 문자를 하나 입력 받아서 입력한 문자가 대문자이면 "알파벳 대문자입니다"
	 * 소문자이면 "알파벳 소문자입니다", 둘다 아니라면 "알파벳이 아니네요"
	 * */
	public void practice2() {
		System.out.print("문자 입력 > ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch >= 'A' && ch <= 'Z') ? "알파벳 대문자 입니다" :
						(ch >= 'a' && ch <= 'z') ? "알파벳 소문자 입니다" : "알파벳이 아니네요";
		System.out.println(result);
	}
	
	/*
	 * 문제 3
	 * 사용자한테 숫자를 입력받아서 해당 숫자가 알파벳 범위에 들어간다면
	 * "알파벳 D입니다", 아니면 "알파벳이 아닙니다"
	 * */
	public void practice3() {
		System.out.print("숫자 입력 > ");
		int num = Integer.parseInt(sc.nextLine());
		
		String result = (num >= 'A' && num <= 'Z') ? "알파벳 " + (char)num + "입니다" :
						(num >= 'a' && num <= 'z') ? "알파벳 " + (char)num + "입니다" : "알파벳이 아닙니다";
		
		System.out.println(result);
	}
}
