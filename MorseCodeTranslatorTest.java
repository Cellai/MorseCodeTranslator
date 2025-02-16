package MorseCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

 //JUnit-testklass för att testa MorseCodeTranslator.
 //Här testas översättning av text till Morse-kod och vice versa.

public class MorseCodeTranslatorTest {

    // Test 1: Kontrollera att "SOS" översätts korrekt till Morse-kod.
    @Test
    public void testToMorseSimple() {
        String text = "SOS";
        String expected = "... --- ...";
        String actual = MorseCodeTranslator.toMorse(text);
        assertEquals(expected, actual, "SOS ska översättas till ... --- ...");
    }

    // Test 2: Kontrollera att Morse-koden "... --- ..." översätts korrekt till "SOS".
    @Test
    public void testToEnglishSimple() {
        String morse = "... --- ...";
        String expected = "SOS";
        String actual = MorseCodeTranslator.toEnglish(morse);
        assertEquals(expected, actual, "... --- ... ska översättas till SOS");
    }

    // Test 3: Kontrollera att översättningen är skiftlägesokänslig.
    @Test
    public void testCaseInsensitive() {
        String text = "Hello";
        String expected = ".... . .-.. .-.. ---";
        String actual = MorseCodeTranslator.toMorse(text);
        assertEquals(expected, actual, "Hello ska översättas oberoende av bokstavsstorlek");
    }

    // Test 4: Kontrollera att mellanslag ignoreras (t.ex. "HELLO WORLD" behandlas som "HELLOWORLD").
    @Test
    public void testIgnoreSpaces() {
        String text = "HELLO WORLD";
        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";
        String actual = MorseCodeTranslator.toMorse(text);
        assertEquals(expected, actual, "Mellanslag ska ignoreras vid översättning");
    }

    // Test 5: Kontrollera att okända tecken ignoreras (t.ex. utropstecken).
    @Test
    public void testUnknownCharacter() {
        String text = "HI!";
        // Endast H och I översätts, '!' ignoreras.
        String expected = ".... ..";
        String actual = MorseCodeTranslator.toMorse(text);
        assertEquals(expected, actual, "Okända tecken ska ignoreras vid översättning");
    }
}

