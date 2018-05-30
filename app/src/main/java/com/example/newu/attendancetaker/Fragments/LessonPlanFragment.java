package com.example.newu.attendancetaker.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.newu.attendancetaker.R;

public class LessonPlanFragment extends Fragment {

    public WebView mWebView;
    private TextView lessonDisplayTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_lesson_plan, container, false);

        //lessonDisplayTv = view.findViewById(R.id.lesson_header);

        mWebView = (WebView) view.findViewById(R.id.webview);




        return view;
    }

    public void setLessonText() {

        mWebView.loadUrl("https://google.com");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
    }
}
