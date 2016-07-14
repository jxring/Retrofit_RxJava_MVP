package com.example.y.mvp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "IMAGE_DETAIL_INFO".
*/
public class ImageDetailInfoDao extends AbstractDao<ImageDetailInfo, Integer> {

    public static final String TABLENAME = "IMAGE_DETAIL_INFO";

    /**
     * Properties of entity ImageDetailInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Tag = new Property(0, Integer.class, "tag", true, "TAG");
        public final static Property Id = new Property(1, Integer.class, "id", false, "ID");
        public final static Property Gallery = new Property(2, Integer.class, "gallery", false, "GALLERY");
        public final static Property Src = new Property(3, String.class, "src", false, "SRC");
    }


    public ImageDetailInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ImageDetailInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db) {
        String constraint = "";
        db.execSQL("CREATE TABLE " + constraint + "\"IMAGE_DETAIL_INFO\" (" + //
                "\"TAG\" INTEGER PRIMARY KEY ," + // 0: tag
                "\"ID\" INTEGER," + // 1: id
                "\"GALLERY\" INTEGER," + // 2: gallery
                "\"SRC\" TEXT);"); // 3: src
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db) {
        String sql = "DROP TABLE " + ("IF EXISTS ") + "\"IMAGE_DETAIL_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected void bindValues(SQLiteStatement stmt, ImageDetailInfo entity) {
        stmt.clearBindings();
 
        Integer tag = entity.getTag();
        if (tag != null) {
            stmt.bindLong(1, tag);
        }
 
        Integer id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
 
        Integer gallery = entity.getGallery();
        if (gallery != null) {
            stmt.bindLong(3, gallery);
        }
 
        String src = entity.getSrc();
        if (src != null) {
            stmt.bindString(4, src);
        }
    }

    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset) ? null : cursor.getInt(offset);
    }    

    @Override
    public ImageDetailInfo readEntity(Cursor cursor, int offset) {
        return new ImageDetailInfo( //
            cursor.isNull(offset) ? null : cursor.getInt(offset), // tag
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // id
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // gallery
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // src
        );
    }
     
    @Override
    public void readEntity(Cursor cursor, ImageDetailInfo entity, int offset) {
        entity.setTag(cursor.isNull(offset) ? null : cursor.getInt(offset));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setGallery(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setSrc(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected Integer updateKeyAfterInsert(ImageDetailInfo entity, long rowId) {
        return entity.getTag();
    }
    
    @Override
    public Integer getKey(ImageDetailInfo entity) {
        if(entity != null) {
            return entity.getTag();
        } else {
            return null;
        }
    }

    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
