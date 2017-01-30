package com.example.pooja.languageapp;

/**
 * Created by Pooja on 1/22/2017.
 */
public class Word {
    private String mDefaultTranslation;
    private String mTranslation;
    private int mImageResourceId;


    public Word(String defaultTranslation,String translation){
        mDefaultTranslation=defaultTranslation;
        mTranslation=translation;
    }
    public Word(String defaultTranslation,String translation,int ImageResourceId){
        mDefaultTranslation=defaultTranslation;
        mTranslation=translation;
        mImageResourceId=ImageResourceId;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getTranslation(){
        return mTranslation;
    }
    public int getImageResourceId(){return  mImageResourceId;}

}
