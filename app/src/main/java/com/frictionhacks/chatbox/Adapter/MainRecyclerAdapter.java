package com.frictionhacks.chatbox.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frictionhacks.chatbox.DataModel.UserMsgListContainer;
import com.frictionhacks.chatbox.R;

import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private UserMsgListContainer mdata;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Root= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_user_row,parent,false);
        return new ViewHolder(Root);


    }

    public MainRecyclerAdapter(UserMsgListContainer data) {
    mdata=new UserMsgListContainer();
    mdata.setUserMsgList(data.getUserMsgList());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(mdata.getUserMsgList().get(position).getmName());

        holder.tvMessage.setText(mdata.getUserMsgList().get(position).getmMessage());



    }

    @Override
    public int getItemCount() {
        return mdata.getUserMsgList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContactPhoto;
        TextView tvName,tvMessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContactPhoto=itemView.findViewById(R.id.user_row_iv_photo);
            tvName=itemView.findViewById(R.id.user_row_tv_name);
            tvMessage=itemView.findViewById(R.id.user_row_tv_last_message);

        }
    }
    public void updateData(UserMsgListContainer data){
        mdata.setUserMsgList(data.getUserMsgList());
        notifyDataSetChanged();

    }
}
