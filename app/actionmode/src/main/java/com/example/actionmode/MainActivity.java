package com.example.actionmode;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;
    private ActionMode actionMode;
    private ArrayList<Integer> selectedPositions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置 Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);

        // 初始化列表数据
        itemList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            itemList.add("Item " + i);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, itemList);
        listView.setAdapter(adapter);

        // 设置短按选择逻辑
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // 初始化 ActionMode（仅当尚未激活时）
            if (actionMode == null) {
                actionMode = startActionMode(actionModeCallback);
            }

            // 切换选中状态
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(Integer.valueOf(position));
                view.setSelected(false);
            } else {
                selectedPositions.add(position);
                view.setSelected(true);
            }

            // 更新 ActionMode 标题
            actionMode.setTitle(selectedPositions.size() + " 已选择");

            // 如果没有选中任何项，则关闭 ActionMode
            if (selectedPositions.isEmpty()) {
                actionMode.finish();
            }
        });
    }

    // ActionMode 的回调
    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // 加载菜单
            getMenuInflater().inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.menu_delete) {
                // 删除选中的项目
                for (int i = selectedPositions.size() - 1; i >= 0; i--) {
                    itemList.remove((int) selectedPositions.get(i));
                }
                adapter.notifyDataSetChanged();
                mode.finish(); // 关闭 ActionMode
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // 清空选中状态
            selectedPositions.clear();
            actionMode = null;
        }
    };
}
