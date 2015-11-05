package com.balinasoft.cartalk;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageAdapter extends ArrayAdapter<String>{

    Context context;
    String[] names;

    public MessageAdapter(Context context, String[] names) {
        super(context, R.layout.item_chat,names);
        this.context=context;
        this.names=names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_chat,null,true);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        int id=context.getResources().getIdentifier("w_knight", "drawable", "com.balinasoft.cartalk");
        viewHolder.iv_left.setImageResource(id);
        viewHolder.iv_right.setImageResource(id);
        viewHolder.tv_name.setText("Петров Петр");
        viewHolder.tv_text.setText("Этот текст показывает нам как будет выглядеть текст сообщения, которое будет получено или отправлено обладателем этого чудесного приложения");
        viewHolder.tv_time.setText("14:15");
        return convertView;
    }

    class ViewHolder
    {
        ImageView iv_left;
        ImageView iv_right;
        TextView tv_name;
        TextView tv_text;
        TextView tv_time;

        ViewHolder(View v) {
            this.iv_left = (ImageView)v.findViewById(R.id.iv_chat_item_left);
            this.iv_right = (ImageView)v.findViewById(R.id.iv_chat_item_right);
            this.tv_name = (TextView)v.findViewById(R.id.tv_item_chat_name);
            this.tv_text = (TextView)v.findViewById(R.id.tv_item_chat_text);
            this.tv_time = (TextView)v.findViewById(R.id.tv_item_chat_time);
        }
    }

}
