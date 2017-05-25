package com.devcrocod.spbunews.objects;

import com.devcrocod.spbunews.enums.SearchType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Scope("singleton")
public class SearchCriteria {

    private String text;

    private SearchType searchType = SearchType.TITLE;

    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
