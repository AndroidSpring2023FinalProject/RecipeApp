package com.example.recipeapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/recipeapp/FridgeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/recipeapp/FridgeAdapter$ItemViewHolder;", "context", "Landroid/content/Context;", "ingredients", "", "Lcom/example/recipeapp/Ingredient;", "listener", "Lcom/example/recipeapp/OnFridgeItemClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/example/recipeapp/OnFridgeItemClickListener;)V", "getListener", "()Lcom/example/recipeapp/OnFridgeItemClickListener;", "setListener", "(Lcom/example/recipeapp/OnFridgeItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "app_debug"})
public final class FridgeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.recipeapp.FridgeAdapter.ItemViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.example.recipeapp.Ingredient> ingredients = null;
    @org.jetbrains.annotations.NotNull()
    private com.example.recipeapp.OnFridgeItemClickListener listener;
    
    public FridgeAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.recipeapp.Ingredient> ingredients, @org.jetbrains.annotations.NotNull()
    com.example.recipeapp.OnFridgeItemClickListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.recipeapp.OnFridgeItemClickListener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    com.example.recipeapp.OnFridgeItemClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.recipeapp.FridgeAdapter.ItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.recipeapp.FridgeAdapter.ItemViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/example/recipeapp/FridgeAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "iView", "Landroid/view/View;", "(Lcom/example/recipeapp/FridgeAdapter;Landroid/view/View;)V", "iIngredient", "Lcom/example/recipeapp/Ingredient;", "getIIngredient", "()Lcom/example/recipeapp/Ingredient;", "setIIngredient", "(Lcom/example/recipeapp/Ingredient;)V", "iIngredientDelete", "Landroid/widget/ImageButton;", "getIIngredientDelete", "()Landroid/widget/ImageButton;", "iIngredientName", "Landroid/widget/TextView;", "getIIngredientName", "()Landroid/widget/TextView;", "iIngredientQuantity", "getIIngredientQuantity", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private com.example.recipeapp.Ingredient iIngredient;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView iIngredientName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView iIngredientQuantity = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageButton iIngredientDelete = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View iView) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.recipeapp.Ingredient getIIngredient() {
            return null;
        }
        
        public final void setIIngredient(@org.jetbrains.annotations.Nullable()
        com.example.recipeapp.Ingredient p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getIIngredientName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getIIngredientQuantity() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageButton getIIngredientDelete() {
            return null;
        }
    }
}