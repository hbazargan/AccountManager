package hbazargan.accountmanager;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

public class ContactContentObserver extends ContentObserver {
    Context ctx;

    public ContactContentObserver(Context ctx) {
        super(null);
        this.ctx = ctx;
        Log.d("HBazargan", "register this contentObserver " + this);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Log.w("HBazargan", "We are in onChange");

    }
}