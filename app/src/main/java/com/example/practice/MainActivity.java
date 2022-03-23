package com.example.practice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText id,name,surname,std;
    Button insert,retrive,update,delete;
    RecyclerAdapter adapter;
    Database database;
    RecyclerView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.ids);
        name=findViewById(R.id.names);
        surname=findViewById(R.id.surnames);
        std=findViewById(R.id.stds);

        insert=findViewById(R.id.insert);
        retrive=findViewById(R.id.retrive);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);

        database=new Database(MainActivity.this);
        list=findViewById(R.id.list);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1=name.getText().toString();
                String n2=surname.getText().toString();
                String n3=std.getText().toString();
                database.InsertData(n1,n2,n3 );

            }
        });
        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<StudentData> dataList=database.RetriveData();
                adapter=new RecyclerAdapter(MainActivity.this,dataList);
                list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                list.setAdapter(adapter);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id1=Integer.parseInt(id.getText().toString());
                String n1=name.getText().toString();
                String n2=surname.getText().toString();
                String n3=std.getText().toString();
                database.UpdateData(id1,n1,n2,n3);

            }
        });



    }

}