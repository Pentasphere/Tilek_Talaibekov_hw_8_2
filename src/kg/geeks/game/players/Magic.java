package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
private int damagePoints;
    public Magic(int health, int damage, int damagePoints, String name) {

        super(health, damage, name, SuperAbility.BOOST);
        this.damagePoints = damagePoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getAbility() != SuperAbility.VICTIM) {
                heroes[i].setDamage(heroes[i].getDamage() + this.damagePoints);
            }
        }
        System.out.println("Magic " + this.getName() + " boosted attack of heroes for " + this.damagePoints);
    }
}
