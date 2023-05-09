import collections.map.HashMap;
import collections.map.Map;

public class Mnemonics {

    // uninstantiable class
    private Mnemonics() {}

    private static Map<Character, Integer> keypad;

    static {
        keypad = new HashMap<>();

        String alphabet = "abcedfghijklmnopqrstuvwxyz";
        String keys = "22233344455566677778889999";

        // TODO create keypad map
        keypad = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++) {
            keypad.put(alphabet.charAt(i), Integer.parseInt(String.valueOf(keys.charAt(i))));
        }
    }

    public static String toNumber(String mnemonic) {
        String[] characters = mnemonic.split("");
        StringBuilder result = new StringBuilder();

        for (String character : characters) {
            if (Character.isLetter(character.charAt(0))) {
                result.append(keypad.get(character.charAt(0)));
            }
            else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static String fromDigits(String digits) {
        return "";
    }
}
