package com.example.foodtower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u0012\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020.H\u0014J\b\u00107\u001a\u00020.H\u0014J\b\u00108\u001a\u00020.H\u0014J\u0010\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u000e\u0010,\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/example/foodtower/subscribepage;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/foodtower/interfaceSubs;", "Landroid/view/View$OnClickListener;", "()V", "DisplayName", "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "builder", "Landroid/app/Notification$Builder;", "getBuilder", "()Landroid/app/Notification$Builder;", "setBuilder", "(Landroid/app/Notification$Builder;)V", "channelID", "description", "listContact", "", "Lcom/example/foodtower/Subs;", "getListContact", "()Ljava/util/List;", "setListContact", "(Ljava/util/List;)V", "noTelp", "getNoTelp", "setNoTelp", "notificationChannel", "Landroid/app/NotificationChannel;", "getNotificationChannel", "()Landroid/app/NotificationChannel;", "setNotificationChannel", "(Landroid/app/NotificationChannel;)V", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "setNotificationManager", "(Landroid/app/NotificationManager;)V", "stats", "getStats", "setStats", "subsPrefFileName", "createNewSoundPool", "", "createOldSoundPool", "onClick", "p0", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "onStop", "tampilharga", "String", "Lcom/example/foodtower/dataSubs;", "app_debug"})
public final class subscribepage extends androidx.appcompat.app.AppCompatActivity implements com.example.foodtower.interfaceSubs, android.view.View.OnClickListener {
    private final java.lang.String subsPrefFileName = "MySubsPref";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String DisplayName = "display_name";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String noTelp = "data1";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String stats = "android.provider.extra.ADDRESS_BOOK_INDEX";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.foodtower.Subs> listContact;
    public android.app.NotificationManager notificationManager;
    public android.app.NotificationChannel notificationChannel;
    public android.app.Notification.Builder builder;
    private final java.lang.String channelID = "com.example.vicky.notificationexample";
    private final java.lang.String description = "Test Notification";
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    public final void setDisplayName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNoTelp() {
        return null;
    }
    
    public final void setNoTelp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStats() {
        return null;
    }
    
    public final void setStats(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.foodtower.Subs> getListContact() {
        return null;
    }
    
    public final void setListContact(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.foodtower.Subs> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.NotificationManager getNotificationManager() {
        return null;
    }
    
    public final void setNotificationManager(@org.jetbrains.annotations.NotNull()
    android.app.NotificationManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.NotificationChannel getNotificationChannel() {
        return null;
    }
    
    public final void setNotificationChannel(@org.jetbrains.annotations.NotNull()
    android.app.NotificationChannel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Notification.Builder getBuilder() {
        return null;
    }
    
    public final void setBuilder(@org.jetbrains.annotations.NotNull()
    android.app.Notification.Builder p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void tampilharga(@org.jetbrains.annotations.NotNull()
    com.example.foodtower.dataSubs String) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void createOldSoundPool() {
    }
    
    private final void createNewSoundPool() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    public subscribepage() {
        super();
    }
}