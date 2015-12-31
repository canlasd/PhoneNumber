package com.example.canlasd.phonenumber;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    EditText mEdit;
    String new_phone_number;
    String available_phone_number;
    String regexStr;
    // use linkedhashset to avoid duplicate entries and arrange entries in order
    LinkedHashSet usedPhoneNumber = new LinkedHashSet();
    LinkedHashSet newPhoneNumber = new LinkedHashSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEdit = (EditText) findViewById(R.id.phone_field);
        regexStr = "^[0-9]{10}$";



    }

    // ADD NUMBER functions.  Checks the entry for proper format (e.g. 1234567890) and saves it in a linkedhashmap
    public void addNumber(View v)

    {
        // get user input from textfield

        new_phone_number = mEdit.getText().toString();

        // check if the phone number has not been used

        if ((usedPhoneNumber.contains(new_phone_number))) {
            Toast.makeText(this, "Number Already Used", Toast.LENGTH_SHORT).show();
        }


        // check if the phone number entered is in the correct format


        else if (new_phone_number.matches(regexStr)) {
            // check if the entry is not a duplicate entry
            if (newPhoneNumber.add(new_phone_number)) {
                Toast.makeText(this, "Phone number added", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Number Already Added", Toast.LENGTH_SHORT).show();

            }
        } else {

            Toast.makeText(this, "Incorrect Format ", Toast.LENGTH_SHORT).show();

        }
    }

    public void findFreeNumber(View v) {
        if (newPhoneNumber.isEmpty()) {
            Toast.makeText(this, "No Phone Number Available", Toast.LENGTH_SHORT).show();

        } else {


            available_phone_number = newPhoneNumber.iterator().next().toString();

            // show available number using alert dialog

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

            alertDialog.setMessage("Phone Number Available:  " + available_phone_number);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

            //  add number to usedPhoneNumber list
            usedPhoneNumber.add(available_phone_number);

            // remove number from newPhoneNumber list
            newPhoneNumber.remove(available_phone_number);


        }


    }


}
