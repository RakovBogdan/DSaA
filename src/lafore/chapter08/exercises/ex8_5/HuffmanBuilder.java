package lafore.chapter08.exercises.ex8_5;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HuffmanBuilder {

    public HuffmanTree buildTree(String input) {

        Map<Character, Integer> charFrequencies = input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toMap(Function.identity(), ch -> 1, Math::addExact));

        PriorityQueue<HuffmanTree> huffmanTrees =
                new PriorityQueue<>(Comparator.comparing(HuffmanTree::getRootFrequency));

        charFrequencies.entrySet().stream()
                .map(entry -> new HuffmanTree(String.valueOf(entry.getKey()), entry.getValue()))
                .forEach(huffmanTrees::add);

        while (huffmanTrees.size() != 1) {
            HuffmanTree firstTree = huffmanTrees.remove();
            HuffmanTree secondTree = huffmanTrees.remove();
            int sumOfFrequencies = firstTree.getRootFrequency() + secondTree.getRootFrequency();

            HuffmanTree parentTree = new HuffmanTree(String.valueOf(sumOfFrequencies), sumOfFrequencies);
            parentTree.insertLeftTree(firstTree);
            parentTree.insertRightTree(secondTree);

            huffmanTrees.add(parentTree);
        }

        return huffmanTrees.remove();
    }
}
