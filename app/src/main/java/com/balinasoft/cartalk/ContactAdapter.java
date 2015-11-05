package com.balinasoft.cartalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ContactAdapter extends ArrayAdapter<String> {

    String[] names;
    Context context;

    public ContactAdapter(Context context, String[] names) {
        super(context, R.layout.item_contact, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, null, true);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        int id = context.getResources().getIdentifier("w_knight", "drawable", "com.balinasoft.cartalk");
        viewHolder.iv_photo.setImageResource(id);
        viewHolder.tv_name.setText("Петр Петрович");
        viewHolder.tv_model.setText("model qwerty");
        viewHolder.tv_color.setText("black");
        viewHolder.tv_number.setText("1234567");

        return convertView;
    }

    class ViewHolder {
        ImageView iv_photo;
        TextView tv_name;
        TextView tv_model;
        TextView tv_color;
        TextView tv_number;

        ViewHolder(View v) {
            this.iv_photo = (ImageView) v.findViewById(R.id.iv_contact_photo);
            this.tv_name = (TextView) v.findViewById(R.id.tv_contact_name);
            this.tv_model = (TextView) v.findViewById(R.id.tv_contact_model);
            this.tv_color = (TextView) v.findViewById(R.id.tv_contact_color);
            this.tv_number = (TextView) v.findViewById(R.id.tv_contact_number);
        }
    }


}
