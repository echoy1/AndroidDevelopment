package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and Developed by people\n" +
                        "Check it out");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        intent.putExtra("url", "https://google.com");
                        startActivity(intent);
                    }
                });

                builder.create().show();
            }
        });

        Utils.getInstance(this);
    }

    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorite = findViewById(R.id.btnFavorites);
        btnAbout = findViewById(R.id.btnAbout);
    }
}