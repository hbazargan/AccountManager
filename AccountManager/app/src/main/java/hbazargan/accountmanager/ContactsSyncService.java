package hbazargan.accountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Laptop1 on 4/25/2016.
 */
public class ContactsSyncService extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static ContactsSyncAdapter sSyncAdapter = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null)
                sSyncAdapter = new ContactsSyncAdapter(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
