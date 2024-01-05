package com.example.book_library_2;

// BookAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_summary, parent, false);
        }

        Book currentBook = getItem(position);

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView authorTextView = convertView.findViewById(R.id.authorTextView);

        if (currentBook != null) {
            titleTextView.setText(currentBook.getTitle());
            authorTextView.setText(currentBook.getAuthor());
        }

        return convertView;
    }
}

