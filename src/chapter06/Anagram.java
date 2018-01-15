package chapter06;

import java.io.*;

public class Anagram {

    private char[] word;

    public Anagram(char[] word) {
        this.word = word;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a String to Anagram: ");
        String stringToAnagram = getString();

        Anagram anagramApp = new Anagram(stringToAnagram.toCharArray());

        anagramApp.doAnagram(stringToAnagram.length());

    }

    private void doAnagram(int newSize) {
        if (newSize == 1) { return; }

        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                display();
            }
            rotate(newSize);
        }
    }

    private void rotate(int newSize) {
        int position = word.length - newSize;
        char tmp = word[position];
        for (int i = position + 1; i < word.length; i++) {
            word[i-1] = word[i];
        }
        word[word.length - 1] = tmp;
    }

    private void display() {
        System.out.println(String.valueOf(word));
    }



    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
