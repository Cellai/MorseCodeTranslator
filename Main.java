package MorseCode;

import java.util.Scanner;

//Huvudklass

public class Main {
    public static void main (String[] args) {

        //Scanner för att läsa in data från användaren
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj 1 för att konvertera text till Morse-kod eller 2 för att konvertera Morse-kod till text:");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Konsumerar newline-tecknet efter nextInt().

        if (choice == 1) {
            System.out.println("Skriv in text att omvandla till Morse-kod (endast bokstäver A-Z hanteras):");
            String input = scanner.nextLine();
            // Anropar logikklassens metod för att översätta text till Morse-kod.
            String morseOutput = MorseCodeTranslator.toMorse(input);
            System.out.println("Morse-kod: " + morseOutput);
        } else if (choice == 2) {
            System.out.println("Skriv in Morse-kod att omvandla till text (separera varje bokstav med ett mellanslag):");
            String input = scanner.nextLine();
            // Anropar logikklassens metod för att översätta Morse-kod till text.
            String textOutput = MorseCodeTranslator.toEnglish(input);
            System.out.println("Text: " + textOutput);
        } else {
            System.out.println("Ogiltigt val");
        }
        scanner.close();
    }
}

