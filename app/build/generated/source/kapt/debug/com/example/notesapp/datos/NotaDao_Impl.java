package com.example.notesapp.datos;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotaDao_Impl implements NotaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Media> __insertionAdapterOfMedia;

  private final EntityInsertionAdapter<Nota> __insertionAdapterOfNota;

  private final EntityInsertionAdapter<Recordatorio> __insertionAdapterOfRecordatorio;

  private final EntityDeletionOrUpdateAdapter<Nota> __deletionAdapterOfNota;

  private final EntityDeletionOrUpdateAdapter<Media> __updateAdapterOfMedia;

  private final EntityDeletionOrUpdateAdapter<Nota> __updateAdapterOfNota;

  public NotaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMedia = new EntityInsertionAdapter<Media>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `media_table` (`id`,`idNota`,`url`,`descripcion`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Media value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdNota());
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        if (value.getDescripcion() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescripcion());
        }
      }
    };
    this.__insertionAdapterOfNota = new EntityInsertionAdapter<Nota>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `note_table` (`id`,`titulo`,`descripcion`,`esTarea`,`fechaLimite`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Nota value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitulo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitulo());
        }
        if (value.getDescripcion() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescripcion());
        }
        final int _tmp;
        _tmp = value.getEsTarea() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getFechaLimite() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFechaLimite());
        }
      }
    };
    this.__insertionAdapterOfRecordatorio = new EntityInsertionAdapter<Recordatorio>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `recordatorio_table` (`id`,`idNota`,`Fecha`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Recordatorio value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdNota());
        if (value.getFecha() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFecha());
        }
      }
    };
    this.__deletionAdapterOfNota = new EntityDeletionOrUpdateAdapter<Nota>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `note_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Nota value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfMedia = new EntityDeletionOrUpdateAdapter<Media>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `media_table` SET `id` = ?,`idNota` = ?,`url` = ?,`descripcion` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Media value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdNota());
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        if (value.getDescripcion() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescripcion());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__updateAdapterOfNota = new EntityDeletionOrUpdateAdapter<Nota>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `note_table` SET `id` = ?,`titulo` = ?,`descripcion` = ?,`esTarea` = ?,`fechaLimite` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Nota value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitulo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitulo());
        }
        if (value.getDescripcion() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescripcion());
        }
        final int _tmp;
        _tmp = value.getEsTarea() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getFechaLimite() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFechaLimite());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void addMedia(final Media media) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMedia.insert(media);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addNota(final Nota nota) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNota.insert(nota);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addRecordatorio(final Recordatorio recordatorio) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRecordatorio.insert(recordatorio);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteNota(final Nota nota) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNota.handle(nota);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMedia(final Media media) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMedia.handle(media);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateNota(final Nota nota) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNota.handle(nota);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Nota> getTodos() {
    final String _sql = "SELECT * FROM note_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfEsTarea = CursorUtil.getColumnIndexOrThrow(_cursor, "esTarea");
      final int _cursorIndexOfFechaLimite = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaLimite");
      final List<Nota> _result = new ArrayList<Nota>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Nota _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final boolean _tmpEsTarea;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEsTarea);
        _tmpEsTarea = _tmp != 0;
        final String _tmpFechaLimite;
        if (_cursor.isNull(_cursorIndexOfFechaLimite)) {
          _tmpFechaLimite = null;
        } else {
          _tmpFechaLimite = _cursor.getString(_cursorIndexOfFechaLimite);
        }
        _item = new Nota(_tmpId,_tmpTitulo,_tmpDescripcion,_tmpEsTarea,_tmpFechaLimite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Nota> getNotas() {
    final String _sql = "SELECT * FROM note_table where esTarea = 0 ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfEsTarea = CursorUtil.getColumnIndexOrThrow(_cursor, "esTarea");
      final int _cursorIndexOfFechaLimite = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaLimite");
      final List<Nota> _result = new ArrayList<Nota>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Nota _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final boolean _tmpEsTarea;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEsTarea);
        _tmpEsTarea = _tmp != 0;
        final String _tmpFechaLimite;
        if (_cursor.isNull(_cursorIndexOfFechaLimite)) {
          _tmpFechaLimite = null;
        } else {
          _tmpFechaLimite = _cursor.getString(_cursorIndexOfFechaLimite);
        }
        _item = new Nota(_tmpId,_tmpTitulo,_tmpDescripcion,_tmpEsTarea,_tmpFechaLimite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Nota> getTareas() {
    final String _sql = "SELECT * FROM note_table where esTarea = 1 ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfEsTarea = CursorUtil.getColumnIndexOrThrow(_cursor, "esTarea");
      final int _cursorIndexOfFechaLimite = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaLimite");
      final List<Nota> _result = new ArrayList<Nota>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Nota _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final boolean _tmpEsTarea;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEsTarea);
        _tmpEsTarea = _tmp != 0;
        final String _tmpFechaLimite;
        if (_cursor.isNull(_cursorIndexOfFechaLimite)) {
          _tmpFechaLimite = null;
        } else {
          _tmpFechaLimite = _cursor.getString(_cursorIndexOfFechaLimite);
        }
        _item = new Nota(_tmpId,_tmpTitulo,_tmpDescripcion,_tmpEsTarea,_tmpFechaLimite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Nota getNota(final long id) {
    final String _sql = "SELECT * FROM note_table where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfEsTarea = CursorUtil.getColumnIndexOrThrow(_cursor, "esTarea");
      final int _cursorIndexOfFechaLimite = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaLimite");
      final Nota _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final boolean _tmpEsTarea;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEsTarea);
        _tmpEsTarea = _tmp != 0;
        final String _tmpFechaLimite;
        if (_cursor.isNull(_cursorIndexOfFechaLimite)) {
          _tmpFechaLimite = null;
        } else {
          _tmpFechaLimite = _cursor.getString(_cursorIndexOfFechaLimite);
        }
        _result = new Nota(_tmpId,_tmpTitulo,_tmpDescripcion,_tmpEsTarea,_tmpFechaLimite);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Media> getMedias(final long id) {
    final String _sql = "SELECT * FROM media_table where idNota = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdNota = CursorUtil.getColumnIndexOrThrow(_cursor, "idNota");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final List<Media> _result = new ArrayList<Media>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Media _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpIdNota;
        _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        final String _tmpUrl;
        if (_cursor.isNull(_cursorIndexOfUrl)) {
          _tmpUrl = null;
        } else {
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        }
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        _item = new Media(_tmpId,_tmpIdNota,_tmpUrl,_tmpDescripcion);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Recordatorio> getRecordatorios(final long id) {
    final String _sql = "SELECT * FROM recordatorio_table where idNota = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdNota = CursorUtil.getColumnIndexOrThrow(_cursor, "idNota");
      final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "Fecha");
      final List<Recordatorio> _result = new ArrayList<Recordatorio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Recordatorio _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpIdNota;
        _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        final String _tmpFecha;
        if (_cursor.isNull(_cursorIndexOfFecha)) {
          _tmpFecha = null;
        } else {
          _tmpFecha = _cursor.getString(_cursorIndexOfFecha);
        }
        _item = new Recordatorio(_tmpId,_tmpIdNota,_tmpFecha);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
