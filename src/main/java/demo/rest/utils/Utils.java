package demo.rest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class.getName());

    public static String readData() {
        try {
            File file = ResourceUtils.getFile("classpath:data.txt");
            InputStream in = new FileInputStream(file);
            byte[] bdata = FileCopyUtils.copyToByteArray(in);
            String data = new String(bdata, StandardCharsets.UTF_8);
            return data;
        } catch (IOException e) {
            log.error(e.getMessage());
            return "NO-DATA";
        }
    }

    public static Map<String, Integer> multiCount(String data, Set<String> words) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        if (words == null || data.length() < 1)
            return counts;

        for (String word: words)
            counts.put(word, 0);

        String[] allWords = data.split("[\\p{Punct}\\s]+");
        for(String word: allWords) {
            int i = counts.getOrDefault(word, -1);
            if (i >= 0)
                counts.put(word, i+1);
        }

        return counts;
    }


    public static List<Map.Entry<String, Integer>> topCount(String data, int top) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        if (data.length() < 1)
            return new ArrayList<>();

        String[] allWords = data.split("[\\p{Punct}\\s]+");
        for(String word: allWords) {
            int i = counts.getOrDefault(word, -1);
            if (i < 0)
                counts.put(word, 1);
            else
                counts.put(word, i+1);
        }

        Set<Map.Entry<String, Integer>> entries = counts.entrySet();
        Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();

        Comparator<Map.Entry<String, Integer>> reverseComparator =
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            };

        return entriesStream
                .sorted(reverseComparator)
                .limit(top)
                .collect(Collectors.toList());
    }
}