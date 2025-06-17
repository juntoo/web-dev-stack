package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();
		v.method3();
		v.method4();
		v.method5();
		v.method6();
		v.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int adult = 10000;
		int teen = 7000;
		System.out.println(adult * 2 + teen * 3);
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		// 코드 적어주세요!
		int box = x;
		x = y;
		y = z;
		z = box;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}
	
	

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		System.out.print("첫번째 정수 입력 : ");
		int firstNum = Integer.parseInt(sc.nextLine());
		
		System.out.print("두번째 정수 입력 : ");
		int secondNum = Integer.parseInt(sc.nextLine());
		
		int plus = firstNum + secondNum;
		int minus = firstNum - secondNum;
		int multiply = firstNum * secondNum;
		int division = firstNum / secondNum;
		
		System.out.println("첫 번째 정수 : " + firstNum);
		System.out.println("두 번째 정수 : " + secondNum);
		System.out.println("더하기 : " + plus);
		System.out.println("빼기 : " + minus);
		System.out.println("곱하기 : " + multiply);
		System.out.println("나누기 몫 : " + division);
	}

	/*
	 * 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		System.out.print("가로 길이 입력 : ");
		double width = Double.parseDouble(sc.nextLine());
		
		System.out.print("세로 길이 입력 : ");
		double height = Double.parseDouble(sc.nextLine());
		
		double area = width * height;
		double round  = (width + height) * 2;
		
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
		System.out.println("면적 : " + area);
		System.out.println("둘레 : " + round);
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		char chFirst = str.charAt(0);
		char chSecond = str.charAt(1);
		char chLast = str.charAt(str.length()-1);
		
		System.out.println("첫번째 문자 : " + chFirst);
		System.out.println("두번째 문자 : " + chSecond);
		System.out.println("마지막 문자 : " + chLast);
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		System.out.print("문자 하나 입력 : ");
		char ch = sc.nextLine().charAt(0);
		
		int ch2 = ch + 1;
		
		System.out.println("문자 : " + ch);
		System.out.println(ch + " unicode : " + (int) ch);
		System.out.println((char)ch2 + " unicode : " + ch2);
	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		System.out.print("국어 점수 입력 : ");
		int kor = Integer.parseInt(sc.nextLine());
		
		System.out.print("영어 점수 입력 : ");
		int eng = Integer.parseInt(sc.nextLine());
		
		System.out.print("수학 점수 입력 : ");
		int math = Integer.parseInt(sc.nextLine());
		
		int total = kor + eng + math;
		double avr = total / 3.0;
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f", avr);
		
	}

}