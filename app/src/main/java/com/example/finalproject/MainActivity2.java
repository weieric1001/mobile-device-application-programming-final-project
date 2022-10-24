package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener,RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, TextWatcher {
    //修改
    //姓名、電話號碼
    EditText et, et2;
    //店名、店名、飲料
    Spinner sp, sp2, sp3;
    //甜度、冰塊
    RadioGroup rgSugar, rgIce;
    RadioButton rb, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10;
    //加料選擇：珍珠(10)、仙草凍(10)、愛玉(10)、椰果(10)、小芋圓(15)
    CheckBox cb, cb2, cb3, cb4, cb5;
    //送出
    Button btn;
    //顯示
    TextView tv;
    //
    List<String> selected = new ArrayList<String>();
    int drinkPrice =0, addPrice =0;
    String name = "", store = "", drink = "", ice = "", sugar = "", add = "", result = "";
    String[] cut;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //宣告元件
        et = (EditText) findViewById(R.id.editTextTextPersonName);
        et2 = (EditText) findViewById(R.id.editTextPhone3);
        sp = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp3 = (Spinner) findViewById(R.id.spinner3);
        rgSugar = (RadioGroup) findViewById(R.id.radioGroup1);
        rb = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rgIce = (RadioGroup) findViewById(R.id.radioGroup2);
        rb6 = (RadioButton) findViewById(R.id.radioButton6);
        rb7 = (RadioButton) findViewById(R.id.radioButton7);
        rb8 = (RadioButton) findViewById(R.id.radioButton8);
        rb9 = (RadioButton) findViewById(R.id.radioButton9);
        rb10 = (RadioButton) findViewById(R.id.radioButton10);
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        tv = (TextView) findViewById(R.id.textView9);

        //set listener
        et.addTextChangedListener(this);
        //et2.addTextChangedListener(this);
        sp.setOnItemSelectedListener(this);
        sp2.setOnItemSelectedListener(this);
        sp3.setOnItemSelectedListener(this);
        rgSugar.setOnCheckedChangeListener(this);
        rgIce.setOnCheckedChangeListener(this);
        cb.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        cb5.setOnCheckedChangeListener(this);

        //initialize
        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("sendString");
        index = bundle.getInt("index");

        // 變數名稱.split(String sign)
        cut = str.split(",");

        //EditText
        et.setText(cut[0]);
        et2.setText(cut[1]);

        //spinner
        if (cut[2].equals("迷克夏")) {
            sp.setSelection(0);
        }
        else if (cut[2].equals("可不可")) {
            sp.setSelection(1);
        }
        else {
            sp.setSelection(2);
        }
        setAdapter();

        //array0
        if (cut[3].equals("龜山中興店")) {
            sp2.setSelection(0);
        } else if (cut[3].equals("桃園長庚店")) {
            sp2.setSelection(1);
        } else if (cut[3].equals("新北林口店")){
            sp2.setSelection(2);
        }
        if (cut[4].equals("伯爵紅茶拿鐵 55元")) {
            sp3.setSelection(0);
        } else if (cut[4].equals("原鄉冬瓜茶 30元")) {
            sp3.setSelection(1);
        } else if (cut[4].equals("焙香決明大麥 25元")) {
            sp3.setSelection(2);
        }

        //array1
        if (cut[3].equals("林口長庚店")) {
            sp2.setSelection(0);
        } else if (cut[3].equals("龜山中興店")) {
            sp2.setSelection(1);
        }
        if (cut[4].equals("熟成紅茶 35元")) {
            sp3.setSelection(0);
        } else if (cut[4].equals("春芽綠茶 35元")) {
            sp3.setSelection(1);
        } else if (cut[4].equals("春梅冰茶 50元")) {
            sp3.setSelection(2);
        } else if (cut[4].equals("冷露歐蕾 55元")) {
            sp3.setSelection(3);
        }

        //array2
        if (cut[3].equals("文化店")) {
            sp2.setSelection(0);
        } else if (cut[3].equals("林口復興店")) {
            sp2.setSelection(1);
        } else if (cut[3].equals("大崗店")) {
            sp2.setSelection(2);
        }
        if (cut[4].equals("烏龍綠茶 30元")) {
            sp3.setSelection(0);
        } else if (cut[4].equals("特級綠茶 30元")) {
            sp3.setSelection(1);
        } else if (cut[4].equals("特選普洱 30元")) {
            sp3.setSelection(2);
        } else if (cut[4].equals("原鄉四季 30元")) {
            sp3.setSelection(3);
        } else if (cut[4].equals("珍珠奶茶 50元")) {
            sp3.setSelection(4);
        } else if (cut[4].equals("多多綠茶 45元")) {
            sp3.setSelection(5);
        }

        //RadioButton甜度
        if (cut[5].toString().contains("正常")){
            rb.setChecked(true);
        }
        else if (cut[5].toString().contains("少糖")){
            rb2.setChecked(true);
        }
        else if (cut[5].toString().contains("半糖")){
            rb3.setChecked(true);
        }
        else if (cut[5].toString().contains("微糖")){
            rb4.setChecked(true);
        }
        else{
            rb5.setChecked(true);
        }

        //RadioButton冰塊
        if (cut[6].toString().contains("正常")){
            rb6.setChecked(true);
        }
        else if (cut[6].toString().contains("少冰")){
            rb7.setChecked(true);
        }
        else if (cut[6].toString().contains("微冰")){
            rb8.setChecked(true);
        }
        else if (cut[6].toString().contains("去冰")){
            rb9.setChecked(true);
        }
        else{
            rb10.setChecked(true);
        }

        //CheckBox加料
        if (cut[7].toString().contains("珍珠")){
            cb.setChecked(true);
        }
        if (cut[7].toString().contains("仙草凍")){
            cb2.setChecked(true);
        }
        if (cut[7].toString().contains("愛玉")){
            cb3.setChecked(true);
        }
        if (cut[7].toString().contains("椰果")){
            cb4.setChecked(true);
        }
        if (cut[7].toString().contains("小芋圓")){
            cb5.setChecked(true);
        }

        //Spinner
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> list= new ArrayList<String>();
        ArrayList<String> list2= new ArrayList<String>();
        String[] action;
        String[] action2;
        if (parent.getId() == R.id.spinner) {
            if (sp.getSelectedItemPosition() == 0) {
                action = getResources().getStringArray(R.array.array0b);
                action2 = getResources().getStringArray(R.array.array0d);
                cb.setClickable(true);
                cb.setTextColor(Color.BLACK);
                cb2.setClickable(true);
                cb2.setTextColor(Color.BLACK);
                cb3.setClickable(false);
                cb3.setTextColor(Color.GRAY);
                cb3.setChecked(false);
                cb4.setClickable(false);
                cb4.setTextColor(Color.GRAY);
                cb4.setChecked(false);
                cb5.setClickable(true);
                cb5.setTextColor(Color.BLACK);
            } else if (sp.getSelectedItemPosition() == 1) {
                action = getResources().getStringArray(R.array.array1b);
                action2 = getResources().getStringArray(R.array.array1d);
                cb.setClickable(true);
                cb.setTextColor(Color.BLACK);
                cb2.setClickable(false);
                cb2.setTextColor(Color.GRAY);
                cb2.setChecked(false);
                cb3.setClickable(false);
                cb3.setTextColor(Color.GRAY);
                cb3.setChecked(false);
                cb4.setClickable(false);
                cb4.setTextColor(Color.GRAY);
                cb4.setChecked(false);
                cb5.setClickable(false);
                cb5.setTextColor(Color.GRAY);
                cb5.setChecked(false);
            } else {
                action = getResources().getStringArray(R.array.array2b);
                action2 = getResources().getStringArray(R.array.array2d);
                cb.setClickable(true);
                cb.setTextColor(Color.BLACK);
                cb2.setClickable(true);
                cb2.setTextColor(Color.BLACK);
                cb3.setClickable(true);
                cb3.setTextColor(Color.BLACK);
                cb4.setClickable(true);
                cb4.setTextColor(Color.BLACK);
                cb5.setClickable(true);
                cb5.setTextColor(Color.BLACK);
            }
            for (int j = 0; j < action.length; j++) {
                list.add(action[j]);
            }
            for (int j = 0; j < action2.length; j++) {
                list2.add(action2[j]);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list);
            ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list2);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            sp3.setAdapter(adapter2);
        }
        name = sp.getSelectedItem().toString();
        store = sp2.getSelectedItem().toString();
        drink = sp3.getSelectedItem().toString();
        drinkPrice = Integer.parseInt(drink.split(" ")[1].split("元")[0]);
        TextChange();
    }

    public void setAdapter() {
        ArrayList<String> list= new ArrayList<String>();
        ArrayList<String> list2= new ArrayList<String>();
        String[] action;
        String[] action2;
        if (sp.getSelectedItemPosition() == 0) {
            action = getResources().getStringArray(R.array.array0b);
            action2 = getResources().getStringArray(R.array.array0d);
            cb.setClickable(true);
            cb.setTextColor(Color.BLACK);
            cb2.setClickable(true);
            cb2.setTextColor(Color.BLACK);
            cb3.setClickable(false);
            cb3.setTextColor(Color.GRAY);
            cb3.setChecked(false);
            cb4.setClickable(false);
            cb4.setTextColor(Color.GRAY);
            cb4.setChecked(false);
            cb5.setClickable(true);
            cb5.setTextColor(Color.BLACK);
        } else if (sp.getSelectedItemPosition() == 1) {
            action = getResources().getStringArray(R.array.array1b);
            action2 = getResources().getStringArray(R.array.array1d);
            cb.setClickable(true);
            cb.setTextColor(Color.BLACK);
            cb2.setClickable(false);
            cb2.setTextColor(Color.GRAY);
            cb2.setChecked(false);
            cb3.setClickable(false);
            cb3.setTextColor(Color.GRAY);
            cb3.setChecked(false);
            cb4.setClickable(false);
            cb4.setTextColor(Color.GRAY);
            cb4.setChecked(false);
            cb5.setClickable(false);
            cb5.setTextColor(Color.GRAY);
            cb5.setChecked(false);
        } else {
            action = getResources().getStringArray(R.array.array2b);
            action2 = getResources().getStringArray(R.array.array2d);
            cb.setClickable(true);
            cb.setTextColor(Color.BLACK);
            cb2.setClickable(true);
            cb2.setTextColor(Color.BLACK);
            cb3.setClickable(true);
            cb3.setTextColor(Color.BLACK);
            cb4.setClickable(true);
            cb4.setTextColor(Color.BLACK);
            cb5.setClickable(true);
            cb5.setTextColor(Color.BLACK);
        }
        for (int j = 0; j < action.length; j++) {
            list.add(action[j]);
        }
        for (int j = 0; j < action2.length; j++) {
            list2.add(action2[j]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter);
        sp3.setAdapter(adapter2);
        name = sp.getSelectedItem().toString();
        store = sp2.getSelectedItem().toString();
        drink = sp3.getSelectedItem().toString();
        drinkPrice = Integer.parseInt(drink.split(" ")[1].split("元")[0]);
        TextChange();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        //更改RadioButton甜度
        sugar ="";
        switch(rgSugar.getCheckedRadioButtonId()){
            case R.id.radioButton:
                sugar = "正常";
                break;
            case R.id.radioButton2:
                sugar = "少糖";
                break;
            case R.id.radioButton3:
                sugar = "半糖";
                break;
            case R.id.radioButton4:
                sugar = "微糖";
                break;
            case R.id.radioButton5:
                sugar = "無糖";
                break;
        }

        //更改RadioButton冰塊
        ice ="";
        switch(rgIce.getCheckedRadioButtonId()){
            case R.id.radioButton6:
                ice = "正常";
                break;
            case R.id.radioButton7:
                ice = "少冰";
                break;
            case R.id.radioButton8:
                ice = "微冰";
                break;
            case R.id.radioButton9:
                ice = "去冰";
                break;
            case R.id.radioButton10:
                ice = "溫熱";
                break;
        }
        TextChange();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        //更改CheckBox加料
        add ="";
        addPrice =0;
        if (cb.isChecked()){
            addPrice += 10;
            add += "珍珠";
        }
        if (cb2.isChecked()){
            addPrice += 10;
            add += "仙草凍";
        }
        if (cb3.isChecked()){
            addPrice += 10;
            add += "愛玉";
        }
        if (cb4.isChecked()){
            addPrice += 10;
            add += "椰果";
        }
        if (cb5.isChecked()){
            addPrice += 15;
            add += "小芋圓";
        }
        TextChange();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        TextChange();
    }

    public void TextChange() {
        result ="";
        int price = 0;
        price += drinkPrice;
        price += addPrice;
        result += et.getText().toString() + "," + et2.getText().toString();
        result += "," + name + "," + store + "," + drink;
        result += "," + sugar + "," + ice + "," + add + ",共" + price + "元";

        tv.setText(result);
    }

    public void sendMessage(View view) {
        Intent intent = getIntent();
        Bundle bundle3 = new Bundle();
        bundle3.putString("sendString", tv.getText().toString());
        bundle3.putInt("index", index);
        intent.putExtras(bundle3);
        setResult(200, intent);
        MainActivity2.this.finish();
    }
}