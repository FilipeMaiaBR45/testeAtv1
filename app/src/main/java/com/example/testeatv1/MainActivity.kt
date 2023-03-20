package com.example.testeatv1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val activityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            when(it.resultCode){
                RESULT_OK->{
                    Toast.makeText(this, "AH EH", Toast.LENGTH_SHORT).show()
                }
                RESULT_CANCELED->{
                    Toast.makeText(this, "CANCELOU", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val botaoInvoca:Button = findViewById(R.id.botaoInvoca)
        botaoInvoca.setOnClickListener {
            val intent = Intent(this, ActivityRecebe::class.java)

            activityForResult.launch(intent)
        }


    }
}