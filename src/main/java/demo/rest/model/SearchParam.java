package demo.rest.model;

public class SearchParam {
    String[] searchText;

    public SearchParam() {
        this(null);
    }

    public SearchParam(String[] searchText) {
        this.searchText = searchText;
    }

    public String[] getSearchText() {
        return searchText;
    }

    public void setSearchText(String[] searchText) {
        this.searchText = searchText;
    }
}
