package com.example.hp.fifthtask;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private Button btnRead;
    private Button btnWrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite=(Button)findViewById(R.id.write);
        btnRead=(Button)findViewById(R.id.read);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                OutputStream out=null;
                try {
                    FileOutputStream fileOutputStream=openFileOutput("myfile",MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    String content="wangbin-----2017011403";
                    try {
                        out.write(content.getBytes());
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in=null;
                try {
                    FileInputStream fileInputStream = openFileInput("myfile");
                    in=new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuilder stringBuilder=new StringBuilder("");
                    try{
                        while ((c=in.read())!=-1) {
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if(in!=null)
                            in.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}

