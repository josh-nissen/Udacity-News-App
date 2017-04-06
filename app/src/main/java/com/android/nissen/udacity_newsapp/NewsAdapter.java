package com.android.nissen.udacity_newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Josh Nissen on 4/6/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
class NewsAdapter extends ArrayAdapter<News> {

    private static final String AUTHOR_SEPARATOR = " | ";
    private static final String TIME_DATE_SEPARATOR = "T";

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    public View getView (int position, View convertView, @NonNull ViewGroup parent){

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);
        assert currentNews != null;
        String fullTitle = currentNews.getTitle();
        String justTitle;
        String author = currentNews.getAuthor();
        String fullDateTime = currentNews.getPubDate();
        String pubDate;
        String pubTime;
        String section = currentNews.getSection();
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        TextView pubDateView = (TextView) listItemView.findViewById(R.id.pub_date);
        TextView pubTimeView = (TextView) listItemView.findViewById(R.id.pub_time);
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);

        if (fullTitle.contains(AUTHOR_SEPARATOR)) {
            String[] parts = fullTitle.split(AUTHOR_SEPARATOR);
            justTitle = parts[0];
            titleView.setText(justTitle);
            authorView.setText(author);
        } else {

            titleView.setText(fullTitle);
            authorView.setText(author);
        }

        sectionView.setText(section);

        String[] dateParts = fullDateTime.split(TIME_DATE_SEPARATOR);
        pubDate = dateParts[0];
        pubTime = dateParts[1];

        pubDateView.setText(pubDate);
        pubTimeView.setText(pubTime);

        return listItemView;
    }

}
