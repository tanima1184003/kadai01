package com.tanima.passwordmanagement

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.tanima.passwordmanagement.R.id.passText
import com.tanima.passwordmanagement.R.id.txtName

//import android.widget.TextView


class Password : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password)

        val button2 = findViewById(R.id.button2) as Button

        button2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        show()
    }

    private fun show(){
        val texts = queryTexts(this)
        val listView = findViewById(R.id._list) as ListView
        listView.adapter = ArrayAdapter<String>(this,
                R.layout.lst_password_row,R.id.passText,texts)
        listView.setOnItemClickListener { parent, view, position, id ->
                val passText = view?.findViewById<TextView>(passText)
                val intent2 = Intent(this, List2Password::class.java)
                intent2.putExtra("txtName",passText?.text.toString())
                startActivity(intent2)
        }

    }

}
