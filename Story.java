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

public class Story {
    Scene startScene;
    private Character player;
    Scanner scanner;

    public Story(Scene startScene, Character player) {
        this.startScene = startScene;
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\nSelamat datang di game petualangan: 'Kota Terbengkalai'");
        System.out.println("Karakter: " + player.getName());
        System.out.println("HP: " + player.getHealth() + " | XP: " + player.getXP());
        play();
    }

    public void play() {
        Scene currentScene = startScene;

        while (currentScene != null) {
            currentScene.displayScene();

            System.out.print("\nKetik pilihan (A/B/C) atau 'INFO' untuk cek status: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("INFO")) {
                System.out.println("\n--- STATUS KARAKTER ---");
                System.out.println("Nama: " + player.getName());
                System.out.println("HP: " + player.getHealth());
                System.out.println("XP: " + player.getXP());
                continue; // ulangi scene yang sama
            }

            Scene nextScene = currentScene.makeChoice(input, player);

            if (nextScene == null) {
                System.out.println("Input tidak valid. Coba lagi.");
            } else {
                currentScene = nextScene;
                if (currentScene.isEndScene()) {
                    currentScene.displayScene();
                    System.out.println("\nPermainan selesai.");
                    System.out.println("Final HP: " + player.getHealth() + ", XP: " + player.getXP());
                    break;
                }
            }
        }

        scanner.close();
    }

    // --- Main method for quick test ---
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama karakter: ");
        String name = input.nextLine();

        Character player = new Character(name, 100);

        // Scene akhir
        Scene endScene = new Scene(
            "Kamu berhasil melarikan diri ke luar kota dan menemukan pos militer.",
            "-", null, 0, 0,
            "-", null, 0, 0,
            "-", null, 0, 0
        );

        // Scene awal
        Scene firstScene = new Scene(
            "Kamu melihat kota hancur dengan mayat bergelimpangan. Di depan ada bangunan terbuka.",
            "Masuk ke bangunan", endScene, 10, 5,
            "Mencari jalan memutar", endScene, 0, 5,
            "Berteriak minta tolong", endScene, 15, -5
        );

        Story story = new Story(firstScene, player);
        story.start();
    }
}