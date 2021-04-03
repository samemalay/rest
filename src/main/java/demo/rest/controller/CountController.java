package demo.rest.controller;

import demo.rest.model.Count;
import demo.rest.model.SearchParam;
import demo.rest.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CountController {

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/top/{top}", produces = "text/csv")
    public void searchForCount(
            HttpServletResponse response,
            @PathVariable int top
    ) throws IOException {
        searchService.formatTopCount(response, top);
    }

    @PostMapping("/search")
    public Count searchForCount(@RequestBody SearchParam searchParam) {
        return searchService.searchCount(searchParam);
    }

}
