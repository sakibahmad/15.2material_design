package com.example.root.a152materialdesign;

/**
 * Created by root on 2/8/17.
 */

import android.support.v7.widget.Toolbar;

        import android.content.res.ColorStateList;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
       // import android.support.v7.widget.graphics;
        import android.support.v7.widget.LinearLayoutManager;

        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.Menu;
        import android.view.MenuItem;
import android.view.View;
        import android.widget.Toast;

public class CardView extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    int defaultColor;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {

            setSupportActionBar(toolbar);

        }

        getSupportActionBar().setTitle("Android Versions");

        //this.getSupportActionBar().hide();

        defaultColor = ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_dark);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

       // getPhoto();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final String[] myDataset = { "Alpha", "Beta", "CupCake", "Donut",
                "Eclair", "Froyo", "Gingerbread", "Honeycomb",
                "Ice Cream Sandwitch", "JellyBean", "KitKat", "LollyPop","MarshMallow" };




        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
      CardViewAdapter cardViewAdapter = new CardViewAdapter(myDataset);
        mRecyclerView.setAdapter(cardViewAdapter);

        // Implementation of onItemClick RecycleView
        // http://stackoverflow.com/questions/24471109/recyclerview-onclick/26196831#26196831

        mRecyclerView.addOnItemTouchListener(new RecyclerListener(
                getApplicationContext(),
                new RecyclerListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(getApplicationContext(),
                                "Data : " + myDataset[position],
                                Toast.LENGTH_SHORT).show();

                    }
                }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add) {
            Toast.makeText(getApplicationContext(), "Add Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "Delete Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

  //  private void getPhoto() {
    //    Bitmap photo = BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_delete);
  //      colorize(photo);
    }

    /*private void colorize(Bitmap photo) {
        mPalette = Palette.generate(photo);
        applyPalette();
    }

    private void applyPalette() {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
        mRecyclerView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        toolbar.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
        fab.setBackgroundTintList(ColorStateList.valueOf(mPalette.getLightVibrantColor(defaultColor)));

    }*/
