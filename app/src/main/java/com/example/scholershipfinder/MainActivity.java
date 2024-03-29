package com.example.scholershipfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AndroidVersion> items=new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listView=findViewById(R.id.myList);
        //to create customer adopter
        //1.List item Layout
        //2.List item java class
        //3.customer adopter extend Arrayadopter

        items.add(new AndroidVersion("Australian catholic university",R.drawable.acu1));
        items.add(new AndroidVersion("University of sydney",R.drawable.sydny));
        items.add(new AndroidVersion("University of Queensland",R.drawable.download));
        items.add(new AndroidVersion("Australian national university",R.drawable.ausinational));
        items.add(new AndroidVersion("University of South wales",R.drawable.southweles));
        items.add(new AndroidVersion("University of Notradame",R.drawable.nd));

        listView.setAdapter(new MyAdapter(MainActivity.this,R.layout.my_list_item,items));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent=new Intent(MainActivity.this,Australiancatholicuniversity.class);
                    startActivity(intent);
                }

                if(i==1)
                {
                    Intent intent=new Intent(MainActivity.this,Universityofsydney.class);
                    startActivity(intent);
                }

                if(i==2)
                {
                    Intent intent=new Intent(MainActivity.this,UniversityofQueensland.class);
                    startActivity(intent);
                }

                if(i==3)
                {
                    Intent intent=new Intent(MainActivity.this,Australiannationaluniversity.class);
                    startActivity(intent);
                }

                if(i==4)
                {
                    Intent intent=new Intent(MainActivity.this,UniversityofSouthwales.class);
                    startActivity(intent);
                }

                if(i==5)
                {
                    Intent intent=new Intent(MainActivity.this,UniversityofNotradame.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu,menu);//inflates myenu.xml and display it in app

        MenuItem menuItem=menu.findItem(R.id.searchMenu);
        SearchView searchView=(SearchView) menuItem.getActionView();//return the objet of the class that is specify within the "actionview class"

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {//it will get called with every new input string

                ArrayList<AndroidVersion> results=new ArrayList<>();

                for(AndroidVersion x: items)
                {
                    if(x.VersionName.contains(newText))
                        results.add(x);

                }

                ((MyAdapter)listView.getAdapter()).update(results);//to refresh the listview

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
    }

