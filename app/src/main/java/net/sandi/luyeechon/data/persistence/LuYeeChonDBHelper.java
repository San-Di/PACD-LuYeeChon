package net.sandi.luyeechon.data.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.sandi.luyeechon.data.persistence.LuYeeChonContract.HealthEntry;
import net.sandi.luyeechon.data.persistence.LuYeeChonContract.JokeEntry;

/**
 * Created by UNiQUE on 9/25/2016.
 */
public class LuYeeChonDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "luYeeChon.db";

    private static final String SQL_CREATE_HEALTH_TABLE = "CREATE TABLE " + HealthEntry.TABLE_NAME + " (" +
            HealthEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            HealthEntry.COLUMN_TITLE + " TEXT NOT NULL, "+
            HealthEntry.COLUMN_PHOTO + " TEXT NOT NULL, "+
            HealthEntry.COLUMN_DESC + " TEXT NOT NULL, "+

            " UNIQUE (" + HealthEntry.COLUMN_TITLE + ") ON CONFLICT IGNORE" +
            " );";

    private static final String SQL_CREATE_JOKE_TABLE = "CREATE TABLE " + JokeEntry.TABLE_NAME + " (" +
            JokeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            JokeEntry.COLUMN_TITLE + " TEXT NOT NULL, "+
            JokeEntry.COLUMN_PHOTO + " TEXT NOT NULL, "+
            JokeEntry.COLUMN_DESC + " TEXT NOT NULL, "+

            " UNIQUE (" + JokeEntry.COLUMN_TITLE + ") ON CONFLICT IGNORE" +
            " );";


    public LuYeeChonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_HEALTH_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_JOKE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HealthEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + JokeEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

}
