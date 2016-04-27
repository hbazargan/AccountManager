package hbazargan.accountmanager;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

public class ContactContentObserver extends ContentObserver {
    private final String TAG;
    private final String LABEL;
    Context ctx;

    public ContactContentObserver(Context ctx) {
        super(null);
        this.ctx = ctx;
        TAG = ctx.getResources().getString(R.string.log_tag);
        LABEL = ctx.getResources().getString(R.string.label);
        Log.d(LABEL, TAG + " register this contentObserver " + this);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Log.w(LABEL, TAG + " We are in onChange");

    }
}