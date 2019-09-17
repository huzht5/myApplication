package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondActivity extends BaseActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    private List<Fruit> fruitList = new ArrayList<>();

    public static void actionStart(Context context, String data){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param", data);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        TitleLayout titleLayout = (TitleLayout) findViewById(R.id.myTitleLayout);
        titleLayout.setTitle("控件");

        Intent intent = getIntent();
        String title = intent.getStringExtra("param");

        TextView text = (TextView) findViewById(R.id.mytext);
        text.setText(title);

        editText = (EditText) findViewById(R.id.myedit);
        imageView = (ImageView) findViewById(R.id.myimage);
        progressBar = (ProgressBar) findViewById(R.id.mypros);
        Button button = (Button) findViewById(R.id.mybutton);
        Button button1 = (Button) findViewById(R.id.mybutton1);
        Button button2 = (Button) findViewById(R.id.mybutton2);
        Button button3 = (Button) findViewById(R.id.mybutton3);
        Button button4 = (Button) findViewById(R.id.mybutton4);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits(){
        for (int i = 0; i < 2; i++){
            Fruit lemon = new Fruit(getRandomLengthName("Lemon"), R.drawable.lemon);
            fruitList.add(lemon);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit berry = new Fruit(getRandomLengthName("Berry"), R.drawable.berry);
            fruitList.add(berry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry);
            fruitList.add(cherry);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape);
            fruitList.add(grape);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.mybutton:
                String inputText = editText.getText().toString();
                Toast.makeText(SecondActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mybutton1:
                imageView.setImageResource(R.drawable.i2);
                break;
            case R.id.mybutton2:
                /*if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }
                else {
                    progressBar.setVisibility(View.GONE);
                }*/
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                break;
            case R.id.mybutton3:
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do something
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do something
                    }
                });
                dialog.show();
                break;
            case R.id.mybutton4:
                ProgressDialog progressDialog = new ProgressDialog(SecondActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
