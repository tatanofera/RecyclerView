package com.example.recyclerview;

import static com.example.recyclerview.ItemAdapter.SPAN_COUNT_ONE;
import static com.example.recyclerview.ItemAdapter.SPAN_COUNT_THREE;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private GridLayoutManager gridLayoutManager;
    private List items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        initItemsData();

        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);
        itemAdapter = new ItemAdapter(items, gridLayoutManager);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initItemsData() {
        items = new ArrayList<>(10);
        items.add(new Item(R.drawable.itb, "Institut Teknologi Bandung", "Institut Teknologi Bandung adalah sebuah perguruan tinggi negeri yang berkedudukan di Kota Bandung."));
        items.add(new Item(R.drawable.its, "Institut Teknologi Sepuluh Nopember", "Institut Teknologi Sepuluh Nopember adalah perguruan tinggi negeri yang terletak di Surabaya."));
        items.add(new Item(R.drawable.ub, "Universitas Brawijaya", "Universitas Brawijaya adalah perguruan tinggi di Indonesia yang berdiri pada tahun 1963 di Kota Malang, Jawa Timur."));
        items.add(new Item(R.drawable.ugm, "Universitas Gajah Mada", "Universitas Gadjah Mada merupakan universitas negeri di Indonesia yang didirikan oleh Pemerintah Republik Indonesia pada tanggal 19 Desember 1949."));
        items.add(new Item(R.drawable.ui, "Universitas Indonesia", "Universitas Indonesia disingkat sebagai UI, adalah sebuah perguruan tinggi di Indonesia. Kampus utamanya terletak di bagian Utara dari Depok, Jawa Barat."));
        items.add(new Item(R.drawable.unair, "Universitas Airlangga", "Universitas Airlangga adalah sebuah perguruan tinggi negeri yang terletak di Surabaya, Jawa Timur."));
        items.add(new Item(R.drawable.undip, "Universitas Diponegoro", "Universitas Diponegoro disingkat sebagai Undip adalah sebuah perguruan tinggi negeri di Indonesia yang berlokasi di Semarang, Jawa Tengah."));
        items.add(new Item(R.drawable.unej, "Universitas Jember", "Universitas Jember adalah perguruan tinggi negeri yang terletak di Kabupaten Jember, Provinsi Jawa Timur."));
        items.add(new Item(R.drawable.unpad, "Institut Padjajaran", "Universitas Padjadjaran adalah sebuah perguruan tinggi negeri di Bandung, Jawa Barat."));
        items.add(new Item(R.drawable.unud, "Universitas Udayana", "Universitas Udayana adalah perguruan tinggi negeri di yang berada di Jimbaran, Kabupaten Badung, Bali."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_switch_layout) {
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
    }

    private void switchIcon(MenuItem item) {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_THREE) {
            item.setIcon(getResources().getDrawable(R.drawable.ic_span_3));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.ic_span_1));
        }
    }
}