package Factory;

import java.util.Scanner;

public class EnemyShipTest {
    public static void main(String[] args) {
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;

        Scanner cin = new Scanner(System.in);

        System.out.println("Which type is enemy? (U/R/B)");
        if (cin.hasNextLine()) {
            String enemyShipOption = cin.nextLine();
            theEnemy = shipFactory.makeEnemyShip(enemyShipOption);
        }

        if (theEnemy != null) {
            doStuffEnemy(theEnemy);
        } else {
            System.out.println("Unknown ship");
        }
    }

    public static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
