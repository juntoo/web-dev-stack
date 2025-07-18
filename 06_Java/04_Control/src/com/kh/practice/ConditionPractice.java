package com.kh.practice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionPractice {

	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ConditionPractice c = new ConditionPractice();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
		c.method8();
		c.method9();
		c.method10();
	}

    /*
       입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고 짝수가 아니면 "홀수다"를 출력하세요.
       양수가 아니면 "양수만 입력해주세요."를 출력하세요.
    
       숫자를 한 개 입력하세요 : -8
       양수만 입력해주세요.
     */
    public void method1() {
    	System.out.print("숫자를 한 개 입력하세요 : ");
    	int number = Integer.parseInt(sc.nextLine());
    	
    	if(number > 0) {
    		if(number % 2 == 0) System.out.println("짝수다");
    		else System.out.println("홀수다");
    	} else System.out.println("양수만 입력해주세요");
    }

    /*
        A 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
        피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요.

        피자 조각 수 : 7
        피자 먹는 사람 수 : 10
        2

     */
    public void method2() {
    	System.out.print("피자 조각 수 : ");
    	int cut = Integer.parseInt(sc.nextLine());
    	System.out.print("피자 먹는 사람 수 : ");
    	int people = Integer.parseInt(sc.nextLine());
    	
    	int pizza = people / cut;
    	
    	if(cut < 2 || cut >10) System.out.println("2조각에서 10조각 까지만 나눌수 있습니다.");
		else if (people % cut != 0) {
			pizza++;
			System.out.println(pizza);
		}
    	
    }

    /*
        국어, 영어, 수학 세 과목의 점수를 입력 받고 합계와 평균을 계산하고 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
        (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
        합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
    
        국어점수 : 88 
        수학점수 : 50 
        영어점수 : 40 
        불합격입니다.

        국어점수 : 88
        수학점수 : 50
        영어점수 : 45
        합계 : 183
        평균 : 61.0
        축하합니다, 합격입니다!
     */
    public void method3() {
    	System.out.print("국어점수 : ");
    	int korean = Integer.parseInt(sc.nextLine());
    	System.out.print("영어점수 : ");
    	int english = Integer.parseInt(sc.nextLine());
    	System.out.print("수학점수 : ");
    	int math = Integer.parseInt(sc.nextLine());
    	
    	int total = korean + english + math;
    	double avr = (double)total / 3;
    	
    	if(korean >= 40 && english >= 40 && math >= 40 && avr >= 60) {
			System.out.println("합계 : " + total);
			System.out.printf("평균 : %.1f\n", avr);
			System.out.println("축하합니다, 합격입니다!");
    	}else System.out.println("불합격입니다.");
    }

    /*
        B 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만원 이상 사면 20%를 할인해준다.
        구매한 옷의 가격을 입력했을 때, 지불해야 할 금액을 출력하세요.
        
        구매한 옷 가격 : 580000
        464000
     */
    public void method4() {
    	System.out.print("구매한 옷 가격 : ");
    	int price = Integer.parseInt(sc.nextLine());
    	
    	if(price >= 500000) price *= 0.8;
    	else if(price >= 300000) price *= 0.9;
    	else if(price >= 100000) price *= 0.95;
    	
    	DecimalFormat df = new DecimalFormat("###,###");
    	System.out.println(df.format(price));
    }


    /*
        각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류한다.
        입력받은 각에 따라 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 출력하세요.
     */
    public void method5() {
    	System.out.print("각도 입력 : ");
    	int angle = Integer.parseInt(sc.nextLine());
    	
    	int result = 0;
    	
    	if(angle > 0 && angle < 90) result = 1;
    	else if(angle == 90) result = 2;
    	else if(angle > 90 && angle < 180) result = 3;
    	else if(angle == 180) result = 4;
    	
    	System.out.println(result);
    }


    /*
       아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
       로그인 성공 시 "로그인 성공", 
       아이디가 틀렸을 시 "아이디가 틀렸습니다.",
       비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다.",
       아이디와 비밀번호 둘 다 틀렸을 시 "로그인 실패" 를 출력하세요.

       아이디 : happy
       비밀번호 : 1234
       로그인 성공!

       아이디 : happy
       비밀번호 : 23467
       비밀번호가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 1234
       아이디가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 23456
       로그인 실패
    */
    public void method6() {
    	String id = "happy";
    	String pw = "1234";
    	
    	System.out.print("아이디 : ");
    	String inputId = sc.nextLine();
    	System.out.print("비밀번호 : ");
    	String inputPw = sc.nextLine();
    	
    	if(inputId.equals(id)) {
    		if(inputPw.equals(pw)) System.out.println("로그인 성공!");
    		else System.out.println("비밀번호가 틀렸습니다.");
    	}else if(inputPw.equals(pw)) System.out.println("아이디가 틀렸습니다.");
    	else System.out.println("로그인 실패");
    }

    /*
        키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 저체중 / 정상체중 / 과체중 / 비만을 출력하세요.
        BMI = 몸무게 / (키(cm) * 키(cm)) * 10000 
        BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
        BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
        BMI가 30이상일 경우 고도 비만

        키(cm)를 입력해 주세요 : 162
        몸무게(kg)를 입력해 주세요 : 46
        BMI 지수 : 17.527815881725342
        저체중

     */
    public void method7() {
    	System.out.print("키(cm)를 입력해 주세요 : ");
    	double height = Double.parseDouble(sc.nextLine());
    	System.out.print("몸무게(kg)를 입력해 주세요 : ");
    	double weight = Double.parseDouble(sc.nextLine());
    	
    	double bmi = weight / (height * height) * 10000;
    	
    	String result = "저체중";
    	
    	System.out.println("BMI 지수 : " + bmi);

    	if(bmi >= 30) result = "고도 비만";
    	else if(bmi >= 25) result = "비만";
    	else if(bmi >= 23) result = "과체중";
    	else if(bmi >= 18.5) result = "정상체중";
    	
    	System.out.println(result);
    }

    /*
        두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
        (단, 양수가 아닌 값을 입력하거나 제시되어 있지 않은 연산 기호를 입력 했을 시 
        "잘못 입력하셨습니다. 프로그램을 종료합니다." 출력)

        숫자 입력 : 15
        숫자 입력 : 4
        연산자를 입력(+,-,*,/,%) : /
        15 / 4 = 3

     */
    public void method8() {
    	System.out.print("숫자 입력 : ");
    	int num1 = Integer.parseInt(sc.nextLine());
    	if(num1 <= 0) {
    		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다."); 
    		return;
    	}
    	System.out.print("숫자 입력 : ");
    	int num2 = Integer.parseInt(sc.nextLine());
    	if(num2 <= 0) {
    		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다."); 
    		return;
    	}
    	System.out.print("연산자를 입력(+,-,*,/,%) : ");
    	char ch = sc.nextLine().charAt(0);
//    	if(!(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%')) {
//    		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다."); 
//    		return;
//    	}
    	
    	int result = 0;
    	
    	switch(ch) {
    		case '+' : result = num1 + num2; break;
    		case '-' : result = num1 - num2; break;
    		case '*' : result = num1 * num2; break;
    		case '/' : result = num1 / num2; break;
    		case '%' : result = num1 % num2; break;
    		default : System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다."); return;
    	}
    	System.out.printf("%d %c %d = %d\n", num1, ch, num2, result);
    }

    /*
      아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를, 종료 번호를 누르면 “프로그램이 종료됩니다.”를 출력하세요

        1. 입력
        2. 수정
        3. 조회
        4. 삭제
        9. 종료
        메뉴 번호를 입력하세요 : 3
        조회 메뉴입니다.
     */
    public void method9() {
    	System.out.printf("1. 입력\n2. 수정\n3. 조회\n4. 삭제\n9. 종료\n");
    	System.out.print("메뉴 번호를 입력하세요 : ");
    	int select = Integer.parseInt(sc.nextLine());
    	
    	String result = "";
    	
    	switch(select) {
    		case 1 : result = "입력 메뉴 입니다."; break;
    		case 2 : result = "수정 메뉴 입니다."; break;
    		case 3 : result = "조회 메뉴 입니다."; break;
    		case 4 : result = "삭제 메뉴 입니다."; break;
    		case 9 : result = "프로그램이 종료됩니다."; break;
    		default : System.out.println("올바른 번호만 입력하세요");
    	}
    	System.out.println(result);
    }

    /*
        중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
        총점 100점 중 배점으로는 다음과 같다.
        중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)

        이때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력

        총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
        아니면 Fail을 출력하세요.

        중간 고사 점수 : 80
        기말 고사 점수 : 90
        과제 점수 : 50
        출석 횟수 : 15
        ===========결과==========
        중간 고사 점수(20) : 16.0
        기말 고사 점수(30) : 27.0
        과제 점수 (30) : 15.0
        출석 점수 (20) : 15.0
        총점 : 73.0
        PASS

        중간 고사 점수 : 80
        기말 고사 점수 : 30
        과제 점수 : 60
        출석 횟수 : 18
        ===========결과==========
        FAIL [점수 미달] (총점 61.0)

        중간 고사 점수 : 90
        기말 고사 점수 : 100
        과제 점수 : 80
        출석 횟수 : 13
        ===========결과==========
        FAIL [출석 횟수 부족] (13/20)

        중간 고사 점수 : 100
        기말 고사 점수 : 80
        과제 점수 : 40
        출석 횟수 : 10
        ===========결과==========
        FAIL [출석 횟수 부족] (10/20)
        FAIL [점수 미달] (총점 66.0)

     */
    public void method10() {
    	System.out.print("중간 고사 점수 : ");
    	double midExam = Double.parseDouble(sc.nextLine());
    	System.out.print("기말 고사 점수 : ");
    	double finalExam = Double.parseDouble(sc.nextLine());
    	System.out.print("과제 점수 : ");
    	double homework = Double.parseDouble(sc.nextLine());
    	System.out.print("출석 횟수 : ");
    	double attendance = Double.parseDouble(sc.nextLine());
    	
    	System.out.println("===========결과==========");
    	
    	double total = (midExam * 0.2) + (finalExam * 0.3) + (homework * 0.3) + (attendance);
    	
    	if(total >= 70 && attendance >= (20 * 0.7)) {
    		System.out.printf("중간 고사 점수(20) : %.1f\n", midExam * 0.2);
    		System.out.printf("기말 고사 점수(30) : %.1f\n", finalExam * 0.3);
    		System.out.printf("과제 점수(30) : %.1f\n", homework * 0.3);
    		System.out.printf("출석 점수(20) : %.1f\n", attendance);
    		System.out.printf("총점 : %.1f\nPASS", total);
    		
    	}
    	if(attendance < (20 * 0.7)) System.out.printf("FAIL [출석 횟수 부족] (%d/20)\n", (int)attendance);
    	if(total < 70) System.out.printf("FAIL [점수 미달] (총점 %.1f)", total);
    }
    
}