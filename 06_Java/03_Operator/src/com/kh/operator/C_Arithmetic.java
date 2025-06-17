package com.kh.operator;

public class C_Arithmetic {
	/*
	 * 산술 연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지
	 * */
	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();
	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("+ : " + (num1 + num2)); // 13
		System.out.println("- : " + (num1 - num2)); // 7
		System.out.println("* : " + (num1 * num2)); // 30
		System.out.println("/ : " + (num1 / num2)); // 3 - 나누기 몫
		System.out.println("% : " + (num1 % num2)); // 1
	}
	
	public void method2() {
		int a = 5; // 6
		int b = 10; // 10
		int c = (++a) + b++; // 15
		int d = c / a; // 1
		int e = c % a; // 5
		int f = e++; // 4 
		int g = (--b) + (d--); // 12
		int h = c-- * b; // 160
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); // 39
		
		// i값은? 39
		System.out.println(i);
	}
}
