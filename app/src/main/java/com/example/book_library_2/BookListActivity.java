package com.example.book_library_2;// BookListActivity.java

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve genre information from the intent
        String genre = getIntent().getStringExtra("genre");

        // Fetch the list of books based on the selected genre
        List<String> books = getBooksForGenre(genre);

        // Display the list of books in a ListView
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, books);
        listView.setAdapter(adapter);
    }

    private List<String> getBooksForGenre(String genre) {
        // TODO: Implement logic to fetch books based on the selected genre
        // Replace this with your actual data retrieval logic (e.g., querying a database)
        List<String> books = new ArrayList<>();
        if ("Fiction".equals(genre)) {
            books.add("Fiction Book 1");
            books.add("Fiction Book 2");
            books.add("Fiction Book 3");

        } else if ("Non-Fiction".equals(genre)) {
            books.add("Non-Fiction Book 1");
            books.add("Non-Fiction Book 2");
            books.add("Non-Fiction Book 3");
        } else if ("Self-Help".equals(genre)) {
            books.add("Self-Help Book 1");
            books.add("Self-Help Book 2");
            books.add("Self-Help Book 3");
        } else if ("Biography".equals(genre)) {
            books.add("Biography Book 1");
            books.add("Biography Book 2");
            books.add("Biography Book 3");
        } else if ("Economics".equals(genre)) {
            books.add("Economics Book 1");
            books.add("Economics Book 2");
            books.add("Economics Book 3");
        }
        // Can add more genres if needed

        return books;
    }
}
