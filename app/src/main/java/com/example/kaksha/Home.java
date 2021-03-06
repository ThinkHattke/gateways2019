package com.example.kaksha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kaksha.Adapter.RecyclerViewCardAdapter;
import com.example.kaksha.DB.TinyDB;
import com.example.kaksha.Model.Card;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewCardAdapter adapter;
    private List<Card> cards = new ArrayList<>();
    private TinyDB db;
    private ImageView allextras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        allextras = findViewById(R.id.allextras);
        allextras.setOnClickListener(this);

        db = new TinyDB(Home.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewCardAdapter(Home.this);
        cards.add(new Card("Hey"));
        cards.add(new Card("Good morning"));
        cards.add(new Card("Cheerful Vibes"));
        cards.add(new Card("Let's play a game?"));
        adapter.setListContent(cards);
        recyclerView.setAdapter(adapter);

        TextView name = findViewById(R.id.name);
        name.setText(db.getString("name"));

        findViewById(R.id.textView).setOnClickListener(v-> {

            startActivity(new Intent(Home.this, Question.class));
            finish();

        });
    }

    @Override
    public void onClick(View v) {
        if (v == allextras) {
            Intent i = new Intent(Home.this, Recommendations.class);
            finish();
            startActivity(i);
        }
    }

}
