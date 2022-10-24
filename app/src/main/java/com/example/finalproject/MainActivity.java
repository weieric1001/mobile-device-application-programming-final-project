package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, TextWatcher {

    //姓名、電話號碼
    EditText et, et2;
    //店名、店名、飲料
    Spinner sp, sp2, sp3;
    //甜度、冰塊
    RadioGroup rgSugar, rgIce;
    //加料選擇：珍珠(10)、仙草凍(10)、愛玉(10)、椰果(10)、小芋圓(15)
    CheckBox cb, cb2, cb3, cb4, cb5;
    //送出
    Button btn;
    //顯示
    TextView tv;
    //list清單
    ListView lv;
    //
    List<String> selected = new ArrayList<String>();
    int drinkPrice = 0, addPrice = 0;
    String name = "", store = "", drink = "", ice = "", sugar = "", add = "", result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //宣告元件
        et = (EditText) findViewById(R.id.editTextTextPersonName);
        et2 = (EditText) findViewById(R.id.editTextPhone3);
        sp = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp3 = (Spinner) findViewById(R.id.spinner3);
        rgSugar = (RadioGroup) findViewById(R.id.radioGroup1);
        rgIce = (RadioGroup) findViewById(R.id.radioGroup2);
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView9);
        lv = (ListView) findViewById(R.id.listview);

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
        btn.setOnClickListener(this);
        lv.setOnItemClickListener(this);

    }

    //Spinner
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //RadioGroup
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //正常,少糖,半糖,微糖,無糖
        sugar = "";
        switch (rgSugar.getCheckedRadioButtonId()) {
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
        //正常,少冰,微冰,去冰,溫熱
        ice = "";
        switch (rgIce.getCheckedRadioButtonId()) {
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

    //CheckBox
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        add = "";
        addPrice = 0;
        if (cb.isChecked()) {
            addPrice += 10;
            add += "珍珠";
        }
        if (cb2.isChecked()) {
            addPrice += 10;
            add += "仙草凍";
        }
        if (cb3.isChecked()) {
            addPrice += 10;
            add += "愛玉";
        }
        if (cb4.isChecked()) {
            addPrice += 10;
            add += "椰果";
        }
        if (cb5.isChecked()) {
            addPrice += 15;
            add += "小芋圓";
        }
        TextChange();
    }

    //Button
    @Override
    public void onClick(View v) {
        if (v == btn) {
            AlertDialog.Builder bdr = new AlertDialog.Builder(this);
            bdr.setMessage("確認清單");
            bdr.setTitle("確定加入listView清單嗎?");
            bdr.setIcon(android.R.drawable.btn_star_big_on);
            bdr.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "您不確定要加入清單, 請再check一下您的選擇! 謝謝", Toast.LENGTH_LONG).show();
                }
            });
            bdr.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    selected.add(result);

                    lv = (ListView) findViewById(R.id.listview);
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            selected);

                    lv.setAdapter(arrayAdapter);
                    Toast.makeText(MainActivity.this, "謝謝您的訂購" , Toast.LENGTH_LONG).show();
                    et.setText("");
                    et2.setText("");
                }
            });
            bdr.setCancelable(true);
            bdr.show();
        }
    }

    //ListView
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        String msg = adapterView.getItemAtPosition(i).toString();
        int in = i;
        bdr.setMessage(msg);
        bdr.setTitle("請選擇修改或前往導航");
        bdr.setIcon(android.R.drawable.star_big_off);
        bdr.setNegativeButton("修改", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("sendString", msg);
                bundle.putInt("index", in);
                intent.putExtras(bundle);
                startActivityForResult(intent, 100);
            }
        });
        bdr.setPositiveButton("導航", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + sp.getSelectedItem().toString() + " " + sp2.getSelectedItem().toString()));
                intent.setPackage("com.google.android.apps.maps");
//        if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
            }
        });
        bdr.setCancelable(true);
        bdr.show();
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

    //
    public void TextChange() {
        result = "";
        int price = 0;
        price += drinkPrice;
        price += addPrice;
        result += et.getText().toString() + "," + et2.getText().toString();
        result += "," + name + "," + store + "," + drink;
        result += "," + sugar + "," + ice + "," + add + ",共" + price + "元";
        tv.setText(result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView textView = (TextView) findViewById(R.id.textView9);

        if (resultCode == 200) {
            String str = data.getStringExtra("sendString");
            int i = data.getIntExtra("index", 0);
            tv.setText(str);

            selected.remove(i);
            selected.add(i, str);

            lv = (ListView) findViewById(R.id.listview);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    selected);
            lv.setAdapter(arrayAdapter);
        } else {
            textView.setText(requestCode);
            finish();
        }
    }
}