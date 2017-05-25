package com.devcrocod.spbunews.objects;

import com.devcrocod.spbunews.enums.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
public class Utils {
    private Map<String, SearchType> searchTypeList = new HashMap<String, SearchType>();
    private String searchString;

    @Autowired
    private MessageSource msg;

    public Map<String, SearchType> getSearchTypeList() {
        searchTypeList.clear();
        searchTypeList.put(msg.getMessage("article_date", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.DATE);
        searchTypeList.put(msg.getMessage("editor_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.EDITOR);
        searchTypeList.put(msg.getMessage("article_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.TITLE);
        return searchTypeList;
    }

    public void setSearchTypeList(Map<String, SearchType> searchTypeList) {
        this.searchTypeList = searchTypeList;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
