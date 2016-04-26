package hbazargan.accountmanager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.AndroidException;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Laptop1 on 4/25/2016.
 */
public class ContactsSyncAdapter extends AbstractThreadedSyncAdapter {

    private static final String TAG = "ContactsSyncAdapter";

    private final ContentResolver mContentResolver;

    private Context context;

    public ContactsSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        this.context=context;
        mContentResolver = context.getContentResolver();
    }

    /**
     * Constructor. Obtains handle to content resolver for later use.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ContactsSyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        this.context=context;
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult) {
        Log.d("HBazargan", "onPerformSync for account[" + account.name + "]");
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
    }
}
