package com.example.foodtower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nJ\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\nJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/example/foodtower/sqlite_DBhelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addUser", "", "sqliteUser", "Lcom/example/foodtower/sqlite_user;", "addusertrans", "", "sqliteuser", "begintrans", "deleteAll", "deleteUser", "nama", "", "endusertrans", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "", "p2", "successtrans", "viewAllName", "", "Companion", "app_debug"})
public final class sqlite_DBhelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String DATABASE_NAME = "SQLitedb.db";
    private static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.foodtower.sqlite_DBhelper.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int p1, int p2) {
    }
    
    public final long addUser(@org.jetbrains.annotations.NotNull()
    com.example.foodtower.sqlite_user sqliteUser) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> viewAllName() {
        return null;
    }
    
    public final void deleteUser(@org.jetbrains.annotations.NotNull()
    java.lang.String nama) {
    }
    
    public final void deleteAll() {
    }
    
    public final void begintrans() {
    }
    
    public final void successtrans() {
    }
    
    public final void endusertrans() {
    }
    
    public final void addusertrans(@org.jetbrains.annotations.NotNull()
    com.example.foodtower.sqlite_user sqliteuser) {
    }
    
    public sqlite_DBhelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/foodtower/sqlite_DBhelper$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}