/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Rio
 */
import java.util.Scanner;

public class Character {
    private String name;
    private int health;
    private int xp;
    private String item;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.xp = 0;
        this.item = null;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public void heal(int healPercent) {
        int healed = (int)(this.health * healPercent / 100.0);
        this.health += healed;
        if (this.health > 100) this.health = 100;
    }

    public void addXP(int additionalXP) {
        this.xp += additionalXP;
    }

    public void reduceXP(int amount) {
        this.xp -= amount;
        if (this.xp < 0) this.xp = 0;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getXP() { return xp; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    // --- Main method for testing purposes ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan nama karakter kamu: ");
        String inputName = scanner.nextLine();
        
        Character player = new Character(inputName, 100);

        System.out.println("\n=== Status Karakter ===");
        System.out.println("Nama: " + player.getName());
        System.out.println("HP Awal: " + player.getHealth());
        System.out.println("XP Awal: " + player.getXP());
        scanner.close();
    }
}
