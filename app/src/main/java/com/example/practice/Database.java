package com.example.practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{
    
    Context context;

    public Database(@Nullable Context context) {
        super(context,"mydata.db",null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String que="CREATE TABLE student(ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,surname TEXT,std TEXT)";
        db.execSQL(que);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    
    public void InsertData(String name, String surname, String std){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",name);
        values.put("Surname",surname);
        values.put("Std",std);
        long is =db.insert("student",null,values);
        
        if (is == -1){
            Toast.makeText(context, "Data is failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Data is successfull", Toast.LENGTH_SHORT).show();
        }
        
    }

    public List<StudentData> RetriveData(){

       List<StudentData> dataList=new ArrayList<>();
       SQLiteDatabase db=getReadableDatabase();
       String que="SELECT * FROM student";
       Cursor cursor=db.rawQuery(que ,null);
       cursor.moveToFirst();

        for (int i=0 ; i<cursor.getCount(); i++){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String surname=cursor.getString(2);
            String std=cursor.getString(3);
            StudentData data=new StudentData(id,name,surname,std);
            dataList.add(data);
            cursor.moveToNext();


        }
        return dataList;

    }
    public void UpdateData(int id1,String name,String surname,String std){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Id",id1);
        values.put("Name",name);
        values.put("Surname",surname);
        values.put("Std",std);

        long is=db.update("student",values,"Id="+id1,null);
        if (is==-1){

            Toast.makeText(context, "Data is not update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Data is update", Toast.LENGTH_SHORT).show();
        }
    }


}


