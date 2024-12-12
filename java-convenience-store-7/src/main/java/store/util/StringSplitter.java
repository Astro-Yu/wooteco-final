package store.util;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> splitByDelimiter(String input, String delimiter) {
        String[] splittedinput = input.split(delimiter);

        return Arrays.stream(splittedinput).toList();
    }
}
