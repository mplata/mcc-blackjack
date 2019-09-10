package com.techprogramming.games.blackjack;

public enum PlayerStatus {
	
	HIT("TOMAR"),
	STAND("Plantado"),
	LOSE("Derrota"),
	WON("Victoria"),
	TIE("Empate");
	
	private String statusName;
	
	private PlayerStatus(String status) {
		this.statusName = status;
	}
	
	@Override
	public String toString() {
		
		return this.statusName;
	}
}
