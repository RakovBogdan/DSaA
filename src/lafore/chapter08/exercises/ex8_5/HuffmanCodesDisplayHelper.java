package lafore.chapter08.exercises.ex8_5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HuffmanCodesDisplayHelper {

    public static void displayHuffmanCodesTable(Map<String, String> huffmanCodes) {
        Map<String, String> escapedCodes = huffmanCodes.entrySet().stream()
                .collect(Collectors.toMap(e -> escapeIfSpecialCharacter(e.getKey()), Map.Entry::getValue));
        System.out.println(escapedCodes);
    }

    public static void displayCharacterFrequenciesTable(String input) {
        Map<String, Integer> frequenciesTable = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(ch -> escapeIfSpecialCharacter(String.valueOf(ch)), ch -> 1, Math::addExact));
        System.out.println(frequenciesTable);
    }

    public static String escapeIfSpecialCharacter(String character) {
        return specialCharactersMapping.getOrDefault(character, character);
    }

    private static final Map<String, String> specialCharactersMapping = new HashMap<>();
    static {
        specialCharactersMapping.put(" ", "sp");
        specialCharactersMapping.put("\n", "\\n");
        specialCharactersMapping.put("\t", "\\t");
    }
}
