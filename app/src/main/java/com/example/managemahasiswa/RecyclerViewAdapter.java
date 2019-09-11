package com.example.managemahasiswa;

import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder> {
    Context context;

    List<Mahasiswa> listPersonInfo;
    public RecyclerViewAdapter(Context context, List<Mahasiswa> listPersonInfo){
        this.context = context;
        this.listPersonInfo = listPersonInfo;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_row_item, parent,false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final Mahasiswa currentPerson = listPersonInfo.get(position);
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }

    public interface OnUserClickListener{
        void onUserClick(Mahasiswa currentPerson, String action);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        public UserViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.labelMahasiswa);
        }
    }
}

