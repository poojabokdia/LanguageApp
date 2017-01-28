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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


public class PhrasesActivity extends Activity {
    TextToSpeech tt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        tt1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    Locale spanish = new Locale("es", "ES");
                    tt1.setLanguage(spanish);
                }
            }
        });
        final  ArrayList<Word> phrases=new ArrayList<Word>();
        phrases.add(new Word("Good morning.", "Buenos días."));
        phrases.add(new Word("Good evening.","Buenas noches."));
        phrases.add(new Word("Hello", "Hola"));
        phrases.add(new Word("How are you?", "Cómo está usted?"));
        phrases.add(new Word("Nice to meet you.", "Mucho gusto."));
        phrases.add(new Word("Goodbye.", "Adiós."));
        phrases.add(new Word("Thank you.", "Gracías"));
        phrases.add(new Word("Its been a pleasure.", "ha sido un placer"));
        phrases.add(new Word("See you Soon", "Te veo pronto."));
        phrases.add(new Word("sorry.", "lo siento"));


        phrasesAdapter adapter = new phrasesAdapter(this,phrases);

        ListView listView = (ListView) findViewById(R.id.phrasesList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word= phrases.get(position);
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
        getMenuInflater().inflate(R.menu.menu_phrases, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
