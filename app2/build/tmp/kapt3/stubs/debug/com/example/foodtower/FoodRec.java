package com.example.foodtower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/foodtower/FoodRec;", "Landroid/app/job/JobService;", "()V", "AppID", "", "getAppID", "()Ljava/lang/String;", "Kota", "getKota", "getFoodRec", "", "params", "Landroid/app/job/JobParameters;", "onStartJob", "", "onStopJob", "app_debug"})
public final class FoodRec extends android.app.job.JobService {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String AppID = "04feeb48145bdcd5832c07e9a2d778ac";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String Kota = "Medan";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAppID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKota() {
        return null;
    }
    
    @java.lang.Override()
    public boolean onStartJob(@org.jetbrains.annotations.Nullable()
    android.app.job.JobParameters params) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onStopJob(@org.jetbrains.annotations.Nullable()
    android.app.job.JobParameters params) {
        return false;
    }
    
    private final void getFoodRec(android.app.job.JobParameters params) {
    }
    
    public FoodRec() {
        super();
    }
}