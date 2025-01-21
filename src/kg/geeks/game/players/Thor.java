package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.STUN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean thorHit = RPG_Game.random.nextBoolean();
        if (thorHit){
            boss.setDamage(0);
            System.out.println("Thor " + this.getName() + " stunned the Boss for one round!");
        }else {
            boss.setDamage(50);
        }
    }
}
