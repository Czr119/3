package com.example.listview;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取 ListView
        ListView listView = findViewById(R.id.listView);

        // 准备数据
        String[] animals = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
        int[] images = {
                R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
                R.drawable.dog, R.drawable.cat, R.drawable.elephant
        };

        // 创建数据列表
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", animals[i]);
            map.put("image", images[i]);
            dataList.add(map);
        }

        // 定义映射关系
        String[] from = {"name", "image"};
        int[] to = {R.id.textView, R.id.imageView};

        // 创建 SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dataList,
                R.layout.list_item, // 使用我们刚刚创建的布局
                from,
                to
        );

        // 设置适配器
        listView.setAdapter(adapter);

        // 设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取点击的动物名称
                String selectedAnimal = animals[position];
                // 显示 Toast 提示
                Toast.makeText(MainActivity.this, selectedAnimal, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
