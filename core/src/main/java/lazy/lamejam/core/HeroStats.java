package lazy.lamejam.core;

public class HeroStats {

	private int health;
	private int mana;
	private Ability[] abilities = new Ability[4];
	private int index;

	public static final int Q = 0;
	public static final int W = 1;
	public static final int E = 2;
	public static final int R = 3;

	public HeroStats(int health, int mana) {
		this.health = health;
		this.mana = mana;
	}

	public void addAbility(Ability ability) {
		abilities[index++] = ability;
	}

	public Ability getAbility(int index) {
		return abilities[index];
	}

	public void useAbility(int index, HeroStats enemyStats) {
		if (canUse(abilities[index].cost))
			abilities[index].onUse(this, enemyStats);
	}

	public int getHealth() {
		return health;
	}

	public int getMana() {
		return mana;
	}

	public boolean canUse(int cost) {
		return this.mana - cost >= 0;
	}

	public void relativeManaChange(int amount) {
		this.mana += amount;
	}

	public void relativeHealthChange(int health) {
		this.health += health;
	}
}
