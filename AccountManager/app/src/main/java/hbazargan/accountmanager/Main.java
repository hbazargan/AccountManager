package hbazargan.accountmanager;

import android.app.Activity;
import android.app.NotificationManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationManagerCompat;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.SyncStatusObserver;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class Main extends Activity {

    private String TAG = this.getClass().getSimpleName();
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notification;

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
    @Override
    protected void onResume() {
        super.onResume();

        Log.d("HBazargan", "onResume> ");
        handleSyncObserver = ContentResolver.addStatusChangeListener(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE |
                ContentResolver.SYNC_OBSERVER_TYPE_PENDING, syncObserver);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("HBazargan", "onPause> ");
//        if (handleSyncObserver != null)
//            ContentResolver.removeStatusChangeListener(handleSyncObserver);
//        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("HBazargan", "onCreate> ");
        setContentView(R.layout.main);
        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new ContactContentObserver(this));

    }

    private void refreshSyncStatus() {
        Toast.makeText(this,"onPerformSync",Toast.LENGTH_LONG).show();
        Log.d("HBazargan", "refreshSyncStatus> ");

    }


}
