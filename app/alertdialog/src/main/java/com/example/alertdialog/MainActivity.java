package com.example.alertdialog;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 显示对话框
        showLoginDialog();
    }

    private void showLoginDialog() {
        // 加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_main, null);

        // 创建 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        // 获取布局中的按钮
        Button cancelButton = dialogView.findViewById(R.id.cancel_button);
        Button signinButton = dialogView.findViewById(R.id.signin_button);

        // 设置按钮点击事件
        cancelButton.setOnClickListener(v -> dialog.dismiss());
        signinButton.setOnClickListener(v -> {
            EditText username = dialogView.findViewById(R.id.username);
            EditText password = dialogView.findViewById(R.id.password);

            // 获取输入内容
            String user = username.getText().toString();
            String pass = password.getText().toString();

            // 这里可以处理登录逻辑
            dialog.dismiss();
        });
    }
}
