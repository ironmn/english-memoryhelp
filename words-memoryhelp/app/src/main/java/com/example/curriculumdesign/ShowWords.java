package com.example.curriculumdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout;

import android.content.Intent;
import android.os.Bundle;
import android.service.chooser.ChooserTargetService;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class ShowWords extends AppCompatActivity {
    ArrayList<String> NUM = new ArrayList<String>();
    ArrayList<String> ENGLISH = new ArrayList<String>();
    ArrayList<String> CHINESE = new ArrayList<String>();
    int randomNum = 0;
    int size,c,choice1;
    List l=new ArrayList();
    List res=new ArrayList();
    TextView s,result;
    Button Back,Choose,Next;
    RadioButton a,b,C;
    RadioGroup rp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_words);
        Back = findViewById(R.id.back);
        Choose = findViewById(R.id.choose);
        Next = findViewById(R.id.next);
        s = findViewById(R.id.textView);
        result = findViewById(R.id.textView2);
        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        C = findViewById(R.id.C);
        rp = findViewById(R.id.radioGroup);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        NUM = bundle.getStringArrayList("num");
        ENGLISH = bundle.getStringArrayList("english");
        CHINESE = bundle.getStringArrayList("chinese");
        size = bundle.getInt("index");
        for(int i = 0;i<size;i++) {
            l.add(i);
        }
        Random r=new Random();
        for(int i=0;i<size;i++){
            res.add(l.remove(r.nextInt(l.size())));
        }
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum = 0;
                finish();
            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setText("下一个");
                result.setText("");
                rp.clearCheck();
                c = (int) res.get(randomNum);
                choice1 = (int)(1+Math.random()*3);//随机选取一个选项，显示正确答案
                int choice2 = 0,choice3 = 0;
                for(;;){
                    choice2 = (int)(1+Math.random()*size) - 1;
                    choice3 = (int)(1+Math.random()*size) - 1;
                    if(c!=choice2&&c!=choice3&&choice2!=choice3) break;//取两个不等于c并且不同的数字，作为干扰选项的下标
                }
                if(choice1 == 1) {
                    a.setText(CHINESE.get(c));
                    b.setText(CHINESE.get(choice2));
                    C.setText(CHINESE.get(choice3));
                }
                else if(choice1 == 2) {
                    b.setText(CHINESE.get(c));
                    a.setText(CHINESE.get(choice2));
                    C.setText(CHINESE.get(choice3));
                }

                else if(choice1 == 3) {
                    C.setText(CHINESE.get(c));
                    a.setText(CHINESE.get(choice2));
                    b.setText(CHINESE.get(choice3));
                }
                String eng = ENGLISH.get(c);
                s.setText(eng);

                randomNum++;
            }
        });
        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = "答对了，继续吧！O(∩_∩)O",str2 = "答错了/(ㄒoㄒ)/~~";
                if(choice1 == 1){
                    if(a.isChecked()){
                        result.setText(str1);
                    }
                    else{
                        result.setText(str2);
                    }
                }
                if(choice1 == 2){
                    if(b.isChecked()){
                        result.setText(str1);
                    }
                    else{
                        result.setText(str2);
                    }
                }
                if(choice1 == 3){
                    if(C.isChecked()){
                        result.setText(str1);
                    }
                    else{
                        result.setText(str2);
                    }
                }
            }
        });
    }
}
