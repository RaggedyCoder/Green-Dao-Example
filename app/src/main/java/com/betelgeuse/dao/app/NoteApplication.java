package com.betelgeuse.dao.app;

import android.app.Application;

import com.betelgeuse.dao.app.model.DaoMaster;
import com.betelgeuse.dao.app.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class NoteApplication extends Application {

    private DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database database = helper.getWritableDb();
        daoSession = new DaoMaster(database).newSession();
    }
}
