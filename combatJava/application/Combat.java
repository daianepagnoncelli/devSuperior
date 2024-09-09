package application;

import entities.Champion;
import java.util.Scanner;

public class Combat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first champion's data:");
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Initial life: ");
        int life1 = sc.nextInt();
        System.out.print("Attack: ");
        int attack1 = sc.nextInt();
        System.out.print("Armor: ");
        int armor1 = sc.nextInt();
        sc.nextLine();

        Champion champion1 = new Champion(name1, life1, attack1, armor1);

        System.out.println("Enter the second champion's data:");
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Initial life: ");
        int life2 = sc.nextInt();
        System.out.print("Attack: ");
        int attack2 = sc.nextInt();
        System.out.print("Armor: ");
        int armor2 = sc.nextInt();

        Champion champion2 = new Champion(name2, life2, attack2, armor2);

        System.out.print("How many turns do you want to execute? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (champion1.getLife() == 0 || champion2.getLife() == 0) {
                break;
            }

            champion1.takeDamage(champion2.getAttack());
            champion2.takeDamage(champion1.getAttack());

            System.out.println("Turn " + i + " result:");
            System.out.println(champion1.status());
            System.out.println(champion2.status());
        }

        System.out.println("END OF COMBAT");

        sc.close();
    }
}

