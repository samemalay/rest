package demo.rest.service;

import demo.rest.model.WordCount;
import demo.rest.utils.Utils;
import org.springframework.stereotype.Component;

import demo.rest.model.Count;
import demo.rest.model.SearchParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SearchService {


    public Count searchCount(SearchParam searchParam) {
        Set<String> words = new HashSet<>(Arrays.asList(searchParam.getSearchText()));
        Map<String, Integer> map = Utils.multiCount(Utils.readData(), words);
        WordCount[] counts = new WordCount[map.size()];
        int i = 0;
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            counts[i] = new WordCount(e.getKey(), e.getValue());
            i++;
        }
        return new Count(counts);
    }

    public void formatTopCount(
            HttpServletResponse response,
            int top
    ) throws IOException {
        String data = Utils.readData();
        List<Map.Entry<String, Integer>> list = Utils.topCount(data, top);
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter pw = response.getWriter();
        for (Map.Entry<String, Integer> e : list )
            pw.println(e.getKey() + "|" + e.getValue());
        pw.close();
    }

}
