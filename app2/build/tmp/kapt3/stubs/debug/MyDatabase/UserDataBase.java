package MyDatabase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"LMyDatabase/UserDataBase;", "", "()V", "UserTable", "app_debug"})
public final class UserDataBase {
    @org.jetbrains.annotations.NotNull()
    public static final MyDatabase.UserDataBase INSTANCE = null;
    
    private UserDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"LMyDatabase/UserDataBase$UserTable;", "Landroid/provider/BaseColumns;", "()V", "Companion", "app_debug"})
    public static final class UserTable implements android.provider.BaseColumns {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String USER_TABLE = "Table_User";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_ID = "User_ID";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_Name = "User_Name";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_HP = "User_HP";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_Address = "User_Address";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_City = "User_City";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String COLUMN_District = "User_District";
        @org.jetbrains.annotations.NotNull()
        public static final MyDatabase.UserDataBase.UserTable.Companion Companion = null;
        
        public UserTable() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"LMyDatabase/UserDataBase$UserTable$Companion;", "", "()V", "COLUMN_Address", "", "getCOLUMN_Address", "()Ljava/lang/String;", "COLUMN_City", "getCOLUMN_City", "COLUMN_District", "getCOLUMN_District", "COLUMN_HP", "getCOLUMN_HP", "COLUMN_ID", "getCOLUMN_ID", "COLUMN_Name", "getCOLUMN_Name", "USER_TABLE", "getUSER_TABLE", "app_debug"})
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
            public final java.lang.String getCOLUMN_Name() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_HP() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_Address() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_City() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getCOLUMN_District() {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
}