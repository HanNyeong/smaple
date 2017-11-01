package com.hannyeong.tcpclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText host, port, name;
    private Button btn;
    private String hostv, namev;
    private int portv;

    protected void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.chat01);
        host = (EditText)findViewById(R.id.chat_host);
        port = (EditText)findViewById(R.id.chat_port);
        name = (EditText)findViewById(R.id.chat_name);
        btn = (Button)findViewById(R.id.chat_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hostv = host.getText().toString().trim();
                portv = Integer.parseInt(port.getText().toString().trim());
                namev = name.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, ChatRoom.class);
                Bundle bundle = new Bundle();
                bundle.putString("host", hostv);
                bundle.putString("name", namev);
                bundle.putInt("port", portv);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
