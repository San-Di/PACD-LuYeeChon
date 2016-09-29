package net.sandi.luyeechon.data.persistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class LuYeeChonProvider extends ContentProvider {


    //create integer value for each PATH
    public static final int MOTIVATOR = 100;
    public static final int QUIZ=200;
    //   public static final int ATTRACTION_IMAGE = 200;   //create integer for buildUriMatcher

    private static final String sMotivatorTitleSelection = LuYeeChonContract.MotivatorEntry.COLUMN_TITLE + " = ?";
    private static final String sQuizTitleSelection = LuYeeChonContract.QuizEntry.COLUMN_TITLE + " = ?";
    //  private static final String sAttractionImageSelectionWithTitle = LuYeeChonContract.AttractionImageEntry.COLUMN_ATTRACTION_TITLE + " = ?";

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private LuYeeChonDBHelper mLuyechonDBHelper;

    @Override
    public boolean onCreate() {
        mLuyechonDBHelper = new LuYeeChonDBHelper(getContext());  //create and store db object
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        //parameter projection-> if u want return all column-> projection is null
        //                       otherwise projection has column name that want to return
        // selection -> condition eg. region name
        // selectionArgs -> ["A","UM"]  start of key
        // sortOrder -> type to sort //eg. date to sort descending order(today form old)

        Cursor queryCursor;

        int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {
            case MOTIVATOR:
                // if uri's request parameter is title-> return value of these title
                String motivatorTitle = LuYeeChonContract.MotivatorEntry.getTitleFromParam(uri);
                if (!TextUtils.isEmpty(motivatorTitle)) {  //this check string =="" or string.length>0
                    selection = sMotivatorTitleSelection;
                    selectionArgs = new String[]{motivatorTitle};
                }
                queryCursor = mLuyechonDBHelper.getReadableDatabase().query(LuYeeChonContract.MotivatorEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case QUIZ:
                // if uri's request parameter is title-> return value of these title
                String quizTitle = LuYeeChonContract.QuizEntry.getTitleFromParam(uri);
                if (!TextUtils.isEmpty(quizTitle)) {  //this check string =="" or string.length>0
                    selection = sQuizTitleSelection;
                    selectionArgs = new String[]{quizTitle};
                }
                queryCursor = mLuyechonDBHelper.getReadableDatabase().query(LuYeeChonContract.QuizEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
//            case ATTRACTION_IMAGE:
//                String title = AttractionsContract.AttractionImageEntry.getAttractionTitleFromParam(uri);
//                if (title != null) {
//                    selection = sAttractionImageSelectionWithTitle;
//                    selectionArgs = new String[]{title};
//                }
//                queryCursor = mLuyechonDBHelper.getReadableDatabase().query(AttractionsContract.AttractionImageEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
            queryCursor.setNotificationUri(context.getContentResolver(), uri);
        }

        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {
            case MOTIVATOR:
                return LuYeeChonContract.MotivatorEntry.DIR_TYPE;
            case QUIZ:
                return LuYeeChonContract.QuizEntry.DIR_TYPE;
//            case ATTRACTION_IMAGE:
//                return AttractionsContract.AttractionImageEntry.DIR_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final SQLiteDatabase db = mLuyechonDBHelper.getWritableDatabase();
        final int matchUri = sUriMatcher.match(uri);
        Uri insertedUri;

        switch (matchUri) {
            case MOTIVATOR: {
                long _id = db.insert(LuYeeChonContract.MotivatorEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    //create uri object for inserted data
                    insertedUri = LuYeeChonContract.MotivatorEntry.buildMotivatorUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case QUIZ: {
                long _id = db.insert(LuYeeChonContract.QuizEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    //create uri object for inserted data
                    insertedUri = LuYeeChonContract.QuizEntry.builQuizUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
//            case ATTRACTION_IMAGE: {
//                long _id = db.insert(AttractionsContract.AttractionImageEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = AttractionsContract.AttractionImageEntry.buildAttractionImageUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
            //uri point to attraction
            context.getContentResolver().notifyChange(uri, null); //auto refresh
            //ContentResolver == ContentProvider
        }

        return insertedUri;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {   //uri -> place to insert uri
        final SQLiteDatabase db = mLuyechonDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mLuyechonDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowDeleted > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mLuyechonDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, contentValues, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowUpdated > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }

    private static UriMatcher buildUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_MOTIVATOR, MOTIVATOR);
        uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_QUIZ, QUIZ);
    //    uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_ATTRACTION_IMAGES, ATTRACTION_IMAGE);

        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);

        switch (matchUri) {
            case MOTIVATOR:
                return LuYeeChonContract.MotivatorEntry.TABLE_NAME;
            case QUIZ:
                return LuYeeChonContract.QuizEntry.TABLE_NAME;
//            case ATTRACTION_IMAGE:
//                return AttractionsContract.AttractionImageEntry.TABLE_NAME;

            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

}
