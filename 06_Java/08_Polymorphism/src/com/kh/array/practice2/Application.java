package com.kh.array.practice2;

import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;
import com.kh.array.practice2.view.MemberView;

public class Application {

	public static void main(String[] args) {

		/*
		 * 회원 수가 3명이 최대 등록 가능
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께
		 * '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리!
		 * 
		 * 최대 등록 가능한 회원 수는 3명입니다.
		 * 현재 등록된 회원 수는 ~명입니다.
		 * 1. 새 회원 등록
		 * 		 -> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		 * 			"중복된 아이디입니다. 다시 입력해주세요." 출력 후
		 * 			다시 아이디 입력부터 나올 수 있게 처리
		 * 
		 *          아이디 : 
		 *          이름 : 
		 *          비밀번호 : 
		 *          이메일 : 
		 *          성별(M/F) : 
		 *          나이 : 
		 * 2. 회원 정보 수정
		 * 		-> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		 * 			"회원 정보가 없습니다." 출력 후 다시 메인 화면으로
		 * 			
		 * 		   수정할 회원의 아이디 : 
		 * 		   수정할 이름 : 
		 *         수정할 이메일 : 
		 *         수정할 비밀번호 :
		 * 3. 전체 회원 정보 출력
		 * 		-> 반복문 사용해서 끝!
		 * 9. 끝내기 -> 프로그램 종료
		 * 그 외의 번호 -> 잘못 입력하셨습니다. 다시 입력해주세요
		 * 
		 * 메뉴 번호 : 
		 * */
		MemberView view = new MemberView();
		view.view();
	}

}
