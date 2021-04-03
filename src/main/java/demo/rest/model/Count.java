package demo.rest.model;

public class Count {
    WordCount[] counts;

    public Count(WordCount[] counts) {
        this.counts = counts;
    }

    public WordCount[] getCounts() {
        return counts;
    }

    public void setCounts(WordCount[] counts) {
        this.counts = counts;
    }
}

