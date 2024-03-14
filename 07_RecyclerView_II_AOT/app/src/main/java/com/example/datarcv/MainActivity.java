package com.example.datarcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Eren Jeager", "erenjaeger22@email.com", R.drawable.eren));
        items.add(new Item("Mikasa Ackerman", "ackmikasa23@email.com", R.drawable.mikasa));
        items.add(new Item("Levi Ackerman", "acklevi15@email.com", R.drawable.levi));
        items.add(new Item("Marcel Galliard", "galliard89@email.com", R.drawable.galliard));
        items.add(new Item("Falco Grice", "gricefalco45@email.com", R.drawable.falco));
        items.add(new Item("Bertholdt", "bertholdt11@email.com", R.drawable.bertholdt));
        items.add(new Item("Gabi Braun", "gabibraun88@email.com", R.drawable.gabi));
        items.add(new Item("Armin Arlelt", "armin112@email.com", R.drawable.armin));
        items.add(new Item("Conny Springer", "conny445@email.com", R.drawable.conny));
        items.add(new Item("Jean", "jean669@email.com", R.drawable.jean));
        items.add(new Item("Sasha Braus", "sashabraus88@email.com", R.drawable.sasha));
        items.add(new Item("Erwin Smith", "erwinsmith442@email.com", R.drawable.erwin));
        items.add(new Item("Varis", "varis76@email.com", R.drawable.varis));
        items.add(new Item("Hange Zoe", "hangezoe99@email.com", R.drawable.hange));
        items.add(new Item("Dhalis Zachary", "zachary@email.com", R.drawable.zachary));
        items.add(new Item("Historia Reiss", "historia67@email.com", R.drawable.historia));
        items.add(new Item("Fritz", "fritz77@email.com", R.drawable.fritz));
        items.add(new Item("Willy Tybur", "WillyTyur67@email.com", R.drawable.willy));
        items.add(new Item("Ymir", "ymir55@email.com", R.drawable.ymir));
        items.add(new Item("Klaus", "klaus79@email.com", R.drawable.klaus));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}