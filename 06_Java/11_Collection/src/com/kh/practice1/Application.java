package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Application {

//	public static void main(String[] args) {
//		// 1등 당첨 기준이 로또 번호 6개
//		// 둘 다 랜덤 로또 번호는 1번
//		// 내 번호는 맞출 때 까지
//		Set<Integer> lotto = new HashSet<Integer>();
//		ArrayList<Integer> mylotto = new ArrayList<Integer>();
//		
//		/**로또값 저장
//		 * */
//		while(lotto.size() < 6) {
//			lotto.add((int)(Math.random() * 45 + 1));
//		}
//		
//
//		// 시도횟수 저장
//		int count = 0;
//		
//		while(true) {
//			// 맞은 개수
//			int correct = 0;
//			count++;
//			
//			mylotto.clear();
//			
//			while(mylotto.size() < 6) {
//				int rand = (int)(Math.random() * 45 + 1);
//				
//				if(!mylotto.contains(rand)) {
//					mylotto.add(rand);
//				}
//			}
//			System.out.println("로또 번호 : " + lotto);
//			System.out.println("내 번호 : " + mylotto);
//			
//			ArrayList<Integer> lottoList = new ArrayList<>(lotto);
////			Collections.sort(lottoList);
////			Collections.sort(mylotto);
////			if(mylotto.equals(lottoList)) break;
//			for(int i = 0; i < lotto.size(); i++) {
//				if(mylotto.contains(lottoList.get(i))) correct++;
//			}
//			
//			if(correct == 6) break;
//		}
//		System.out.println("1등! 횟수 : " + count);
//		
//	}
	
	public static void main(String[] args) {
		// 1등 당첨 기준이 로또 번호 6개
		// 둘 다 랜덤 로또 번호는 1번
		// 내 번호는 맞출 때 까지
		Set<Integer> lotto = new HashSet<Integer>();
		ArrayList<Integer> mylotto = new ArrayList<Integer>();
		
		int[] result = new int[4];
		// index: 0 - 2등, 1 - 3등, ...
		
		/**로또값 저장
		 * */
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45 + 1));
		}
		
		ArrayList<Integer> lottoList = new ArrayList<>(lotto);
		
		int bonus = (int)(Math.random() * 45 + 1);
		while(lottoList.contains(bonus)) {
			bonus = (int)(Math.random() * 45 + 1);
		}
		
		// 시도횟수 저장
		int count = 0;
		
		while(true) {
			// 맞은 개수
			int correct = 0;
			count++;
			
			mylotto.clear();
			
			while(mylotto.size() < 6) {
				int rand = (int)(Math.random() * 45 + 1);
				
				if(!mylotto.contains(rand)) {
					mylotto.add(rand);
				}
			}
			
			Collections.sort(mylotto);
			Collections.sort(lottoList);
			
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("2등 보너스 번호 : " + bonus);
			System.out.println("내 번호 : " + mylotto);
			// 맞춘 개수
			for(Integer number : lottoList) {
				if(mylotto.contains(number)) correct++;
			}
			// 보너스 맞춤
			
			if(correct == 6) {
				System.out.println("1등 당첨 까지 걸린 횟수 : " + count);
				for(int i = 0; i < result.length; i++) {
					System.out.print((i+2) + "등 횟수 : " + result[i] + " ");
				}
				break;
			}else if(correct == 5 && mylotto.contains(bonus)) {
				result[0]++;
			}else if(correct == 5) {
				result[1]++;
			}else if(correct == 4) {
				result[2]++;
			}else if(correct == 3) {
				result[3]++;
			}
		}
		
		
	}

}
