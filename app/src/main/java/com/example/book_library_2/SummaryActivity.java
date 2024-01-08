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

        // Retrieve the wordCount from the Intent
        int wordCount = getIntent().getIntExtra("wordCount", 100);

        // Use the wordCount variable to implement your logic
        TextView summaryTextView = findViewById(R.id.textView);

        // Depending on the wordCount, you can customize the display or behavior
        if (wordCount == 100) {
            summaryTextView.setText("Summary in 100 words");
            // Implement logic for 100 words summary
        } else if (wordCount == 200) {
            summaryTextView.setText("Summary in 200 words");
            // Implement logic for 200 words summary
        }
    }
}
