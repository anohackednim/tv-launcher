package com.yahya.launcher;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        packageManager = getPackageManager();

        // Grid layout for TV (5 columns)
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Load apps
        loadApps();
    }

    private void loadApps() {
        new Thread(() -> {
            List<AppInfo> appsList = new ArrayList<>();
            List<ApplicationInfo> packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

            for (ApplicationInfo app : packages) {
                // Exclude system apps
                if ((app.flags & ApplicationInfo.FLAG_SYSTEM) == 0 || (app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                    AppInfo appInfo = new AppInfo();
                    appInfo.setName(app.loadLabel(packageManager).toString());
                    appInfo.setPackageName(app.packageName);
                    appInfo.setIcon(app.loadIcon(packageManager));
                    appsList.add(appInfo);
                }
            }

            Collections.sort(appsList, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

            runOnUiThread(() -> {
                adapter = new AppAdapter(MainActivity.this, appsList, app -> {
                    Intent intent = packageManager.getLaunchIntentForPackage(app.getPackageName());
                    if (intent != null) {
                        startActivity(intent);
                    }
                });
                recyclerView.setAdapter(adapter);
            });
        }).start();
    }
}