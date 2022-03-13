package lazy.lamejam.core;

import static lazy.lamejam.core.Ability.Result.OK;

public class DamageAbility extends Ability {

	public DamageAbility(int uptime, int abilityPower, int cost, int key) {
		super(uptime, Type.HEAL, abilityPower, cost, key);
	}

	@Override
	public Result onUse(HeroStats stats, HeroStats enemyStats) {
		stats.relativeManaChange(-this.cost);
		enemyStats.relativeHealthChange(-this.abilityPower);
		return OK;
	}
}
