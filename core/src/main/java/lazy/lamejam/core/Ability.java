package lazy.lamejam.core;

public abstract class Ability {

	protected int uptime;
	protected Type type;
	protected int abilityPower;
	protected int cost;

	public enum Type {
		HEAL
	}

	public Ability(int uptime, Type type, int abilityPower, int cost) {
		this.uptime = uptime;
		this.type = type;
		this.abilityPower = abilityPower;
		this.cost = cost;
	}

	public abstract void onUse(HeroStats stats, HeroStats enemyStats);
}
