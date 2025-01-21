package kg.geeks.game.players;

public class Golem extends Hero{
    private int proofDamage;

    public void setProofDamage(int proofDamage) {
        this.proofDamage = proofDamage;
    }

    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.PROOF);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i] != this) {
                heroes[i].setHealth(heroes[i].getHealth() + this.proofDamage/(heroes.length - 1));
            }
        }
        System.out.println("Golem " + this.getName() + " got himself " + this.proofDamage);
    }
}
