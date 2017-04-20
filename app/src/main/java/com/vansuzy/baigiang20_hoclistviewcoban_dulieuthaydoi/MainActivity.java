package com.vansuzy.baigiang20_hoclistviewcoban_dulieuthaydoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrTen;   // nguồn dữ liệu mà thay đổi theo thời gian thì chúng ta nên dùng ArrayList. Mà ở đây chúng ta nhập tên nên chắc chắn nguồn dữ liệu là nguồn chuỗi suy ra ArrayList phải có kiểu chuỗi.
    ArrayAdapter<String> adapterTen;    // Vì nguồn dữ liệu của chúng ta có kiểu chuỗi do đó ArrayAdapter cũng phải có kiểu chuỗi.
    ListView lvTen;
    EditText txtTen;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuuDuLieu();
            }
        });
    }

    private void xuLyLuuDuLieu() {
        String ten = txtTen.getText().toString();
        arrTen.add(ten);    // thêm dữ liệu mới
        adapterTen.notifyDataSetChanged();  // ra lệnh cho ListView cập nhật lại giao diện
        txtTen.setText("");
        txtTen.requestFocus();  // Trong tất cả các hệ thống máy tính thì chúng ta có 2 loại con trỏ: con trỏ chuột và con trỏ văn bản. Hàm requestFocus() sẽ di chuyển con trỏ văn bản đến đúng ô nhập
    }

    private void addControls() {
        arrTen = new ArrayList<String>();
        adapterTen = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTen
        );
        lvTen = (ListView) findViewById(R.id.lvTen);
        lvTen.setAdapter(adapterTen);

        txtTen = (EditText) findViewById(R.id.txtTen);
        btnLuu = (Button) findViewById(R.id.btnLuuDuLieu);
    }
}
