package com.tanima.passwordmanagement

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


data class UserTable(val txtNo : String,val txtPass : String)

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtNo = findViewById(R.id.edtNo) as EditText
        val edtPass = findViewById(R.id.edtPass) as EditText
        //挿入ボタン
        val insert = findViewById(R.id.insert) as Button
            insert.setOnClickListener {

                //val values = ContentValues()
                //values.put("_txtNo",edtNo.text.toString())
                //values.put("_txtPass",txtPass.text.toString())
                if(edtPass.text.toString().equals(edtPass2.text.toString())) {
                    if(edtPass.text.toString().equals("") ){
                        edtNo.setText("")
                        edtPass.setText("")
                        edtPass2.setText("")
                        edtPass.error = "何か入力してください"
                        edtPass2.error = "何か入力してください"
                    }else {
                        insertText(this, edtNo.text.toString(), edtPass.text.toString())
                        edtNo.setText("")
                        edtPass.setText("")
                        edtPass2.setText("")
                    }
                }else{
                    edtPass.setText("")
                    edtPass2.setText("")
                    edtPass.error = "入力用と確認用のパスワードが一致しません"
                    edtPass2.error = "入力用と確認用のパスワードが一致しません"

                }
            }

        //画面遷移
        val display = findViewById(R.id.display) as Button

        display.setOnClickListener{
            val intent = Intent(this, Password::class.java)
            startActivity(intent)
        }


        }
}


