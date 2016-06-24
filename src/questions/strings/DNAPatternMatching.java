package questions.strings;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.StringQuestions;
import utils.InputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tmsbn on 6/4/16.
 */
public class DNAPatternMatching extends StringQuestions implements DSABase {

    String dna = "AACCAACCGGTTTT";
    int patternLength;

    private static Map<Character, Integer> encoding = new HashMap<>();

    static {
        encoding.put('A', 1);
        encoding.put('T', 2);
        encoding.put('C', 3);
        encoding.put('G', 4);

    }


    @Override
    public void execute() {

        patternLength = InputUtils.getIntFromUser("Enter the length of the pattern");
        new SwitchMenu(this).show();
    }

    @Strategy
    public void naiveAlgorithm() {

        int length = dna.length();

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i <= length - patternLength; i++) {
            String pattern = dna.substring(i, i + patternLength);
            int hashCode = pattern.hashCode();

            if (hashMap.get(hashCode) == null) {
                hashMap.put(hashCode, pattern);
            } else {
                System.out.println(hashMap.get(hashCode));
            }
        }

    }

    /**
     * After calculating the hash of the first substring, we use a little trick to calculate the hash of the other substring quickly
     */
    @Strategy
    public void rollingHashMethod() {

        HashMap<Integer, String> hashMap = new HashMap<>();

        int hash = computeHash(dna.substring(0, patternLength), patternLength);
        hashMap.put(hash, "");
        int two_pow_n = (int) Math.pow(2, patternLength);

        int length = dna.length() - patternLength;
        for (int i = 0; i < length; i++) {

            hash = hash - (encoding.get(dna.charAt(i)) * two_pow_n);
            hash = 2 * hash;
            hash = hash + (encoding.get(dna.charAt(i + patternLength)) * 2);

            if (hashMap.get(hash) != null) {
                System.out.println(dna.substring(i + 1, i + patternLength + 1));
            } else {
                hashMap.put(hash, "");
            }


        }

    }

    private int computeHash(String pattern, int n) {

        int hash = 0;
        for (int i = n; i > 0; i--) {

            hash = hash + (int) (Math.pow(2, i) * encoding.get(pattern.charAt(n - i)));
        }
        return hash;

    }

}
