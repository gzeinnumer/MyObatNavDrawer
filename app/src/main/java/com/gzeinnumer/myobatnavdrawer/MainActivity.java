package com.gzeinnumer.myobatnavdrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gzeinnumer.myobatnavdrawer.adapter.AdapterReadOpData;
import com.gzeinnumer.myobatnavdrawer.model.ResponseReadObat;
import com.gzeinnumer.myobatnavdrawer.server.RetroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//hay murid
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    RecyclerView recyclerOpData;

    private Context contenx;
    private List<ResponseReadObat> list;
    ArrayList<ResponseReadObat> data;

    AdapterReadOpData adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerOpData = findViewById(R.id.recycler_op_data);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getAllDataObat();
    }

    private void getAllDataObat() {
        RetroServer.getInstance().getAllOpData().enqueue(new Callback<List<ResponseReadObat>>() {
            @Override
            public void onResponse(Call<List<ResponseReadObat>> call, Response<List<ResponseReadObat>> response) {
                list =response.body();

                data = new ArrayList<>();
                for (int i=0; i<list.size(); i++){
                    data.add(new ResponseReadObat(
                            list.get(i).getSatuan(),
                            list.get(i).getUnitID(),
                            list.get(i).getBrgID(),
                            list.get(i).getBrgName(),
                            list.get(i).getJam(),
                            list.get(i).getLokasiName(),
                            list.get(i).getQty(),
                            list.get(i).getTgl(),
                            list.get(i).getLokasiID(),
                            list.get(i).getUnitName()));
                }
                initDataToRecycler();
            }

            @Override
            public void onFailure(Call<List<ResponseReadObat>> call, Throwable t) {

            }
        });
    }

    private void initDataToRecycler() {
        adapter = new AdapterReadOpData(this, data);
        recyclerOpData.setLayoutManager(new LinearLayoutManager(this));
        recyclerOpData.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // panggil id yang ada pada activyt_main_drawer
        if (id == R.id.nav_def_lokasi) {
            // Handle the camera action
        } else if (id == R.id.nav_upload_hasil) {
            Intent intent = new Intent(getApplicationContext(), ScanActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            this.finish();
            System.exit(0);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
