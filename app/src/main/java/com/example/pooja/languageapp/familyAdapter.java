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
 * Created by Pooja on 1/25/2017.
 */
public class familyAdapter extends ArrayAdapter<Word> {
    public familyAdapter(Activity context, ArrayList<Word> colors) {

        super(context, 0, colors);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list1, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.defaultTranslation);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView translation = (TextView) listItemView.findViewById(R.id.translation);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        translation.setText(currentWord.getTranslation());
        ImageView image=(ImageView)listItemView.findViewById(R.id.image);
        image.setImageResource(currentWord.getImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
