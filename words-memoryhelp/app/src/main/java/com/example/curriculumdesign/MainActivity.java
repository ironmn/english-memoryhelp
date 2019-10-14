package com.example.curriculumdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> num = new ArrayList<String>();
    ArrayList<String> English = new ArrayList<String>();
    ArrayList<String> Chinese = new ArrayList<String>();
    ArrayAdapter adt1,adt2,adt3;
    ListView list1,list2,list3;
    Button btn1,btn2,btn3;
    EditText edt1,edt2;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        list1 = findViewById(R.id.listview1);
        list2 = findViewById(R.id.listview2);
        list3 = findViewById(R.id.listview3);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn3.setTextColor(Color.RED);
        edt1 = findViewById(R.id.edit1);
        edt2 = findViewById(R.id.edit2);
        adt1 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,num);
        adt2 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,English);
        adt3 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Chinese);
        list1.setAdapter(adt1);
        list2.setAdapter(adt2);
        list3.setAdapter(adt3);
        btn1.setOnClickListener(new Confirm());
        btn2.setOnClickListener(new Delete());
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowWords.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("num",num);
                bundle.putStringArrayList("english",English);
                bundle.putStringArrayList("chinese", Chinese);
                bundle.putInt("index",index);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    class Confirm implements View.OnClickListener{
        public void onClick(View v){
            index += 1;
            String str1,str2,str3;
            str1 = ""+index;
            str2 = edt1.getText().toString();
            str3 = edt2.getText().toString();
            num.add(str1);
            English.add(str2);
            Chinese.add(str3);
            adt1.notifyDataSetChanged();
            adt2.notifyDataSetChanged();
            adt3.notifyDataSetChanged();
            edt1.setText("");
            edt2.setText("");
        }
    }
    class Delete implements View.OnClickListener{
        public void onClick(View v){
            num.remove(index-1);
            English.remove(index-1);
            Chinese.remove(index-1);
            adt1.notifyDataSetChanged();
            adt2.notifyDataSetChanged();
            adt3.notifyDataSetChanged();
            edt1.setText("");
            edt2.setText("");
            index -= 1;
        }
    }
}
