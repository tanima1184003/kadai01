package com.tanima.passwordmanagement

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class List2Password : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_list2)

        val txtName = findViewById(R.id.txtName) as TextView

        val name = intent.getStringExtra("txtName")
        txtName.setText(name)

        val txtPass = findViewById(R.id.txtPass) as TextView

        txtPass.setText(getName(this,name.toString()))

        val button5 = findViewById(R.id.button5) as Button

        val button3 = findViewById(R.id.button3) as Button

        button3.setOnClickListener{
            val intent3 = Intent(this, Password::class.java)
            startActivity(intent3)
        }

        button5.setOnClickListener {
            val intent5 = Intent(this,Password::class.java)
            val database = SQLitedatabase(this).writableDatabase
            database.delete("usertable","_no  = ?",arrayOf(txtName.text.toString()))
            startActivity(intent5)
        }
    }
}