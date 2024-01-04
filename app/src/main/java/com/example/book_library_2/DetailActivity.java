package com.example.book_library_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

// DetailActivity.java
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleTextView = findViewById(R.id.textView2); //references added
        TextView authorTextView = findViewById(R.id.authoTextView);
        TextView summaryTextView = findViewById(R.id.summarytextView);

        Intent intent = getIntent();   //explicit intent (within the app)
        String title = ((Intent) intent).getStringExtra("title");
        String author = intent.getStringExtra("author");
        String summary = intent.getStringExtra("summary");

        titleTextView.setText(title);
        authorTextView.setText(author);
        summaryTextView.setText(summary);
    }
}
