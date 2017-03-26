package com.company.task1;

import java.util.*;

/**
 * Created by Matts on 23.03.2017.
 */
public abstract class AbstractStrings {

    private Set<String> set;

    AbstractStrings(List<String> elements) {
        this.set = new HashSet<>(elements);
    }

    public String and(String first, String second) {
        // Determining candidate for loop.
        String compare = first.length() > second.length() ? first : second;
        String other = first.length() <= second.length() ? first : second;
        String result = "";
        for (String s : compare.split(",")) {
            if (set.contains(s) && other.contains(s)) {
                if (!result.isEmpty()) {
                    result += ",";
                }
                result += s;
            }
        }
        return result;
    }

    public String or(String first, String second) {
        Set<String> sum = new HashSet<>();
        sum.addAll(Arrays.asList(first.split(",")));
        sum.addAll(Arrays.asList(second.split(",")));
        String result = "";
        for (String s : sum) {
            if (set.contains(s)) {
                if (!result.isEmpty()) {
                    result += ",";
                }
                result += s;
            }
        }
        return result;
    }
}
