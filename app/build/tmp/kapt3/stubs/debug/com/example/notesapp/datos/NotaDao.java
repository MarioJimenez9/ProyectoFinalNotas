package com.example.notesapp.datos;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\'J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\u0018"}, d2 = {"Lcom/example/notesapp/datos/NotaDao;", "", "addMedia", "", "media", "Lcom/example/notesapp/datos/Media;", "addNota", "nota", "Lcom/example/notesapp/datos/Nota;", "addRecordatorio", "recordatorio", "Lcom/example/notesapp/datos/Recordatorio;", "deleteNota", "getMedias", "", "id", "", "getNota", "getNotas", "getRecordatorios", "getTareas", "getTodos", "updateMedia", "updateNota", "app_debug"})
public abstract interface NotaDao {
    
    @androidx.room.Insert()
    public abstract void addMedia(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.datos.Media media);
    
    @androidx.room.Update()
    public abstract void updateMedia(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.datos.Media media);
    
    @androidx.room.Insert()
    public abstract void addNota(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.datos.Nota nota);
    
    @androidx.room.Insert()
    public abstract void addRecordatorio(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.datos.Recordatorio recordatorio);
    
    @androidx.room.Update()
    public abstract void updateNota(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.datos.Nota nota);
    
    @androidx.room.Delete()
    public abstract void deleteNota(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.datos.Nota nota);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM note_table ORDER BY id ASC")
    public abstract java.util.List<com.example.notesapp.datos.Nota> getTodos();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM note_table where esTarea = 0 ORDER BY id ASC")
    public abstract java.util.List<com.example.notesapp.datos.Nota> getNotas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM note_table where esTarea = 1 ORDER BY id ASC")
    public abstract java.util.List<com.example.notesapp.datos.Nota> getTareas();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM note_table where id = :id")
    public abstract com.example.notesapp.datos.Nota getNota(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM media_table where idNota = :id")
    public abstract java.util.List<com.example.notesapp.datos.Media> getMedias(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM recordatorio_table where idNota = :id")
    public abstract java.util.List<com.example.notesapp.datos.Recordatorio> getRecordatorios(long id);
}