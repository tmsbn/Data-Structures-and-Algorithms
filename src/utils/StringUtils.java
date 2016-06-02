package utils;

/**
 * Created by tmsbn on 3/3/16.
 */
public class StringUtils {

    public static final String lineSeparator = "\n----------------------------\n";


    public static String splitCamelCase(String s) {
        s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }




}
