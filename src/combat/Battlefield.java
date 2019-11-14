package combat;

import java.util.*;

import characters.*;

public class Battlefield {
	private List<Fighter> humans; 
	private List<Fighter> trolls;
	private int roundCounter;
	
	public Battlefield(List<Fighter> sideA, List<Fighter> sideB) {
		if (sideA.get(0).getRace().equals("troll")) {
			this.humans = sideB;
			this.trolls = sideA;
		} else {
			this.humans = sideA;
			this.trolls = sideB;
		}
		this.roundCounter = 0;
	}
	
	public void performRound() {
		int duelCount = humans.size() >= trolls.size() ? trolls.size() : humans.size();
		
		for (int i = 0; i < duelCount - 1; ++i) {
			changeLifeValue(trolls.get(i), humans.get(i));
		}
		
		for (int j = duelCount - 1; j > -1; j--) {
			removeFallen(j);
		}
		roundCounter++;
	}
	
	private void changeLifeValue(Fighter attacker, Fighter defender) {
		defender.changeLife( - attacker.getPower());
		if (defender.getLife() > 0) {
			attacker.changeLife( - defender.getPower());
		}
	}
	
	private void removeFallen(int index) {
		if (humans.get(index).getLife() <= 0 ) {
			humans.remove(index);
		}
		
		if (trolls.get(index).getLife() <= 0 ) {
			trolls.remove(index);
		}
	}
	
	public String determineWinner() {
		if (humans.isEmpty()) {
			return "humans";
		} else if (trolls.isEmpty()) {
			return "trolls";
		} else {
			return "continue";
		}
	}

	public List<Fighter> getHumans() {
		return humans;
	}

	public List<Fighter> getTrolls() {
		return trolls;
	}

	public int getRoundCounter() {
		return roundCounter;
	}

	public void setRoundCounter(int roundCounter) {
		this.roundCounter = roundCounter;
	}
}
