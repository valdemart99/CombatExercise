package combat;

import java.util.*;

import characters.*;

public class Battlefield {
	private List<Fighter> sideA;
	private List<Fighter> sideB;
	private int roundCounter;
	private List<Integer> toRemove;
	
	public Battlefield(List<Fighter> sideA, List<Fighter> sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.roundCounter = 0;
	}
	
	public void performRound() {
		CombatRound thisRound = new CombatRound(sideA, sideB);
		thisRound.setVersusList();
		thisRound.resolveRound();
		updateFighters(sideA);
		updateFighters(sideB);
	}
	
	private void updateFighters(List<Fighter> fighters) {
		int index = 0;
		for (Fighter f: fighters) {
			if (f.getLife() <= 0) {
				toRemove.add(index++);
			}
		}
	}
	
	public String determineWinner() {
		if (sideA.size() == 0) {
			return "SideA";
		} else if (sideB.size() == 0) {
			return "SideB";
		} else {
			return "continue";
		}
	}

	public List<Fighter> getSideA() {
		return sideA;
	}

	public void setSideA(List<Fighter> sideA) {
		this.sideA = sideA;
	}

	public List<Fighter> getSideB() {
		return sideB;
	}

	public void setSideB(List<Fighter> sideB) {
		this.sideB = sideB;
	}

	public int getRoundCounter() {
		return roundCounter;
	}

	public void setRoundCounter(int roundCounter) {
		this.roundCounter = roundCounter;
	}
}
