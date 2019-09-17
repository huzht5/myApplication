package com.example.administrator.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Log.d(TAG, "onCreate: 成功啦!!!");
        Button button = (Button)  findViewById(R.id.button);
        Button button1 = (Button)  findViewById(R.id.button1);
        Button button2 = (Button)  findViewById(R.id.button2);
        Button button3 = (Button)  findViewById(R.id.button3);
        Button button4 = (Button)  findViewById(R.id.button4);
        Button button5 = (Button)  findViewById(R.id.button5);
        Button button6 = (Button)  findViewById(R.id.button6);
        Button button7 = (Button)  findViewById(R.id.button7);
        Button button8 = (Button)  findViewById(R.id.button8);
        Button button9 = (Button)  findViewById(R.id.button9);
        Button button10 = (Button)  findViewById(R.id.button10);
        Button button11 = (Button)  findViewById(R.id.button11);
        Button button12 = (Button)  findViewById(R.id.button12);
        Button button13 = (Button)  findViewById(R.id.button13);
        Button button14 = (Button)  findViewById(R.id.button14);
        Button button15 = (Button)  findViewById(R.id.button15);
        Button button16 = (Button)  findViewById(R.id.button16);
        Button button17 = (Button)  findViewById(R.id.button17);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);
                SecondActivity.actionStart(MainActivity.this, "这是第二个界面！！！");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatActivity.actionStart(MainActivity.this);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity.actionStart(MainActivity.this);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetectBroadcastActivity.actionStart(MainActivity.this);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.actionStart(MainActivity.this);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePalActivity.actionStart(MainActivity.this);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RuntimePermissionActivity.actionStart(MainActivity.this);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactsActivity.actionStart(MainActivity.this);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProviderActivity.actionStart(MainActivity.this);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationActivity.actionStart(MainActivity.this);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MP4Activity.actionStart(MainActivity.this);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.actionStart(MainActivity.this);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkTestActivity.actionStart(MainActivity.this);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidThreadTestActivity.actionStart(MainActivity.this);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceActivity.actionStart(MainActivity.this);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceBestPracticeActivity.actionStart(MainActivity.this);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LBSTestActivity.actionStart(MainActivity.this);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialTestActivity.actionStart(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
