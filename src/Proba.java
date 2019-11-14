import java.util.ArrayList;
import java.util.List;

import characters.Fighter;
import combat.Battlefield;

public class Proba {

	public static void main(String[] args) {
		Fighter a = new Fighter(1, "Alex", "human", "default", 10, 30);
		Fighter b = new Fighter(1, "Bobo", "human", "default", 10, 30);
		Fighter c = new Fighter(1, "Ceco", "human", "default", 10, 30);
		Fighter d = new Fighter(1, "Gosho", "human", "default", 10, 30);
		Fighter e = new Fighter(1, "Pesho", "human", "default", 10, 30);
		
		Fighter a2 = new Fighter(1, "Alex", "troll", "default", 10, 30);
		Fighter b2 = new Fighter(1, "Bobo", "troll", "default", 10, 30);
		Fighter c2 = new Fighter(1, "Ceco", "troll", "default", 10, 30);
		Fighter d2 = new Fighter(1, "Gosho", "troll", "default", 10, 30);
		Fighter e2 = new Fighter(1, "Pesho", "troll", "default", 10, 30);
		
		List<Fighter> edno = new ArrayList<>();
		List<Fighter> dve = new ArrayList<>();
		edno.add(a);
		edno.add(b);
		edno.add(c);
		edno.add(d);
		edno.add(e);
		
		dve.add(a2);
		dve.add(b2);
		dve.add(c2);
		dve.add(d2);
		dve.add(e2);
		
		Battlefield battle = new Battlefield(edno, dve);
		
		while (!battle.determineWinner().equals("humans") && !battle.determineWinner().equals("trolls")) {
			battle.performRound();
			System.out.println(battle.getRoundCounter());
		}
	}
}
