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
<<<<<<< HEAD
 * Created by UNiQUE on 9/25/2016.
 */
public class LuYeeChonProvider extends ContentProvider{

    public static final int HEALTHS = 100;
    public static final int JOKES = 200;

    private static final String sHealthTitleSelection = LuYeeChonContract.HealthEntry.COLUMN_TITLE + " = ?";
    private static final String sJokeTitleSelection = LuYeeChonContract.JokeEntry.COLUMN_TITLE + " = ?";

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private LuYeeChonDBHelper mLuYeeChonDBHelper;

    @Override
    public boolean onCreate() {
        mLuYeeChonDBHelper = new LuYeeChonDBHelper(getContext());
        return false;
=======
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class LuYeeChonProvider extends ContentProvider {


    //create integer value for each PATH
    public static final int MOTIVATOR = 100;
    //   public static final int ATTRACTION_IMAGE = 200;   //create integer for buildUriMatcher

    private static final String sAttractionTitleSelection = LuYeeChonContract.MotivatorEntry.COLUMN_TITLE + " = ?";
    //  private static final String sAttractionImageSelectionWithTitle = LuYeeChonContract.AttractionImageEntry.COLUMN_ATTRACTION_TITLE + " = ?";

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private LuYeeChonDBHelper mMotivatorDBHelper;

    @Override
    public boolean onCreate() {
        mMotivatorDBHelper = new LuYeeChonDBHelper(getContext());  //create and store db object
        return true;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
<<<<<<< HEAD
=======
        //parameter projection-> if u want return all column-> projection is null
        //                       otherwise projection has column name that want to return
        // selection -> condition eg. region name
        // selectionArgs -> ["A","UM"]  start of key
        // sortOrder -> type to sort //eg. date to sort descending order(today form old)

>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        Cursor queryCursor;

        int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {
<<<<<<< HEAD
            case HEALTHS:
                String healthTitle = LuYeeChonContract.HealthEntry.getTitleFromParam(uri);
                if (!TextUtils.isEmpty(healthTitle)) {
                    selection = sHealthTitleSelection;
                    selectionArgs = new String[]{healthTitle};
                }
                queryCursor = mLuYeeChonDBHelper.getReadableDatabase().query(LuYeeChonContract.HealthEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case JOKES:
                String jokeTitle = LuYeeChonContract.JokeEntry.getTitleFromParam(uri);
                if (!TextUtils.isEmpty(jokeTitle)) {
                    selection = sJokeTitleSelection;
                    selectionArgs = new String[]{jokeTitle};
                }
                queryCursor = mLuYeeChonDBHelper.getReadableDatabase().query(LuYeeChonContract.JokeEntry.TABLE_NAME,
=======
            case MOTIVATOR:
                // if uri's request parameter is title-> return value of these title
                String attractionTitle = LuYeeChonContract.MotivatorEntry.getTitleFromParam(uri);
                if (!TextUtils.isEmpty(attractionTitle)) {  //this check string =="" or string.length>0
                    selection = sAttractionTitleSelection;
                    selectionArgs = new String[]{attractionTitle};
                }
                queryCursor = mMotivatorDBHelper.getReadableDatabase().query(LuYeeChonContract.MotivatorEntry.TABLE_NAME,
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
<<<<<<< HEAD

=======
//            case ATTRACTION_IMAGE:
//                String title = AttractionsContract.AttractionImageEntry.getAttractionTitleFromParam(uri);
//                if (title != null) {
//                    selection = sAttractionImageSelectionWithTitle;
//                    selectionArgs = new String[]{title};
//                }
//                queryCursor = mMotivatorDBHelper.getReadableDatabase().query(AttractionsContract.AttractionImageEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
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
<<<<<<< HEAD
            case HEALTHS:
                return LuYeeChonContract.HealthEntry.DIR_TYPE;
            case JOKES:
                return LuYeeChonContract.JokeEntry.DIR_TYPE;
=======
            case MOTIVATOR:
                return LuYeeChonContract.MotivatorEntry.DIR_TYPE;
//            case ATTRACTION_IMAGE:
//                return AttractionsContract.AttractionImageEntry.DIR_TYPE;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
<<<<<<< HEAD
        final SQLiteDatabase db = mLuYeeChonDBHelper.getWritableDatabase();
=======
        final SQLiteDatabase db = mMotivatorDBHelper.getWritableDatabase();
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        final int matchUri = sUriMatcher.match(uri);
        Uri insertedUri;

        switch (matchUri) {
<<<<<<< HEAD
            case HEALTHS: {
                long _id = db.insert(LuYeeChonContract.HealthEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = LuYeeChonContract.HealthEntry.buildHealthUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case JOKES: {
                long _id = db.insert(LuYeeChonContract.JokeEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = LuYeeChonContract.JokeEntry.buildJokeUri(_id);
=======
            case MOTIVATOR: {
                long _id = db.insert(LuYeeChonContract.MotivatorEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    //create uri object for inserted data
                    insertedUri = LuYeeChonContract.MotivatorEntry.buildMotivatorUri(_id);
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
<<<<<<< HEAD
=======
//            case ATTRACTION_IMAGE: {
//                long _id = db.insert(AttractionsContract.AttractionImageEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = AttractionsContract.AttractionImageEntry.buildAttractionImageUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
<<<<<<< HEAD
            context.getContentResolver().notifyChange(uri, null);
=======
            //uri point to attraction
            context.getContentResolver().notifyChange(uri, null); //auto refresh
            //ContentResolver == ContentProvider
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        }

        return insertedUri;
    }

    @Override
<<<<<<< HEAD
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mLuYeeChonDBHelper.getWritableDatabase();
=======
    public int bulkInsert(Uri uri, ContentValues[] values) {   //uri -> place to insert uri
        final SQLiteDatabase db = mMotivatorDBHelper.getWritableDatabase();
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
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
<<<<<<< HEAD
            db.close();
=======
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }

    @Override
<<<<<<< HEAD
    public int delete(Uri uri, String s, String[] strings) {
        final SQLiteDatabase db = mLuYeeChonDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, s, strings);
=======
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mMotivatorDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, selection, selectionArgs);
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        Context context = getContext();
        if (context != null && rowDeleted > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowDeleted;
    }

    @Override
<<<<<<< HEAD
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        final SQLiteDatabase db = mLuYeeChonDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, contentValues, s, strings);
=======
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mMotivatorDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, contentValues, selection, selectionArgs);
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        Context context = getContext();
        if (context != null && rowUpdated > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }

    private static UriMatcher buildUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

<<<<<<< HEAD
        uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_HEALTHS, HEALTHS);
        uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_JOKES, JOKES);
=======
        uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_MOTIVATOR, MOTIVATOR);
    //    uriMatcher.addURI(LuYeeChonContract.CONTENT_AUTHORITY, LuYeeChonContract.PATH_ATTRACTION_IMAGES, ATTRACTION_IMAGE);
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);

        switch (matchUri) {
<<<<<<< HEAD
            case HEALTHS:
                return LuYeeChonContract.HealthEntry.TABLE_NAME;
            case JOKES:
                return LuYeeChonContract.JokeEntry.TABLE_NAME;
=======
            case MOTIVATOR:
                return LuYeeChonContract.MotivatorEntry.TABLE_NAME;
//            case ATTRACTION_IMAGE:
//                return AttractionsContract.AttractionImageEntry.TABLE_NAME;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

}
