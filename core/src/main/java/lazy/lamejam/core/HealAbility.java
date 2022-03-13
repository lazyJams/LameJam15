package lazy.lamejam.core;

import static lazy.lamejam.core.Ability.Result.OK;
import static lazy.lamejam.core.Ability.Result.PASS;

public class HealAbility extends Ability {

	public HealAbility(int uptime, int abilityPower, int cost, int key) {
		super(uptime, Type.HEAL, abilityPower, cost, key);
	}

	@Override
	public Result onUse(HeroStats stats, HeroStats enemyStats) {
		if((stats.getHealth() + this.abilityPower) < stats.getHealthMax()) {
			stats.relativeHealthChange(this.abilityPower);
			stats.relativeManaChange(-this.cost);
			return OK;
		}
		return PASS;
	}
}
