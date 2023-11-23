package com.example.llamadastelefono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private final String[] telefonos = {
            "111111111",
            "222222222",
            "333333333",
            "444444444",
            "555555555",
            "666666666"
    };
    private ImageButton[] botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botones = new ImageButton[] {
                findViewById(R.id.btn1),
                findViewById(R.id.btn2),
                findViewById(R.id.btn3),
                findViewById(R.id.btn4),
                findViewById(R.id.btn5),
                findViewById(R.id.btn6)
        };

        for (int i = 0; i < botones.length; i++) {
            int telI = i;
            botones[i].setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + telefonos[telI]));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            });
        }
    }
}