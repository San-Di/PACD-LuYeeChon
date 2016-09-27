package net.sandi.luyeechon.data.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import net.sandi.luyeechon.LuYeeChonApp;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class LuYeeChonContract {

    //output -> xyz.aungpyaephyo.padc.myanmarattractions
    public static final String CONTENT_AUTHORITY = LuYeeChonApp.class.getPackage().getName();
    //uri -> unique resource ithority  // 'content://' <- protocol for persistence layer
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);  //creating base content uri

    public static final String PATH_MOTIVATOR = "motivator";   //like table name
  //  public static final String PATH_ATTRACTION_IMAGES = "attraction_images";

    public static final class MotivatorEntry implements BaseColumns {  // Entry object for each path
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOTIVATOR).build();

        public static final String DIR_TYPE =  //dir -> directory .. if return is more than one, return with DIR_TYPE
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOTIVATOR;

        public static final String ITEM_TYPE =  //if return is more than one, return with ITEM_TYPE
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOTIVATOR;

        //create upper 3 variable in every entry


        public static final String TABLE_NAME = "motivator";

        public static final String COLUMN_TITLE = "image_url";
  //      public static final String COLUMN_DESC = "desc";

        public static Uri buildMotivatorUri(long id) {    // create it in every entry
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

//        public static Uri buildMotivatorUriWithTitle(String attractionTitle) {  //creating uri using table name
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_TITLE, attractionTitle)
//                    .build();
//        }

        public static String getTitleFromParam(Uri uri) {   //retrieve title form uri
            return uri.getQueryParameter(COLUMN_TITLE);
        }
    }

//    public static final class AttractionImageEntry implements BaseColumns {
//        public static final Uri CONTENT_URI =
//                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ATTRACTION_IMAGES).build();
//
//        public static final String DIR_TYPE =
//                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION_IMAGES;
//
//        public static final String ITEM_TYPE =
//                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION_IMAGES;
//
//        public static final String TABLE_NAME = "attraction_images";
//
//        public static final String COLUMN_ATTRACTION_TITLE = "attraction_title";
//        public static final String COLUMN_IMAGE = "image";
//
//        public static Uri buildAttractionImageUri(long id) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
//            return ContentUris.withAppendedId(CONTENT_URI, id);
//        }
//
//        public static Uri buildAttractionImageUriWithAttractionTitle(String attractionTitle) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_ATTRACTION_TITLE, attractionTitle)
//                    .build();
//        }
//
//        public static String getAttractionTitleFromParam(Uri uri) {
//            return uri.getQueryParameter(COLUMN_ATTRACTION_TITLE);
//        }
//    }

}
