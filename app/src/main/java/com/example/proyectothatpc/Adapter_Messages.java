package com.example.proyectothatpc;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;




public class Adapter_Messages extends RecyclerView.Adapter<Holder_Messages> {

    private List<Message> listMessage = new ArrayList<>();
    public Context c;


    public Adapter_Messages(Context c) {
        this.c = c;
    }

    public void addMessage(Message m){
        listMessage.add(m);
        notifyItemInserted(listMessage.size());
    }

    @Override
    public Holder_Messages onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_messages, parent, false);
        return new Holder_Messages(v);
    }

    @Override
    public void onBindViewHolder(final Holder_Messages holder, final int position) {
        holder.getUsername().setText(listMessage.get(position).getUsername());
        holder.getMessage().setText(listMessage.get(position).getMessage());

        //Date format message
//        Long time = listMessage.get(position).getTime();
//        Date date = new Date(time);
//        SimpleDateFormat sdf = new SimpleDateFormat("k:mm");
//
//        holder.getMsgTime().setText(sdf.format(date));
    }



    @Override
    public int getItemCount() {
        return listMessage.size();
    }
}
