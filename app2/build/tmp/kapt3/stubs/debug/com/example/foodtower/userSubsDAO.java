package com.example.foodtower;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J!\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\'\u00a2\u0006\u0002\u0010\nJ0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\'J\b\u0010\u0012\u001a\u00020\u0003H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/foodtower/userSubsDAO;", "", "DeleteDataSubs", "", "nama", "", "InsertDataSubs", "user", "", "Lcom/example/foodtower/userSubs;", "([Lcom/example/foodtower/userSubs;)V", "UpdateDataSubs", "NoHP", "lokasi", "harga", "bank", "getAllDataSubs", "", "nukeTable", "app_debug"})
public abstract interface userSubsDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from userSubs")
    public abstract java.util.List<com.example.foodtower.userSubs> getAllDataSubs();
    
    @androidx.room.Insert()
    public abstract void InsertDataSubs(@org.jetbrains.annotations.NotNull()
    com.example.foodtower.userSubs... user);
    
    @androidx.room.Query(value = "Update userSubs set COLUMN_NAME = :nama, COLUMN_PHONENUMBER = :NoHP, COLUMN_LOCATION = :lokasi, COLUMN_PRICE = :harga  where COLUMN_BANKACCNUMBER = :bank")
    public abstract void UpdateDataSubs(@org.jetbrains.annotations.NotNull()
    java.lang.String nama, @org.jetbrains.annotations.NotNull()
    java.lang.String NoHP, @org.jetbrains.annotations.NotNull()
    java.lang.String lokasi, @org.jetbrains.annotations.NotNull()
    java.lang.String harga, @org.jetbrains.annotations.NotNull()
    java.lang.String bank);
    
    @androidx.room.Query(value = "Delete from userSubs where COLUMN_NAME = :nama")
    public abstract void DeleteDataSubs(@org.jetbrains.annotations.NotNull()
    java.lang.String nama);
    
    @androidx.room.Query(value = "Delete from userSubs")
    public abstract void nukeTable();
}