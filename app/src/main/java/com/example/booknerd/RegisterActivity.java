package com.example.booknerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
EditText userfullname, useremail, usercity, userpassword;
TextView loginbutton;
    Button registerButton;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userfullname=findViewById(R.id.username_field);
        useremail=findViewById(R.id.email_field);
        usercity=findViewById(R.id.city_field);
        userpassword=findViewById(R.id.password_field);
        loginbutton=findViewById(R.id.text_signin);

        registerButton=findViewById(R.id.register_button);

        fAuth=FirebaseAuth.getInstance();

       registerButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email=useremail.getText().toString().trim();
               String password=userpassword.getText().toString().trim();
               if(TextUtils.isEmpty(email)){
                   useremail.setError("Email is required");
                   return;
               }
               if(TextUtils.isEmpty(password)){
                   userpassword.setError("Password is required");
                   return;
               }
               if(password.length()<6){
                   userpassword.setError("Password bust be longer than 5 characters");
                   return;
               }
               fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(RegisterActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                       }else{
                           Toast.makeText(RegisterActivity.this, "Error. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });

           }

       });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

    }
}
