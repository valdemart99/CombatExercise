package characters;

public class Fighter {
	private int id;
	private String name;
	private String race;
	private String behaviour;
	private int power;
	private int life;
	
	public Fighter(int id, String name, String race, String behaviour, int power, int life) {
		this.id = id;
		this.name = name;
		this.race = race;
		this.behaviour = behaviour;
		this.power = power;
		this.life = life;
	}

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public int getLife() {
		return life;
	}

	public void changeLife(int life) {
		this.life -= life;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRace() {
		return race;
	}

	public int getPower() {
		return power;
	}
}
