package hbazargan.accountmanager;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class Main extends Activity {

    private final String TAG = getResources().getString(R.string.log_tag);
    private final String LABEL = getResources().getString(R.string.label);
    SyncStatusObserver syncObserver = new SyncStatusObserver() {
        @Override
        public void onStatusChanged(final int which) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    refreshSyncStatus();
                }
            });
        }
    };
    Object handleSyncObserver;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notification;

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LABEL, TAG + " onResume> ");
        handleSyncObserver = ContentResolver.addStatusChangeListener(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE |
                ContentResolver.SYNC_OBSERVER_TYPE_PENDING, syncObserver);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(LABEL, TAG + " onPause> ");
//        if (handleSyncObserver != null)
//            ContentResolver.removeStatusChangeListener(handleSyncObserver);
//        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LABEL, TAG + " onCreate> ");
        setContentView(R.layout.main);
        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new ContactContentObserver(this));

    }

    private void refreshSyncStatus() {
        Toast.makeText(this,"onPerformSync",Toast.LENGTH_LONG).show();
        Log.d(LABEL, TAG + " refreshSyncStatus> ");

    }


}
