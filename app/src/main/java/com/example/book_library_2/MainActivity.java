package com.example.book_library_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private List<Book> bookList;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        Button btnFiction = findViewById(R.id.btnFiction);
        btnFiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookListActivity("Fiction"); // Pass the genre name
            }
        });

        private void openBookListActivity(String genre) {
            Intent intent = new Intent(this, BookListActivity.class);
            intent.putExtra("genre", genre);
            startActivity(intent);
        }
        // TODO: Implement logic for handling genre tile clicks and opening corresponding book lists


        drawer = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        ListView listView = findViewById(R.id.listView);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != android.R.id.home) {
            return super.onOptionsItemSelected(item);
        }
        drawer.openDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_summary_100_words:
                openSummaryActivity(100);
                break;
            case R.id.menu_summary_200_words:
                openSummaryActivity(200);
                break;
            case R.id.menu_send_feedback:
                openFeedbackActivity();
                break;
        }

        drawer.closeDrawers();
        return true;
    }

    private void openSummaryActivity(int wordCount) {
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("wordCount", wordCount);
        startActivity(intent);
    }

    private void openFeedbackActivity() {
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }

    private void openDetailActivity(Book book) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", book.getTitle());
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