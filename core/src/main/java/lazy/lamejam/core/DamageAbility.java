package lazy.lamejam.core;

public class DamageAbility extends Ability {

	public DamageAbility(int uptime, int abilityPower, int cost, int key) {
		super(uptime, Type.HEAL, abilityPower, cost, key);
	}

	@Override
	public void onUse(HeroStats stats, HeroStats enemyStats) {
		stats.relativeManaChange(-this.cost);
		enemyStats.relativeHealthChange(-this.abilityPower);
	}
}
