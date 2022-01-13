package com.example.demoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class dataActivity extends AppCompatActivity {
    private TextView q1,q2,q3,q4,q5;
    private EditText a1,a2,a3,a4,a5;
    private Button reset,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        setContentView(R.layout.activity_data);
        q1=findViewById(R.id.q1);
        q2=findViewById(R.id.q2);
        q3=findViewById(R.id.q3);
        q4=findViewById(R.id.q4);
        q5=findViewById(R.id.q5);

        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        a3=findViewById(R.id.a3);
        a4=findViewById(R.id.a4);
        a5=findViewById(R.id.a5);

        reset=findViewById(R.id.reset);
        submit=findViewById(R.id.submit);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1.setText("");
                a2.setText("");
                a3.setText("");
                a4.setText("");
                a5.setText("");

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(a1.getText().toString().equals("")||a2.getText().toString().equals("")
                   ||a3.getText().toString().equals("")||a4.getText().toString().equals("")
                     ||a5.getText().toString().equals(""))
               {
                   Toast.makeText(dataActivity.this, "Please answer all question", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   DataClass d1=new DataClass(a1.getText().toString(),a2.getText().toString()
                           ,a3.getText().toString(),a4.getText().toString()
                           ,a5.getText().toString());
                   db.collection("users")
                           .add(d1)
                           .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                               @Override
                               public void onSuccess(DocumentReference documentReference) {
                                   Toast.makeText(dataActivity.this, "your Response added", Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(dataActivity.this,MainActivity.class));
                                   finish();
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(dataActivity.this, "Something went wrong"+e, Toast.LENGTH_SHORT).show();
                               }
                           });
               }
            }
        });




    }
}