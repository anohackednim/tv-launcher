package com.yahya.launcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    private Context context;
    private List<AppInfo> appList;
    private OnAppClickListener listener;

    public interface OnAppClickListener {
        void onAppClick(AppInfo app);
    }

    public AppAdapter(Context context, List<AppInfo> appList, OnAppClickListener listener) {
        this.context = context;
        this.appList = appList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.app_item, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        AppInfo app = appList.get(position);
        holder.appName.setText(app.getName());
        Glide.with(context)
                .load(app.getIcon())
                .into(holder.appIcon);
        
        holder.itemView.setOnClickListener(v -> listener.onAppClick(app));
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        ImageView appIcon;
        TextView appName;

        AppViewHolder(@NonNull View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.appIcon);
            appName = itemView.findViewById(R.id.appName);
        }
    }
}