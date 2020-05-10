package lafore.chapter08.exercises.ex8_5;

import java.util.Map;
import java.util.stream.Collectors;

public class HuffmanDecoder {

    public String encodeByHuffmanTable(String input, Map<String, String> huffmanCodes) {
        return input.chars()
                .mapToObj(ch -> String.valueOf((char)(ch)))
                .map(huffmanCodes::get)
                .collect(Collectors.joining());
    }

    public String decodeHuffmanInput(String huffmanInput, Map<String, String> huffmanDecodingTable) {
        StringBuilder huffmanEncodedInput = new StringBuilder(huffmanInput);

        StringBuilder result = new StringBuilder();

        while (huffmanEncodedInput.length() != 0) {
            StringBuilder huffmanSymbol = new StringBuilder();
            while (!huffmanDecodingTable.containsKey(huffmanSymbol.toString())) {
                huffmanSymbol.append(huffmanEncodedInput.charAt(0));
                huffmanEncodedInput.deleteCharAt(0);
            }
            result.append(huffmanDecodingTable.get(huffmanSymbol.toString()));
        }

        return result.toString();
    }
}
