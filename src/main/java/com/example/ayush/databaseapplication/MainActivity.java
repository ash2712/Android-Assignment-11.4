package com.example.ayush.databaseapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Data> list = new ArrayList<>();
        ListView listView = (ListView)findViewById(R.id.listView);

        database database = new database(this);
        String[] firstNames = new String[]{"Lionel", "Cristiano", "Paul" , "David"};
        String[] surname = new String[]{"Messi", "Ronaldo", "Pogba", "Luiz"};


        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from employeeInfo", null);
        //if statement prevents values from repeatedly getting inserted into the database
        if(cursor.getCount() == 0){
            for(int i = 0; i < firstNames.length; i++){
                database.insert_Data(firstNames[i], surname[i]);
            }
            cursor = database.showProduct();
        }
        for(int i = 0;i < firstNames.length;i++) {
            //adds values from the database to the arrayList list
            cursor.moveToPosition(i);
            Data data = new Data();
             data.setId(cursor.getInt(cursor.getColumnIndex("id")));
            data.setFirstName(cursor.getString(cursor.getColumnIndex("firstName")));
            data.setSurname(cursor.getString(cursor.getColumnIndex("surname")));
            list.add(i, data);
        }

        CustomAdapter adapter = new CustomAdapter(this, list);
        listView.setAdapter(adapter);
    }
}

