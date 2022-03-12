package lazy.lamejam.core;

public class HealAbility extends Ability {

	public HealAbility(int uptime, int abilityPower, int cost) {
		super(uptime, Type.HEAL, abilityPower, cost);
	}

	@Override
	public void onUse(HeroStats stats, HeroStats enemyStats) {
		stats.relativeManaChange(-this.cost);
		stats.relativeHealthChange(this.abilityPower);
	}
}
