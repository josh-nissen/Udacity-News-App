package com.android.nissen.udacity_newsapp;

/**
 * Created by Josh Nissen on 4/6/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
class News {

    // Title of article
    private final String mTitle;

    private final String mAuthor;

    // Which section of new the article comes from
    private final String mSection;

    // Article's date of publication, if available
    private final String mPubDate;

    // Website URL of the article
    private final String mUrl;

    public News (String title, String author, String section, String pubDate, String url){
        mTitle = title;
        mAuthor = author;
        mSection = section;
        mPubDate = pubDate;
        mUrl = url;
    }

    // Getter methods
    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() { return mAuthor; }

    public String getSection() { return mSection; }

    public String getPubDate() {
        return mPubDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
