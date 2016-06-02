package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

/**
 * Created by tmsbn on 6/2/16.
 */
public class ReverseWords extends StringQuestions implements DSABase {

    private String sentence;

    @Override
    public void execute() {

        sentence = InputUtils.getStringFromUser("Enter a sentence");
        new SwitchMenu(this).show();
    }

    @Strategy
    public void naiveAlgorithm() {

        int length = sentence.length();
        String reversedSentence = "";
        int space = length;
        for (int i = length - 1; i >= 0; i--) {
            if (sentence.charAt(i) == ' ') {
                reversedSentence += sentence.substring(i + 1, space);
                reversedSentence += " ";
                space = i;
            }

            if (i == 0) {
                reversedSentence += sentence.substring(i, space);
            }
        }
        System.out.println(reversedSentence);

    }

    @Strategy
    public void anotherNaiveAlgorithm() {

        String[] words = sentence.split(" ");
        int length = words.length;
        String reversedSentence = "";

        for (int i = length - 1; i >= 0; i--) {

            if (i != length - 1) {
                reversedSentence += " ";
            }
            reversedSentence += words[i];
        }
        System.out.println(reversedSentence);
    }

    /**
     * Basic strategy
     * 1. Reverse the words
     * 2. Reverse the entire sentence
     */
    @Strategy
    public void o1Algorithm() {

        int length = sentence.length();
        char[] words = sentence.toCharArray();
        int start = 0;
        for (int i = 0; i < length; i++) {

            if (words[i] == ' ') {
                reverse(words, start, i - 1);
                start = i + 1;
            }

            if (i == length - 1) {
                reverse(words, start, i);
            }

        }
        reverse(words, 0, length -1);
        System.out.println(words);
    }

    private void reverse(char[] word, int start, int end) {
        while (start < end) {
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
        }

    }
}
