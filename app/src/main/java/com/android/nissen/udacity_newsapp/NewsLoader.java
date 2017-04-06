package com.android.nissen.udacity_newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;
import com.android.nissen.udacity_newsapp.MainActivity;

/**
 * Created by Josh Nissen on 4/5/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
class NewsLoader extends AsyncTaskLoader<List<News>>{

    private static final String LOG_TAG = NewsLoader.class.getName();

    private final String mUrl;

    public NewsLoader(Context context) {
        super(context);
        mUrl = MainActivity.NEWS_REQUEST_URL;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        return QueryUtils.fetchNewsData(mUrl);
    }

}
