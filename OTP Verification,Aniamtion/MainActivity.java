package com.example.animationex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

        FirebaseAuth firebaseAuth;
        EditText edt1,edt2;
        Button btn1,btn2;
        String verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        firebaseAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(edt1.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Valid Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String number =edt1.getText().toString();
                    senddatatoverify(number);
                }




            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    otpverify(edt2.getText().toString());
            }
        });
    }

    private void otpverify(String code)
    {
           PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,code);
           signinwithcredential(credential);

    }

    private void signinwithcredential(PhoneAuthCredential credential)
    {
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(MainActivity.this,MainActivity2.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                }
            })
             .addOnFailureListener(new OnFailureListener() {
                 @Override
                   public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(MainActivity.this, "Error2"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

    }

    private void senddatatoverify(String number)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS,this,mcallBack);
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken)
        {
            super.onCodeSent(s, forceResendingToken);
            verificationID =s;


        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential)
        {



                String code =phoneAuthCredential.getSmsCode();
                if(code!=null)
                {
                    edt2.setText(code);
                }


        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e)
        {

            Toast.makeText(MainActivity.this, "Error "+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };
}