package net.sandi.luyeechon.data.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.sandi.luyeechon.data.persistence.LuYeeChonContract.MotivatorEntry;
/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class LuYeeChonDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "luyeechon.db";

    private static final String SQL_CREATE_MOTIVATOR_TABLE = "CREATE TABLE " + MotivatorEntry.TABLE_NAME + " (" +
            MotivatorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MotivatorEntry.COLUMN_TITLE + " TEXT NOT NULL, "+

            " UNIQUE (" + MotivatorEntry.COLUMN_TITLE + ") ON CONFLICT IGNORE" +  // can't duplicate
            " );";  //sql command


    public LuYeeChonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_MOTIVATOR_TABLE);
    //    sqLiteDatabase.execSQL(SQL_CREATE_ATTRACTION_IMAGE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     //   sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AttractionImageEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MotivatorEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);

    }
}
