package com.sinch.audio.video

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener()
        {
            val email = edittext_email.text.toString();
            val password = edittext_email.text.toString();


            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener()
            {
                if(it.isSuccessful)
                {
                    val intent =  Intent(LoginActivity@this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(MainActivity@this, "Successfully", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(MainActivity@this, "Sorry", Toast.LENGTH_LONG).show()
                }
            }
        }

        btn_sign_up.setOnClickListener()
        {
            val intent = Intent(LoginActivity@this, RegisterActivity::class.java);
            startActivity(intent)
        }
    }
}
