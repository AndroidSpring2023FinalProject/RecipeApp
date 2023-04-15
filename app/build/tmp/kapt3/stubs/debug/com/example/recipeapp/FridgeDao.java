package com.example.recipeapp;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/recipeapp/FridgeDao;", "", "delete", "", "ingredient", "Lcom/example/recipeapp/Ingredient;", "deleteAll", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "insert", "insertAll", "ingredients", "app_debug"})
public abstract interface FridgeDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ingredients_table")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.recipeapp.Ingredient>> getAll();
    
    @androidx.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.recipeapp.Ingredient> ingredients);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.recipeapp.Ingredient ingredient);
    
    @androidx.room.Query(value = "DELETE FROM ingredients_table")
    public abstract void deleteAll();
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.recipeapp.Ingredient ingredient);
}