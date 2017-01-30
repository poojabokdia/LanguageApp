package com.example.pooja.languageapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pooja on 1/22/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Activity context, ArrayList<Word> words) {

        super(context, 0, words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list1, parent, false);
        }


        Word currentWord = getItem(position);
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.defaultTranslation);
        defaultTranslation.setText(currentWord.getDefaultTranslation());
        TextView translation = (TextView) listItemView.findViewById(R.id.translation);
        translation.setText(currentWord.getTranslation());
        ImageView image=(ImageView)listItemView.findViewById(R.id.image);
        image.setImageResource(currentWord.getImageResourceId());


        return listItemView;

    }
}
