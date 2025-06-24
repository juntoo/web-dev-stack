package com.kh._abstract.step1;

// 추상클래스
public abstract class Sports {
	
	protected int numOfPlayer;
	
	public Sports(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}
	
	// 추상메서드. 즉, 미완성된 메서드. 구현부가 X -> 자식 클래스에서 강제 구현
	public abstract void rule();
}
