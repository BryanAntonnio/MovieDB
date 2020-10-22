package com.uc.moviedb_0706011910022.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uc.moviedb_0706011910022.R;
import com.uc.moviedb_0706011910022.model.Cast;
import com.uc.moviedb_0706011910022.util.Constants;

import java.util.List;

public class DetailCastAdapter extends RecyclerView.Adapter<DetailCastAdapter.ViewHolder> {

    private Context context;
    private List<Cast> castData;

    public DetailCastAdapter(Context context) {
        this.context = context;
    }

    public void setCastData(List<Cast> castData) {
        this.castData = castData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cast_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cast cast = castData.get(position);
        Glide.with(context)
                .load(Constants.IMG_BASE_URL + cast.getImg_url())
                .into(holder.img_cast);
        holder.cast_name.setText(cast.getName());
        holder.cast_role.setText(cast.getRole());
    }

    @Override
    public int getItemCount() {
        return castData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_cast;
        TextView cast_name, cast_role;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_cast = itemView.findViewById(R.id.img_cast);
            cast_name = itemView.findViewById(R.id.cast_name);
            cast_role = itemView.findViewById(R.id.cast_role);
        }
    }
}