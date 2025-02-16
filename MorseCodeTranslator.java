package MorseCode;

import java.util.HashMap;

public class MorseCodeTranslator {
    private static final HashMap<Character, String> englishToMorse = new HashMap<>();
    private static final HashMap<String, Character> morseToEnglish = new HashMap<>();

    static {
        String[][] morseArray = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."},
                {"E", "."}, {"F", "..-."}, {"G", "--."}, {"H", "...."},
                {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
                {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."},
                {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
                {"Y", "-.--"}, {"Z", "--.."}
        };

        for (String[] pair : morseArray) {
            char letter = pair[0].charAt(0);
            String morse = pair[1];
            englishToMorse.put(letter, morse);
            morseToEnglish.put(morse, letter);
        }
    }

    // Översätter text till Morse-kod
    public static String toMorse(String text) {
        if (text == null || text.isEmpty()) {
            return "Fel: Ingen text angiven!";
        }

        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (!englishToMorse.containsKey(c)) {
                return "Fel: Ogiltigt tecken '" + c + "'! Endast bokstäver A-Z stöds.";
            }
            morse.append(englishToMorse.get(c)).append(" ");
        }
        return morse.toString().trim();
    }

    // Översätter Morse-kod till text
    public static String toEnglish(String morse) {
        if (morse == null || morse.isEmpty()) {
            return "Fel: Ingen Morse-kod angiven!";
        }

        StringBuilder text = new StringBuilder();
        String[] tokens = morse.split(" ");

        for (String token : tokens) {
            if (!morseToEnglish.containsKey(token)) {
                return "Fel: Ogiltig Morse-kod '" + token + "'!";
            }
            text.append(morseToEnglish.get(token));
        }
        return text.toString();
    }
}

