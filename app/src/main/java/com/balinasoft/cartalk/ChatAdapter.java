package com.balinasoft.cartalk;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatAdapter extends ArrayAdapter<String>{

    Context context;
    String [] names;

    public ChatAdapter(Context context, String[] names) {
        super(context, R.layout.item_chat_list, names);
        this.context=context;
        this.names=names;
    }

    class ViewHolder
    {
        LinearLayout ll_header;
        LinearLayout ll_footer;
        ImageView iv_header_left;
        ImageView iv_header_right;
        ImageView iv_footer_left;
        ImageView iv_footer_right;
        TextView tv_header;
        TextView tv_footer;
        TextView tv_time;
        Button btn_chat;

        public ViewHolder(View v)
        {
            ll_header=(LinearLayout)v.findViewById(R.id.ll_chat_iv_header);
            ll_footer=(LinearLayout)v.findViewById(R.id.ll_chat_iv_footer);
            iv_header_left=(ImageView)v.findViewById(R.id.iv_chat_ll_header_left);
            iv_header_right=(ImageView)v.findViewById(R.id.iv_chat_ll_header_right);
            iv_footer_left=(ImageView)v.findViewById(R.id.iv_chat_ll_footer_left);
            iv_footer_right=(ImageView)v.findViewById(R.id.iv_chat_ll_footer_right);
            tv_header=(TextView)v.findViewById(R.id.tv_header_chat);
            tv_footer=(TextView)v.findViewById(R.id.tv_footer_chat);
            tv_time=(TextView)v.findViewById(R.id.tv_chat_time);
            btn_chat=(Button)v.findViewById(R.id.btn_chat_info);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_chat_list,null,true);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        int id=context.getResources().getIdentifier("w_knight", "drawable", "com.balinasoft.cartalk");
        viewHolder.iv_header_left.setImageResource(id);
        viewHolder.iv_header_right.setImageResource(id);
        viewHolder.iv_footer_left.setImageResource(id);
        viewHolder.iv_footer_right.setImageResource(id);
        viewHolder.tv_time.setText("1213");
        viewHolder.tv_footer.setText("Lorem ipsum");
        viewHolder.tv_header.setText("Lorem ipsum");
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ChatActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
