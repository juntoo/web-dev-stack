package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
//		o.method1();
//		o.method2();
//		o.method3();
//		o.method4();
//		o.method5();
//		o.method6();
		o.method7();
//		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원 수 : ");
		int people = Integer.parseInt(sc.nextLine());
		System.out.print("연필 개수 : ");
		int pencil = Integer.parseInt(sc.nextLine());
		
		int division = pencil /people; // 몫
		int remaind = pencil % people; // 나머지
		
		System.out.println("인당 나눠가진 연필 개수 : " + division);
		System.out.println("남은 연필 개수 : " + remaind);
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		int calc = num / 100 * 100;
		System.out.println("십의 자리 이하 버림 : " + calc);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("첫번째 숫자 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째 숫자 입력 : ");
		int num3 = Integer.parseInt(sc.nextLine());
		
		boolean same = num1 == num2 && num2 == num3;
		System.out.println("숫자 동일 여부 : " + same);
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.print("정수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		String result = num % 2 == 0 ? "짝수다" : "짝수가 아니다";
		System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.print("주민번호 입력 : ");
		String str = sc.nextLine();
		
		int noStr = Integer.parseInt(str.substring(7, 8));
		
		System.out.println(noStr == 1 || noStr == 3 ? "남자" : 
							noStr == 2 || noStr == 4 ? "여자" : "사람아니야..");
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.print("나이 입력 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		String result = age <= 0 ? "그런 나이는 없습니다" : age <= 13 ? "어린이" : age <= 19 ? "청소년" : "성인";
		
		System.out.println(result);
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.print("사과의 개수 입력 : ");
		int apple = Integer.parseInt(sc.nextLine());
		System.out.print("바구니의 크기 입력 : ");
		int bucket = Integer.parseInt(sc.nextLine());
		
		int needBucket = apple % bucket == 0 ? apple / bucket : apple / bucket + 1;
		System.out.println("필요한 바구니 수 : " + needBucket);
	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.print("초 단위 시간 입력 : ");
		int input = Integer.parseInt(sc.nextLine());
		
		int second = input % 60;
		int minute = input / 60 % 60;
		int hour = input / 60 / 60;
		
		System.out.println(hour + "시간 " + minute + "분 " + second + "초");
	}
	
}