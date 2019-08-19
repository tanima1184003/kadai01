package com.tanima.passwordmanagement

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLitedatabase(context: Context) :
        SQLiteOpenHelper(context,"DB_NAME",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table usertable("+
                "_no INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "_name integer not null,"+
                "date text not null,"+
                "memo text not null);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists usertable;")
        onCreate(db)
    }

}

fun queryTexts(context: Context) : List<String>{
    val database = SQLitedatabase(context).readableDatabase

    val cur = database.query(
        "usertable",null,null,
            null,null,null,null)

    val texts = mutableListOf<String>()
    cur.use{
        while(cur.moveToNext()){
            val text = cur.getString(cur.getColumnIndex("_no"))
            texts.add(text)
        }
    }

    database.close()
    return texts
}

fun insertText(context:Context, no: String,name: String){
    val database = SQLitedatabase(context).writableDatabase

    database.use { db->
        val record = ContentValues().apply{
            put("_no",no)
            put("_name",name)
        }

        db.insert("usertable",null,record)
    }
}

fun getName(context: Context, no: String): String{
    val database = SQLitedatabase(context).readableDatabase
    val cursor = database.rawQuery("select _name from usertable where _no = '${no}';",null)
    cursor.moveToNext()
    val name = cursor.getString(cursor.getColumnIndex("_name"))
    return name
}

