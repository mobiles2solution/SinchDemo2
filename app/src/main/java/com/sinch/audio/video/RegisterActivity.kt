package com.sinch.audio.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)




        btn_register.setOnClickListener()
        {
            val name = register_name.text.toString();
            val email = register_email.text.toString();
            val password = register_paaword.text.toString();

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if(it.isComplete)
                    {
                        Toast.makeText(RegisterActivity@this, "Account Created Successfully",Toast.LENGTH_LONG).show()
                        val userId = firebaseAuth!!.currentUser!!.uid


                        val modalUser =  ModalUser(name,email,password,userId)

                    }
                    else
                    {
                        Toast.makeText(RegisterActivity@this, "Account Created Failed",Toast.LENGTH_LONG).show()
                    }
                }

        }

    }
}
