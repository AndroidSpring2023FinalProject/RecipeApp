package com.example.recipeapp;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FridgeDao_Impl implements FridgeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Ingredient> __insertionAdapterOfIngredient;

  private final EntityDeletionOrUpdateAdapter<Ingredient> __deletionAdapterOfIngredient;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FridgeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIngredient = new EntityInsertionAdapter<Ingredient>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ingredients_table` (`id`,`ingredientName`,`ingredientQuantity`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ingredient value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getQuantity());
        }
      }
    };
    this.__deletionAdapterOfIngredient = new EntityDeletionOrUpdateAdapter<Ingredient>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ingredients_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ingredient value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ingredients_table";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<Ingredient> ingredients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIngredient.insert(ingredients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Ingredient ingredient) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIngredient.insert(ingredient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Ingredient ingredient) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIngredient.handle(ingredient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Flow<List<Ingredient>> getAll() {
    final String _sql = "SELECT * FROM ingredients_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"ingredients_table"}, new Callable<List<Ingredient>>() {
      @Override
      public List<Ingredient> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredientName");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredientQuantity");
          final List<Ingredient> _result = new ArrayList<Ingredient>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Ingredient _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            _item = new Ingredient(_tmpId,_tmpName,_tmpQuantity);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
