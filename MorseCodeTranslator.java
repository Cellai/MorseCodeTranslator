package MorseCode;

import java.util.HashMap;

// Klass som översätter mellan text och Morse-kod (endast bokstäver A-Z).
// Korta signaler representeras med punkt (.) och långa med bindestreck (-).
// Mellanslag ignoreras (inga ordseparationer).
public class MorseCodeTranslator {
    private static final HashMap<Character, String> englishToMorse = new HashMap<>();
    private static final HashMap<String, Character> morseToEnglish = new HashMap<>();

    // Initierar översättningstabellerna med internationell morsekod för bokstäverna A-Z.
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

    // Översätter text till Morse-kod. Endast bokstäver A-Z översätts.
    public static String toMorse(String text) {
        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();
        for (char c : text.toCharArray()) {
            if (englishToMorse.containsKey(c)) {
                morse.append(englishToMorse.get(c)).append(" ");
            }
        }
        return morse.toString().trim();
    }

    // Översätter Morse-kod till text. Varje kod (bokstav) måste vara separerad med ett mellanslag.
    public static String toEnglish(String morse) {
        StringBuilder text = new StringBuilder();
        String[] tokens = morse.split(" ");
        for (String token : tokens) {
            if (morseToEnglish.containsKey(token)) {
                text.append(morseToEnglish.get(token));
            }
        }
        return text.toString();
    }
}

