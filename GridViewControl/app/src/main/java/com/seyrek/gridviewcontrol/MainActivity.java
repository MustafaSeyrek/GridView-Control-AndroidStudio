package com.seyrek.gridviewcontrol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<GridItem> list = new ArrayList<>();
    LayoutInflater layoutInflater;
    GridView gridView;
    Adapter adapter = new Adapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        gridView = findViewById(R.id.gridView);

        list.add(new GridItem("Shack",R.drawable.klube));
        list.add(new GridItem("Light",R.drawable.isik));
        list.add(new GridItem("Yellow Flower",R.drawable.cicek));
        list.add(new GridItem("Shack",R.drawable.klube));
        list.add(new GridItem("Light",R.drawable.isik));
        list.add(new GridItem("Yellow Flower",R.drawable.cicek));
        list.add(new GridItem("Shack",R.drawable.klube));
        list.add(new GridItem("Light",R.drawable.isik));
        list.add(new GridItem("Yellow Flower",R.drawable.cicek));
        list.add(new GridItem("Shack",R.drawable.klube));
        list.add(new GridItem("Light",R.drawable.isik));
        list.add(new GridItem("Yellow Flower",R.drawable.cicek));
        list.add(new GridItem("Shack",R.drawable.klube));
        list.add(new GridItem("Light",R.drawable.isik));
        list.add(new GridItem("Yellow Flower",R.drawable.cicek));
        list.add(new GridItem("Shack",R.drawable.klube));
        list.add(new GridItem("Light",R.drawable.isik));
        list.add(new GridItem("Yellow Flower",R.drawable.cicek));

        gridView.setAdapter(adapter);

        //for delete item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete Item");
                builder.setMessage(list.get(position).getTitle()+" will be deleted!");
                builder.setPositiveButton("Okey", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,"Item deleted",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Operation canceled!",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }


    class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if(convertView==null){
                view = layoutInflater.inflate(R.layout.control_cell_item,null);

            }

            TextView textTitle = view.findViewById(R.id.textTitle);
            ImageView imageView = view.findViewById(R.id.imageView);

            textTitle.setText(list.get(position).getTitle());
            imageView.setImageResource(list.get(position).getResourceId());

            return view;
        }
    }

    class GridItem{
        String title;
        int resourceId;

        public GridItem(String title, int resourceId) {
            this.title = title;
            this.resourceId = resourceId;
        }

        public String getTitle() {
            return title;
        }

        public int getResourceId() {
            return resourceId;
        }
    }
}
