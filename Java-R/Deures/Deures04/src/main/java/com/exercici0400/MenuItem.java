package com.exercici0400;

public class MenuItem {
    
    private String title;
    private String[] KeyWords;

    public MenuItem(String title,String[] KeyWords){
        this.title = title;
        this.KeyWords = KeyWords;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitle(){
        return title;
    }

    public String[] getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String[] KeyWords) {
        this.KeyWords = KeyWords;
    }

}

