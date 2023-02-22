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

public class UpdateCourse extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText id_upd_name, id_upd_email, id_upd_password, id_upd_mobile;
    private Button id_upd_btn, id_dlt_btn;
    private DBHandler dbHandler;
    String contactName, contactemail, contactPassword, contactMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);

        // initializing all our variables.
        id_upd_name = findViewById(R.id.id_upd_name);
        id_upd_email = findViewById(R.id.id_upd_email);
        id_upd_password = findViewById(R.id.id_upd_password);
        id_upd_mobile = findViewById(R.id.id_upd_mobile);
        id_dlt_btn = findViewById(R.id.id_dlt_btn);
        id_upd_btn = findViewById(R.id.id_upd_btn);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateCourse.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        contactName = getIntent().getStringExtra("name");
        contactemail = getIntent().getStringExtra("email");
        contactPassword = getIntent().getStringExtra("password");
        contactMobile = getIntent().getStringExtra("mobile");

        // setting data to edit text
        // of our update activity.
        id_upd_name.setText(contactName);
        id_upd_email.setText(contactemail);
        id_upd_password.setText(contactPassword);
        id_upd_mobile.setText(contactMobile);

        // adding on click listener to our update course button.
        id_upd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateContact(contactName, id_upd_name.getText().toString(),
                        id_upd_email.getText().toString(), id_upd_password.getText().toString(),
                        id_upd_mobile.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateCourse.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateCourse.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our course.
        id_dlt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteCourse(contactName);
                Toast.makeText(UpdateCourse.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateCourse.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
