package com.example.xml;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置自定义 Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // 将 Toolbar 设置为应用的 ActionBar

        // 初始化 TextView
        testText = findViewById(R.id.test_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_test, menu);
        return true;
    }




@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.font_small) {
            testText.setTextSize(20);
            return true;
        } else if (id == R.id.font_medium) {
            testText.setTextSize(26);
            return true;
        } else if (id == R.id.font_large) {
            testText.setTextSize(30);
            return true;
        } else if (id == R.id.color_red) {
            testText.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return true;
        } else if (id == R.id.color_black) {
            testText.setTextColor(getResources().getColor(android.R.color.black));
            return true;
        } else if (id == R.id.normal_item) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
