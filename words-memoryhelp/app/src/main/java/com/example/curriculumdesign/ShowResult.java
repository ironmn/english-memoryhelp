package com.example.curriculumdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowResult extends AppCompatActivity {
    TextView out,words;
    Button btn1 ;
    ArrayList<String> wrongResult = new ArrayList<String>();
    int rate,wrongNum;
    String output = "以下是你的错误记录：\n\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        out = findViewById(R.id.textView4);
        words = findViewById(R.id.textView5);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        rate = bundle.getInt("rate");
        wrongNum = bundle.getInt("wrongnum");
        wrongResult = bundle.getStringArrayList("wrongwords");
        String numOut = rate +"%";
        out.setText(numOut);
        if(wrongNum == 0){
            words.setText("竟然全都答对了，你真棒！");
        }
        else{
            for(int i = 0;i<wrongNum;i++){
                output += wrongResult.get(i);
                output += "\n";
            }
            output += "\n\n\n再去多多巩固吧！";
            words.setText(output);
        }
        btn1 = findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShowResult.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        //adt1 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,wrongResult);
        //list1.setAdapter((ListAdapter) adt1);
    }
}
