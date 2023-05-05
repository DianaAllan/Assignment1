package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainStartActivity extends AppCompatActivity implements CaptionedImagesAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);

        RecyclerView recycler = findViewById(R.id.recycler);

        String[] captions = new String[Games.games.length];
        int[] ids = new int[Games.games.length];

        for (int i = 0; i < captions.length; i++) {
            captions[i] = Games.games[i].getName();
            ids[i] = Games.games[i].getImageID();
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids);
        adapter.setOnItemClickListener(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainStartActivity.this, MathGame.class);
        intent.putExtra("ITEM_POSITION", position);
        startActivity(intent);
    }
}
