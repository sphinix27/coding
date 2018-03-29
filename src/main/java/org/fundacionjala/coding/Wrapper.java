package org.fundacionjala.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Wrapper {
    public static String wrap(String sentences, int columnsNumber) {
//        String[] lines = sentences.concat(" ").split("[\\w\\s,.]{0,15}(?:\\s)");
//        String[] lines = sentences.split(" ");
        Pattern pattern = Pattern.compile("[\\w\\s,.]{0,15}(?:\\s)");
        Matcher matcher = pattern.matcher(sentences.concat(" "));
        List<String> lines = new ArrayList<>();
        while (matcher.find()) {
            lines.add(matcher.group());
        }
        lines = lines.stream().map(String::trim).collect(Collectors.toList());
        return String.join("\n", lines);
    }
}
