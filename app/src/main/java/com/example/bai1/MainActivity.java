package com.example.bai1;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText aInput = findViewById(R.id.aInput);
        EditText bInput = findViewById(R.id.bInput);
        Button calcButton = findViewById(R.id.calcButton);
        TextView resultText = findViewById(R.id.resultText);
        Button playVideoButton = findViewById(R.id.playVideoButton);
        VideoView videoView = findViewById(R.id.videoView);
        ImageView imageView = findViewById(R.id.imageView);

        calcButton.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(aInput.getText().toString());
                double b = Double.parseDouble(bInput.getText().toString());
                double c = Math.sqrt(a * a + b * b);
                resultText.setText("Cạnh huyền: " + c);
            } catch (NumberFormatException e) {
                resultText.setText("Vui lòng nhập số hợp lệ");
            }
        });

        playVideoButton.setOnClickListener(v -> {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample_vid);
            videoView.setVideoURI(videoUri);
            videoView.start();
        });

        imageView.setOnClickListener(v -> {
            imageView.setImageResource(R.drawable.sample_image);
        });
    }
}