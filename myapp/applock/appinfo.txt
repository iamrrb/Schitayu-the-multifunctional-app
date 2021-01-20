package com.limbo.applock;

import android.graphics.drawable.Drawable;

/**
 * Created by Limbo on 14-1-26.
 */
public class AppInfo {
    private String appName;
    private String appId;
    private Drawable icon;
    private String packageName;
    private Boolean isSystemApp;

    public Boolean getIsSystemApp() {
        return isSystemApp;
    }

    public void setIsSystemApp(Boolean isSystemApp) {
        this.isSystemApp = isSystemApp;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
