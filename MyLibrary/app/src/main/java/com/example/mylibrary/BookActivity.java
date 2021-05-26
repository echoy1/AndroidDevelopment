package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        String longDescription = "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent at dolor porttitor, suscipit lectus sit amet, hendrerit nunc. Nulla pulvinar ultrices augue tristique ultrices. Duis vestibulum in metus nec aliquam. Etiam eu elit vel ex facilisis interdum. Integer nibh turpis, venenatis non fringilla in, congue in lectus. Suspendisse feugiat aliquam sapien id iaculis. Duis sit amet mattis ligula, eu blandit neque. Donec ut tempus dolor. Donec ut nulla vehicula, suscipit sapien non, consequat arcu. Phasellus arcu erat, imperdiet malesuada urna ac, vehicula pretium purus.\n" +
                "\n" +
                "Quisque non suscipit est. Curabitur sit amet libero accumsan, vestibulum diam et, gravida neque. Donec at feugiat tortor, ac tincidunt augue. In fringilla nibh libero, vel eleifend nisl tincidunt et. Duis maximus suscipit ultricies. Cras elementum consequat augue vel tempus. Integer sit amet sapien quis ligula ullamcorper dapibus eu sed mi. Donec ac semper libero. Donec enim neque, suscipit vel molestie vitae, condimentum eu sapien. Nunc placerat ultricies convallis. Cras in dui leo.\n" +
                "\n" +
                "Nam blandit rhoncus facilisis. Duis id dolor pellentesque, lacinia mi suscipit, pretium nunc. Donec convallis augue eget velit sodales sollicitudin. Cras quis ultricies lorem. Suspendisse a ante at urna suscipit scelerisque. Donec eget pellentesque orci. Ut rhoncus lobortis maximus. Vivamus id ornare nisl. Mauris posuere rutrum lacus et facilisis. Nullam ullamcorper sem odio, id blandit arcu maximus sit amet. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas dictum ultrices hendrerit. Proin iaculis sapien quis ante iaculis, venenatis tristique nunc sodales. Integer mattis leo tortor, quis luctus nunc sagittis eget. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; ";

        Book book = new Book(1, "1Q84", "Haruki Murakami", 1350, "https://images-na.ssl-images-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg"
                ,"A work of maddening brilliance", longDescription);
        setData(book);

    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageURL())
                .into(bookImage);
    }

    private void initViews() {
        txtAuthor = findViewById(R.id.txtAuthorName);
        txtBookName = findViewById(R.id.txtBookName);
        txtPages = findViewById(R.id.txtPages);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorite);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToReadList);

        bookImage = findViewById(R.id.imgBook);
    }
}