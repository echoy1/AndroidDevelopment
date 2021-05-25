package com.example.recylerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Bob the Builder", "BobBuilder@gmail.com", "https://i.pinimg.com/originals/e5/7a/98/e57a98d8ee956cd0abb8213bf7950bcc.jpg"));
        contacts.add(new Contact("Bobby the Builder", "BobbyBuilder@gmail.com", "https://i.pinimg.com/originals/e5/7a/98/e57a98d8ee956cd0abb8213bf7950bcc.jpghttps://i.pinimg.com/236x/ec/a0/d4/eca0d445921b57e52a7a7fec64348fcb--bob-the-builder-strips.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}