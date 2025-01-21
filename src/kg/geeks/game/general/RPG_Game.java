package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss(4000, 50, "Sauron");

        Warrior warrior = new Warrior(290, 10, "Zilon");
        Medic doc = new Medic(250, 5, 15, "Estes");
        Magic magic = new Magic(280, 15,5,"Adora");
        Berserk berserk = new Berserk(260, 20, "Minotavr");
        Medic assistant = new Medic(300, 5, 5, "Lobanov");
        Thor thor = new Thor(200, 25, "Tolya");
        Witcher witcher = new Witcher(600, 0, "Angel");
        Golem golem = new Golem(700, 5, "Golun");

        Hero[] heroes =
                {doc, assistant, witcher, berserk, golem, warrior, thor, magic};
        showStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                    heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
