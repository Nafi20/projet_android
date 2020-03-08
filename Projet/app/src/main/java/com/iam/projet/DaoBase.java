package com.iam.projet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mouride on 20/04/2019.
 */
public class DaoBase {
    SQLiteDatabase sqLiteDatabase;
    MyDatabase myDatabase;

    public DaoBase(Context context) {
        this.myDatabase = new MyDatabase(context);
    }
    public SQLiteDatabase ouvrir(){
        sqLiteDatabase = this.myDatabase.getWritableDatabase();
        return sqLiteDatabase;

    }
    public void fermer(){
        sqLiteDatabase.close();
    }
    public SQLiteDatabase getDatabase(){
        return sqLiteDatabase;
    }
}
