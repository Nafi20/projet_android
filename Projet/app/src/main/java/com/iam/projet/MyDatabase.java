package com.iam.projet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mouride on 20/04/2019.
 */
public class MyDatabase extends SQLiteOpenHelper {
    public static final String NOM_BD ="banque.bg";
    public static final String COMPTE = "compte";
    public static final String IDCOMPTE = "idcompte";
    public static final String LOGIN ="login";
    public static final String SOLDE ="solde";
    public static final int VERSION =1;
    public static final String PASSWORD="password";
    public static final String CREATION="create table "+COMPTE+"("+IDCOMPTE+" integer primary key autoincrement,"+SOLDE+" text,"+LOGIN+" text,"+PASSWORD+" text)";
    public static final String SUPPRESION="drop table "+COMPTE+"";
    public MyDatabase(Context context) {
        super(context, NOM_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SUPPRESION);
       onCreate(sqLiteDatabase);

    }
}
