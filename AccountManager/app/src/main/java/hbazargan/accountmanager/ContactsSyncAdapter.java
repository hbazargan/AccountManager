package hbazargan.accountmanager;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Laptop1 on 4/25/2016.
 */
public class ContactsSyncAdapter extends AbstractThreadedSyncAdapter {

    private final String TAG = getContext().getResources().getString(R.string.log_tag);
    private final String LABEL = getContext().getResources().getString(R.string.label);

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
        Log.d(LABEL, TAG + " onPerformSync for account[" + account.name + "]");
    }
}
