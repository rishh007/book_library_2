// SummaryActivity.java
package com.example.book_library_2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Retrieve the selected word count from the Intent
        int wordCount = getIntent().getIntExtra("wordCount", 0);

        // Display the selected word count
        TextView wordCountTextView = findViewById(R.id.wordCountTextView);
        wordCountTextView.setText("Summary in " + wordCount + " words");

        // Implement the logic for SummaryActivity based on the selected word count
        // You can use the wordCount variable here
    }
}
