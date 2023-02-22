package com.seeksolution.sqliteapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText id_edt_name, id_edt_email, id_edt_password, id_edt_mobile;
    private Button id_add_btn, id_read_btn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // initializing all our variables.
        id_edt_name = findViewById(R.id.id_edt_name);
        id_edt_email = findViewById(R.id.id_edt_email);
        id_edt_password = findViewById(R.id.id_edt_password);
        id_edt_mobile = findViewById(R.id.id_edt_mobile);
        id_add_btn = findViewById(R.id.id_add_btn);
        id_read_btn = findViewById(R.id.id_read_btn);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        id_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String contactName = id_edt_name.getText().toString();
                String contactEmail = id_edt_email.getText().toString();
                String contactPassword = id_edt_password.getText().toString();
                String contactMobile = id_edt_mobile.getText().toString();

                // validating if the text fields are empty or not.
                if (contactName.isEmpty() || contactEmail.isEmpty() || contactPassword.isEmpty() || contactMobile.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(contactName, contactEmail, contactPassword, contactMobile);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User has been added.", Toast.LENGTH_SHORT).show();
                id_edt_name.setText("");
                id_edt_email.setText("");
                id_edt_password.setText("");
                id_edt_mobile.setText("");
            }
        });

        id_read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewCourse.class);
                startActivity(i);
            }
        });
    }
}
