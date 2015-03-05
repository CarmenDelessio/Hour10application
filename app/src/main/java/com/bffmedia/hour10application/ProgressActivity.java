package com.bffmedia.hour10application;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProgressActivity extends Activity {
    ProgressBar progressBar;
    ProgressBar progressBarHorizontal;
    SeekBar seekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBarHorizontal= (ProgressBar) findViewById(R.id.progressBarHorizontal);
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        new ProgressTask().execute();

    }

    class ProgressTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPostExecute(Integer result) {
            progressBar.setVisibility(View.GONE);
            progressBarHorizontal.setVisibility(View.GONE);
            seekBar.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            for (int i=0; i < 5; i++){
                SystemClock.sleep(1000);
                publishProgress(i+1);
            }
            return 0;
        }

        @Override
        protected void onProgressUpdate(Integer... progress){
            progressBarHorizontal.setProgress(progress[0]);
            seekBar.setProgress(progress[0]);
        }
    }
}
