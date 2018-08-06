package com.example.narroju.theluxuryapp.House;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.narroju.theluxuryapp.R;


public class HouseActivity extends Activity {
    ListView l;
    String[] index;
    int[] icons = {R.drawable.house_histroy, R.drawable.house_archi};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_main);

        Resources resources = getResources();
        index = resources.getStringArray(R.array.House_index);

        l = findViewById(R.id.house_list_view);
        HouseAdapter houseAdapter = new HouseAdapter(this, index, icons);
        l.setAdapter(houseAdapter);
    }
}

class HouseAdapter extends ArrayAdapter<String>{

    private Context context;
   private int[] images;
    private     String[] indexarray;

    HouseAdapter(Context c,String[] index, int imgs[]){

        super(c, R.layout.custom_house_view, R.id.house_text_view, index); // we are just feeding the super class constructor

        this.context = c;
        this.images = imgs;
        this.indexarray = index;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        /* when we inflate the entire parent row to the custom single row, when ever we scroll the list view
        the inflater method is called and inflation is done from the beginning. To avoid memory waste age
        and as the inflation is already done, we just need to make is once.
         */
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_house_view, parent, false);
        }

        ImageView houseimage = row.findViewById(R.id.house_image_view);
        TextView housetext = row.findViewById(R.id.house_text_view);

        houseimage.setImageResource(images[position]);
        housetext.setText(indexarray[position]);

        return row;
    }
}