package com.example.notesapp.datos;

import java.lang.System;

@androidx.room.Database(entities = {com.example.notesapp.datos.Nota.class, com.example.notesapp.datos.Media.class, com.example.notesapp.datos.Recordatorio.class}, version = 3, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/notesapp/datos/NotasDatabase;", "Landroidx/room/RoomDatabase;", "()V", "notaDao", "Lcom/example/notesapp/datos/NotaDao;", "Companion", "app_debug"})
public abstract class NotasDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.notesapp.datos.NotasDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.example.notesapp.datos.NotasDatabase INSTANCE;
    
    public NotasDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.notesapp.datos.NotaDao notaDao();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/notesapp/datos/NotasDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/notesapp/datos/NotasDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.notesapp.datos.NotasDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}