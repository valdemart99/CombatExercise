package combat;

import java.util.*;
import characters.*;

public class CombatRound {
	private int[][] versusList;
	private List<Fighter> currentSideA;
	private List<Fighter> currentSideB;
	
	public CombatRound(List<Fighter> sideA, List<Fighter> sideB) {
		if (sideA.size() >= sideB.size()) {
			this.currentSideA = sideA;
			this.currentSideB = sideB;
		} else {
			this.currentSideA = sideB;
			this.currentSideB = sideA;
		}
		versusList = new int[ (sideA.size() >= sideB.size() ? sideB.size() : sideA.size()) ][2];
	}
	
	public void setVersusList() {
		// revise for different behaviour
		int duelPairIndex = 0;
		for (Fighter f: currentSideB) {
			versusList[duelPairIndex][0] = currentSideA.get(duelPairIndex).getId();
			versusList[duelPairIndex][1] = f.getId();
			duelPairIndex++;
		}
	}
	
	public void resolveRound() {
		for (int i = 0; i < versusList.length; ++i) {
			changeLifeValue(versusList[i][0], versusList[i][1]);
		}
		// call log object
	}
	
	private void changeLifeValue(int id1, int id2) {
		currentSideA.get(id1).changeLife(currentSideB.get(id2).getPower());
		currentSideB.get(id2).changeLife(currentSideA.get(id1).getPower());
	}
}
