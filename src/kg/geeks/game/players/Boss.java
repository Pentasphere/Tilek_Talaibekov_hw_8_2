package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence(Hero[] heroes) {
        int randomIndex = RPG_Game.random.nextInt(heroes.length);
        this.defence = heroes[randomIndex].getAbility();

    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk && this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                    ((Berserk) heroes[i]).setBlockedDamage(this.getDamage() / 5);
                    heroes[i].setHealth(heroes[i].getHealth() -
                            (this.getDamage() - this.getDamage() / 5));

                } else if (heroes[i] instanceof Golem && this.defence != SuperAbility.PROOF) {
                    ((Golem)heroes[i]).setProofDamage((heroes.length - 1) * this.getDamage()/5);
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage() - (heroes.length - 1) * this.getDamage()/5);

                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
        if (this.defence == SuperAbility.STUN && this.getDamage() == 0) {
            this.setDamage(50);
        }
    }

    @Override
    public String toString() {
        return "Boss " + super.toString() + " defence: " + this.defence +
                "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
    }
}
