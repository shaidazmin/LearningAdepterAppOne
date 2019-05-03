package com.example.nz.learningadepterappone;

import android.widget.EditText;

import java.util.Date;

/**
 * Created by Nz on 12/20/2017.
 */

public class Item {

    // variable ....

    private  String inputString;
    private Date date;

    // constructor.......

    public Item(String inputString, Date date) {
        this.inputString = inputString;
        this.date = date;
    }


     // getter and setter method .......

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }





}
