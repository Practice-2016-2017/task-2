package com.devcrocod.spbunews.objects;

import com.devcrocod.spbunews.enums.SearchType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * This class defines criteria of search
 * 
 */
@Component
@Scope("singleton")
public class SearchCriteria {

    private String text;

    private SearchType searchType = SearchType.TITLE;

    private Date date;

    /**
     * Gets text
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text of search criteria
     *
     * @param text to be set
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     * Gets search type
     *
     * @return searchType
     */
    public SearchType getSearchType() {
        return searchType;
    }

    /**
     *
     * @param searchType
     */
    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    /**
     * Gets date
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date as search criteria
     * 
     * @param date to be set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
