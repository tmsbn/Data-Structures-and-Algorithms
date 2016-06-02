package utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tmsbn on 3/6/16.
 */
public class InputUtils {

    public static int getIntFromUser(String question) {

        System.out.print(question + ":");
        return new Scanner(System.in).nextInt();

    }

    public static String getStringFromUser(String question) {

        System.out.print(question + ":");
        return new Scanner(System.in).next();
    }

    public static Set<String> getWordsFromUser(String question){

        System.out.println(question + ":");
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new HashSet<>();
        while(true){
            String input = scanner.nextLine();
            if(input.isEmpty())
                break;
            else
                words.add(input);

        }
        return words;
    }
}
