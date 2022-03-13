package lazy.lamejam.core;

import com.badlogic.gdx.math.MathUtils;

public class HeroStats {

	private float health, healthMax;
	private float mana, manaMax;
	private float manaRegen;
	private float healthRegen;
	private Ability[] abilities = new Ability[4];
	private int index;

	public static final int Q = 0;
	public static final int W = 1;
	public static final int E = 2;
	public static final int R = 3;

	public HeroStats(int health, int mana, float manaRegen, float healthRegen) {
		this.health = health;
		this.healthMax = health;
		this.mana = mana;
		this.manaMax = mana;
		this.manaRegen = manaRegen;
		this.healthRegen = healthRegen;
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

	public float getHealth() {
		return health;
	}

	public float getMana() {
		return mana;
	}

	public float getHealthMax() {
		return healthMax;
	}

	public void setHealthMax(float healthMax) {
		this.healthMax = healthMax;
	}

	public float getManaMax() {
		return manaMax;
	}

	public void setManaMax(float manaMax) {
		this.manaMax = manaMax;
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

	public void regen() {
		this.mana = Math.min(this.manaMax, (this.manaRegen + this.mana));
		this.health = Math.min(this.healthMax, (this.healthRegen + this.health));
	}
}
