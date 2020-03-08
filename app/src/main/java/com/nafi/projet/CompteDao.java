package com.nafi.projet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mouride on 20/04/2019.
 */
public class CompteDao extends DaoBase{
    SQLiteDatabase sqLiteDatabase;
    public CompteDao(Context context) {
        super(context);
    }

    @Override
    public SQLiteDatabase ouvrir() {
        return super.ouvrir();
    }

    @Override
    public void fermer() {
        super.fermer();
    }

    @Override
    public SQLiteDatabase getDatabase() {
        return super.getDatabase();
    }
    public void ajouterCompte(Compte compte){
        sqLiteDatabase = this.ouvrir();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabase.SOLDE,compte.getSolde());
        contentValues.put(MyDatabase.LOGIN,compte.getLogin());
        contentValues.put(MyDatabase.PASSWORD,compte.getPassword());
        sqLiteDatabase.insert(MyDatabase.COMPTE,null,contentValues);
    }
    public Compte verifier(String login,String password){
        sqLiteDatabase = this.ouvrir();
        Compte compte =new Compte();
        Cursor cursor = sqLiteDatabase.query(true,MyDatabase.COMPTE,new String[]{MyDatabase.IDCOMPTE,MyDatabase.SOLDE},""+MyDatabase.LOGIN+"=? and "+MyDatabase.PASSWORD+"=?",new String[]{login,password},null,null,null,null);
        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            compte.setIdCompte(Integer.parseInt(cursor.getString(0)));
            compte.setSolde(Integer.parseInt(cursor.getString(1)));
        }
        return  compte;
    }
    public Compte recupSolde(int id){
        sqLiteDatabase = this.ouvrir();
        Compte compte =new Compte();
        Cursor cursor = sqLiteDatabase.query(true,MyDatabase.COMPTE,new String[]{MyDatabase.SOLDE},""+MyDatabase.IDCOMPTE+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            compte.setSolde(Integer.parseInt(cursor.getString(0)));
        }
        return  compte;
    }
}
