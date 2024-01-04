package com.example.book_library_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// MainActivity.java
public class MainActivity extends AppCompatActivity {   ///sets the page layout

    private ListView listView;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        bookList = generateSampleBooks();
        BookAdapter adapter = new BookAdapter(this, bookList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book selectedBook = bookList.get(position);
                openDetailActivity(selectedBook);
            }
        });
    }

    private void openDetailActivity(Book book) {
        Intent intent = new Intent(this, DetailActivity.class); //intent created
        intent.putExtra("title", book.getTitle());  //putextra() is a method in the Intent class used to attach/add additional data to an Intent before it's passed to another component such as activity, service, or broadcast receiver
        intent.putExtra("author", book.getAuthor());
        intent.putExtra("summary", book.getSummary());
        intent.putExtra("number", book.getCount());

        startActivity(intent);
    }

    private List<Book> generateSampleBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Author 1", "Summary for Book 1"));
        books.add(new Book("Book 2", "Author 2", "Summary for Book 2"));
        // Add more books as needed
        return books;
    }
}
