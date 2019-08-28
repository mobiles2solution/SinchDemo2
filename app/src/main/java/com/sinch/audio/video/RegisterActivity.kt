package com.sinch.audio.video

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        database = FirebaseDatabase.getInstance().getReference()


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


                        writeNewUser(userId, name, email, password)

                    }
                    else
                    {
                        Toast.makeText(RegisterActivity@this, "Account Created Failed",Toast.LENGTH_LONG).show()
                    }
                }

        }



    }

    private fun writeNewUser(userId: String, name: String, email: String, password: String?) {
        val user = User(name, email, password)
        database.child("users").child(userId).setValue(user).addOnCompleteListener {
            if(it.isSuccessful)
            {
                val intent = Intent(RegisterActivity@this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(RegisterActivity@this, "User added successfully",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(RegisterActivity@this, "User adding failed",Toast.LENGTH_LONG).show()
            }
        }

    }

}
