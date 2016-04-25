package hbazargan.accountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Laptop1 on 4/25/2016.
 */
public class HbazarganAuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {

        HbazarganAuthenticator authenticator = new HbazarganAuthenticator(this);
        return authenticator.getIBinder();
    }
}
