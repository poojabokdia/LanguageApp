package com.example.pooja.languageapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


public class NumbersActivity extends Activity {
     TextToSpeech tt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        tt1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    Locale spanish = new Locale("es", "ES");
                    tt1.setLanguage(spanish);
                }
            }
        });
        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("one","uno",R.mipmap.one));
        words.add(new Word("two","dos",R.mipmap.two));
        words.add(new Word("three","tres",R.mipmap.three));
        words.add(new Word("four","cuatro",R.mipmap.four));
        words.add(new Word("five","cinco",R.mipmap.five));
        words.add(new Word("six","seis",R.mipmap.six));
        words.add(new Word("seven","siete",R.mipmap.seven));
        words.add(new Word("eight","ocho",R.mipmap.eight));
        words.add(new Word("nine","nueve",R.mipmap.nine));
        words.add(new Word("ten","diez",R.mipmap.ten));


        WordAdapter adapter = new WordAdapter(this,words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word= words.get(position);
                String toSpeak = word.getTranslation().toString();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21(toSpeak);
                } else {
                    ttsUnder20(toSpeak);
                }
                // tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH ,null,null);
            }
        });
    }
    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tt1.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        tt1.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numbers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
