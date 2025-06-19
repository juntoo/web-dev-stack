package com.kh.practice;

import java.util.Arrays;

import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
		l.method1();
		l.method2();
		l.method3();
		l.method4();
		l.method5();
		l.method6();
		
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int num = Integer.parseInt(sc.nextLine());
    	
    	for(int i = num; i > 0; i--) {
    		System.out.println(i);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int num = 1;
    	int sum = 0;
    	
    	while(true) {
    		if(num % 2 == 0) sum -= num;
    		else sum += num;
    		num++;
    		
    		if(sum == 100) {
    			System.out.println(num);
    			break;
    		}
    	}
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == ch) {
    			count++;
    		}
    	}
    	System.out.println(str + " 안에 포함된 " + ch + " 개수 : " + count);
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	int number = 0;
    	
    	while(true) {
    		int random = (int) (Math.random() * 11);
    		System.out.println(random);
    		
    		if(number == random) break;
    	}
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	int arr[] = {0, 0, 0, 0, 0, 0};
    	
    	for(int i = 0; i < 10; i++) {
    		int random = (int) (Math.random() * 6);
    		arr[random] += 1;
    	}

    	for(int i = 0; i < arr.length; i++) {
    		System.out.println(i + 1 + " : " + arr[i]);
    	}
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	String com = "";
    	String user = "";
    	
    	int rps = 0;
    	int draw = 0;
    	int lose = 0;
    	int win = 0;
    	
    	while(true) {
	    	System.out.print("가위바위보 : ");
	    	user = sc.nextLine();
	    	
	    	if(user.equals("가위")) rps = 0;
	    	else if(user.equals("바위")) rps = 1;
	    	else if(user.equals("보")) rps = 2;
	    	else rps = 100;
	    	
	    	int random = (int)(Math.random() * 3);
	    	if(random == 0) com = "가위";
	    	else if(random == 1) com = "바위";
	    	else com = "보";
	    	
	    	System.out.println("컴퓨터 : " + com);
	    	System.out.println(name + " : " + user);
	    	
	    	if(rps - random == 0) {
	    		System.out.printf("비겼습니다.\n\n");
	    		draw++;
	    	}else if(rps - random == -1 || rps - random == 2) {
	    		System.out.printf("졌습니다ㅠㅠ\n\n");
	    		lose++;
	    	}else if(rps - random == 1 || rps - random == -2) {
	    		System.out.println("이겼습니다 !");
	    		win++;
	    		System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d", draw, lose, win);
	    		break;
	    	}else System.out.printf("가위 바위 보 만 입력 해주세요\n\n");
    	}
    	
    }

}


