package lazy.lamejam.core;

public class HealAbility extends Ability {

	public HealAbility(int uptime, int abilityPower, int cost, int key) {
		super(uptime, Type.HEAL, abilityPower, cost, key);
	}

	@Override
	public void onUse(HeroStats stats, HeroStats enemyStats) {
		stats.relativeManaChange(-this.cost);
		stats.relativeHealthChange(this.abilityPower);
	}
}
