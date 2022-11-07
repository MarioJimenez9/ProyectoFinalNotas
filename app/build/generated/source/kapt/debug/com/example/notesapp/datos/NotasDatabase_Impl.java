package com.example.notesapp.datos;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotasDatabase_Impl extends NotasDatabase {
  private volatile NotaDao _notaDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `note_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `titulo` TEXT NOT NULL, `descripcion` TEXT NOT NULL, `esTarea` INTEGER NOT NULL, `fechaLimite` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `media_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idNota` INTEGER NOT NULL, `url` TEXT NOT NULL, `descripcion` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `recordatorio_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idNota` INTEGER NOT NULL, `Fecha` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '52dc77d545139635368e318a0c52775a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `note_table`");
        _db.execSQL("DROP TABLE IF EXISTS `media_table`");
        _db.execSQL("DROP TABLE IF EXISTS `recordatorio_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsNoteTable = new HashMap<String, TableInfo.Column>(5);
        _columnsNoteTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("titulo", new TableInfo.Column("titulo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("descripcion", new TableInfo.Column("descripcion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("esTarea", new TableInfo.Column("esTarea", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTable.put("fechaLimite", new TableInfo.Column("fechaLimite", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNoteTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNoteTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNoteTable = new TableInfo("note_table", _columnsNoteTable, _foreignKeysNoteTable, _indicesNoteTable);
        final TableInfo _existingNoteTable = TableInfo.read(_db, "note_table");
        if (! _infoNoteTable.equals(_existingNoteTable)) {
          return new RoomOpenHelper.ValidationResult(false, "note_table(com.example.notesapp.datos.Nota).\n"
                  + " Expected:\n" + _infoNoteTable + "\n"
                  + " Found:\n" + _existingNoteTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMediaTable = new HashMap<String, TableInfo.Column>(4);
        _columnsMediaTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaTable.put("idNota", new TableInfo.Column("idNota", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaTable.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMediaTable.put("descripcion", new TableInfo.Column("descripcion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMediaTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMediaTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMediaTable = new TableInfo("media_table", _columnsMediaTable, _foreignKeysMediaTable, _indicesMediaTable);
        final TableInfo _existingMediaTable = TableInfo.read(_db, "media_table");
        if (! _infoMediaTable.equals(_existingMediaTable)) {
          return new RoomOpenHelper.ValidationResult(false, "media_table(com.example.notesapp.datos.Media).\n"
                  + " Expected:\n" + _infoMediaTable + "\n"
                  + " Found:\n" + _existingMediaTable);
        }
        final HashMap<String, TableInfo.Column> _columnsRecordatorioTable = new HashMap<String, TableInfo.Column>(3);
        _columnsRecordatorioTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecordatorioTable.put("idNota", new TableInfo.Column("idNota", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecordatorioTable.put("Fecha", new TableInfo.Column("Fecha", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRecordatorioTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRecordatorioTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecordatorioTable = new TableInfo("recordatorio_table", _columnsRecordatorioTable, _foreignKeysRecordatorioTable, _indicesRecordatorioTable);
        final TableInfo _existingRecordatorioTable = TableInfo.read(_db, "recordatorio_table");
        if (! _infoRecordatorioTable.equals(_existingRecordatorioTable)) {
          return new RoomOpenHelper.ValidationResult(false, "recordatorio_table(com.example.notesapp.datos.Recordatorio).\n"
                  + " Expected:\n" + _infoRecordatorioTable + "\n"
                  + " Found:\n" + _existingRecordatorioTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "52dc77d545139635368e318a0c52775a", "a80f3a3851627cda6dc5e890bc72f666");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "note_table","media_table","recordatorio_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `note_table`");
      _db.execSQL("DELETE FROM `media_table`");
      _db.execSQL("DELETE FROM `recordatorio_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(NotaDao.class, NotaDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public NotaDao notaDao() {
    if (_notaDao != null) {
      return _notaDao;
    } else {
      synchronized(this) {
        if(_notaDao == null) {
          _notaDao = new NotaDao_Impl(this);
        }
        return _notaDao;
      }
    }
  }
}
