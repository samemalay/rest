package demo.rest.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = WordCountSerializer.class)
public class WordCount {

    String word;
    int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
