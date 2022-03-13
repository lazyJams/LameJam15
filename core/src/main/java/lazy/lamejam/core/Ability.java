package lazy.lamejam.core;

import com.badlogic.gdx.Input;

public abstract class Ability {

	protected int uptime;
	protected Type type;
	protected int abilityPower;
	protected int cost;
	protected int key;

	public enum Type {
		HEAL
	}

	public enum Result {
		OK,
		PASS
	}

	public Ability(int uptime, Type type, int abilityPower, int cost, int key) {
		this.uptime = uptime;
		this.type = type;
		this.abilityPower = abilityPower;
		this.cost = cost;
		this.key = key;
	}

	public abstract Result onUse(HeroStats stats, HeroStats enemyStats);
}
