package com.kh.condition;

import java.util.Scanner;

public class D_While {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * */
	
	// 1~5까지 출력
	public void method1() {
		int i = 1;
		
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	/*
	 * 무한루프 & break문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다
	 * */
	public void method2() {
		while(true) {
			System.out.print("숫자 입력 > ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println(num);
			
			// 숫자가 0인 경우 중지
			if(num == 0) break;
		}
	}
	
	/*
	 * do {
	 * 		실행 코드
	 * } while(조건식);
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		} while(number == 0);
	}
	
	/**
	 * 숫자 맞히기 게임
	 * 1과 100 사이의 값 중에 정답을 저희가 정하고
	 * 컴퓨터(random)가 맞히도록 몇번만에 끝내는지 출력
	 * 해당 숫자보다 정답이 높으면 Up! 낮으면 Down!
	 * */
	public void method4() {
		int correct = 73;
		int count = 0;
		int max = 100;
		int min = 1;
		
		while(true) {
			int random = (int) (Math.random() * (max - min + 1) + min);
			count += 1;
			
			if(correct > random) {
				System.out.println(random + " Up!");
				min = random + 1;
			}
			else if(correct < random) {
				System.out.println(random + " Down!");
				max = random - 1;
			}
			else {
				System.out.println(random + " 정답!");
				break;
			}
			System.out.println("max : " + max + ", min : " + min);
			
		}
		
		System.out.println("시도 회수 : " + count);
	}
	
	/**
	 * 숫자 맞히기 게임 2
	 * 
	 * 컴퓨터(random) 1과 100 사이의 값 중에
	 * 저희가 정답을 맞히도록 몇번만에 끝내는지 출력
	 * 해당 숫자보다 정답이 높으면 Up! 낮으면 Down!
	 * */
	public void method5() {
		int random = (int)(Math.random() * 100 + 1);
		int count = 0;
		
		while(true) {
			System.out.print("1~100사이의 숫자 입력 > ");
			int number = Integer.parseInt(sc.nextLine());
			++count;
			
			if(random > number) System.out.println(number + " up");
			else if(random < number) System.out.println(number + " down");
			else {
				System.out.println(number + " 정답");
				System.out.println("카운트 : " + count);
				break;
			}
		}
	}
	
	/**
	* ----------------------------------
	* 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	* ----------------------------------
	* 선택 > 1
	* 예금액 > 10000
	* ----------------------------------
	* 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	* ----------------------------------
	* 선택 > 2
	* 출금액 > 5000
	* ----------------------------------
	* 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	* ----------------------------------
	* 선택 > 3
	* 잔고 확인 > 5000
	* ----------------------------------
	* 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	* ----------------------------------
	* 선택 > 4
	* 프로그램 종료
	* */
	public void method6() {
		int account = 0;
		boolean check = true;
		
		while(check) {
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
				case 1 : System.out.print("예금액 > ");
						account += Integer.parseInt(sc.nextLine());
						break;
				case 2 : System.out.print("출금액 > ");
						int out = Integer.parseInt(sc.nextLine());
						if(account - out < 0) System.out.println("잔고가 부족합니다");
						else account -= out;
						break;
				case 3 : System.out.println("잔고 확인 > " + account);
						break;
				case 4 : System.out.println("프로그램 종료");
//						return;
						check = false;
						break;
				default : System.out.println("잘못된 입력입니다");
						break;
			}
		}
	}
	
	public static void main(String[] args) {
		D_While d = new D_While();
		
//		d.method1();
//		d.method2();
//		d.method3();
		d.method4();
//		d.method5();
//		d.method6();
	}

}
