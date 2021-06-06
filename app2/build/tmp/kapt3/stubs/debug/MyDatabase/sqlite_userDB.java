package MyDatabase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"LMyDatabase/sqlite_userDB;", "", "()V", "userTable", "app_debug"})
public final class sqlite_userDB {
    @org.jetbrains.annotations.NotNull()
    public static final MyDatabase.sqlite_userDB INSTANCE = null;
    
    private sqlite_userDB() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"LMyDatabase/sqlite_userDB$userTable;", "Landroid/provider/BaseColumns;", "()V", "Companion", "app_debug"})
    public static final class userTable implements android.provider.BaseColumns {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String USER_TABLE = "user_table";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_ID = "user_id";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_NAME = "user_name";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_HP = "user_hp";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_LOCATION = "user_location";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_REKENING = "user_rekening";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_PRICE = "user_price";
        @org.jetbrains.annotations.NotNull()
        public static final MyDatabase.sqlite_userDB.userTable.Companion Companion = null;
        
        public userTable() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"LMyDatabase/sqlite_userDB$userTable$Companion;", "", "()V", "COLUMN_HP", "", "getCOLUMN_HP", "()Ljava/lang/String;", "COLUMN_ID", "getCOLUMN_ID", "COLUMN_LOCATION", "getCOLUMN_LOCATION", "COLUMN_NAME", "getCOLUMN_NAME", "COLUMN_PRICE", "getCOLUMN_PRICE", "COLUMN_REKENING", "getCOLUMN_REKENING", "USER_TABLE", "getUSER_TABLE", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getUSER_TABLE() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_ID() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_NAME() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_HP() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_LOCATION() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_REKENING() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_PRICE() {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
}