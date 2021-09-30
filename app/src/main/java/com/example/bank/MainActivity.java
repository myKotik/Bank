package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView data, dollar, euro;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.login);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
        //кнопка отмена
        Button cancel = dialog.findViewById(R.id.cancle);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent();

                }catch (Exception e){

                }
            }
        });
        dialog.show();



        /*dollar = findViewById(R.id.textView3);
        euro = findViewById(R.id.textView4);*/

        //Дата 
        data = findViewById(R.id.data);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDataFormatUrl = new SimpleDateFormat("dd/MM/yyyy");
        String d = simpleDataFormat.format(c.getTime());
        String f = simpleDataFormatUrl.format(c.getTime());
        data.setText(d);

        final String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + f;


      /*  new Thread(() -> {
            try {
                String content = download(url);

                ValuteXmlParser parser = new ValuteXmlParser();
                if (parser.parse(content)) {

                    ArrayList<Valute> users = parser.getValutes();

                    runOnUiThread(() -> {
                        for (int i = 0; i < users.size(); i++) {
                            Valute item = users.get(i);
                            String charCode = item.getCharCode();
                            String Value = item.getValue();
                            if (charCode.equals("USD")) {
                                dollar.setText(Value);
                            } else if (charCode.equals("EUR")) {
                                euro.setText(Value);
                            }
                        }
                    });
                }

            } catch (IOException ex) {
                Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }).start();*/

    }

    private String download(String urlPath) throws IOException {
        StringBuilder xmlResult = new StringBuilder();
        BufferedReader reader = null;
        InputStream stream = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                xmlResult.append(line);
            }
            return xmlResult.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}