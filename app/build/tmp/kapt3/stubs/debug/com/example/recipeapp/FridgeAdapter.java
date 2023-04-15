package com.example.recipeapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/recipeapp/FridgeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/recipeapp/FridgeAdapter$ItemViewHolder;", "context", "Landroid/content/Context;", "ingredients", "", "Lcom/example/recipeapp/Ingredient;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "app_debug"})
public final class FridgeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.recipeapp.FridgeAdapter.ItemViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.example.recipeapp.Ingredient> ingredients = null;
    
    public FridgeAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.recipeapp.Ingredient> ingredients) {
        super();
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/example/recipeapp/FridgeAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "iView", "Landroid/view/View;", "(Lcom/example/recipeapp/FridgeAdapter;Landroid/view/View;)V", "iIngredient", "Lcom/example/recipeapp/Ingredient;", "getIIngredient", "()Lcom/example/recipeapp/Ingredient;", "setIIngredient", "(Lcom/example/recipeapp/Ingredient;)V", "iIngredientDelete", "Landroid/widget/ImageButton;", "getIIngredientDelete", "()Landroid/widget/ImageButton;", "iIngredientName", "Landroid/widget/TextView;", "getIIngredientName", "()Landroid/widget/TextView;", "iIngredientQuantity", "getIIngredientQuantity", "onClick", "", "v", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
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
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
    }
}