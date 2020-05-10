package lafore.chapter08.exercises.ex8_5;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lafore.chapter08.exercises.ex8_5.HuffmanCodesDisplayHelper.displayCharacterFrequenciesTable;
import static lafore.chapter08.exercises.ex8_5.HuffmanCodesDisplayHelper.displayHuffmanCodesTable;

public class HuffmanApp {

    public static void main(String[] args) throws IOException {
        HuffmanBuilder huffmanBuilder = new HuffmanBuilder();
        HuffmanDecoder huffmanDecoder = new HuffmanDecoder();

        while (true) {
            System.out.print("Enter input string: ");
            System.out.flush();

            String input = getInput();
            if (input.equals("exit\n")) {
                break;
            }

            HuffmanTree huffmanTree = huffmanBuilder.buildTree(input);

            Map<String, String> huffmanCodes = huffmanTree.getHuffmanCodes();
            Map<String, String> huffmanDecodingTable = huffmanCodes.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

            displayCharacterFrequenciesTable(input);
            displayHuffmanCodesTable(huffmanCodes);
            huffmanTree.displayTree();

            String encodedInput = huffmanDecoder.encodeByHuffmanTable(input, huffmanCodes);

            System.out.println("encoded input: " + encodedInput);
            System.out.println("decoded input: " + huffmanDecoder.decodeHuffmanInput(encodedInput, huffmanDecodingTable));
        }
    }

    public static String getInput() {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!(line = scanner.nextLine()).equals("")) {
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
