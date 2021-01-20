package com.limbo.applock;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limbo on 14-1-26.
 */
public class AppInfoManager {
    private PackageManager packageManager;

    public AppInfoManager(Context context) {
        packageManager = context.getPackageManager();
    }

    public List<AppInfo> getAppList() {
        List<AppInfo> result = new ArrayList<AppInfo>();
        AppInfo appInfo;
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (PackageInfo packageInfo : packageInfos) {
            appInfo = new AppInfo();
            appInfo.setPackageName(packageInfo.packageName);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                appInfo.setIcon(applicationInfo.loadIcon(packageManager));
                appInfo.setAppName(applicationInfo.loadLabel(packageManager).toString());
                appInfo.setIsSystemApp(isSystemApp(applicationInfo));
            }
            result.add(appInfo);
        }

        return result;
    }

    private Boolean isSystemApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0 ||
                (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0;
    }
}
