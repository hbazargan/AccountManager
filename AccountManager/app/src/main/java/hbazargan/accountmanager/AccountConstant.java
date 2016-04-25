package hbazargan.accountmanager;

/**
 * Created by Laptop1 on 4/25/2016.
 */
public class AccountConstant {

    /**
     * Account type id
     */
    public static final String ACCOUNT_TYPE = "com.hbazargan.accountmanager";

    /**
     * Account name
     */
    public static final String ACCOUNT_NAME = "hbazargan";

    /**
     * Auth token types
     */
    public static final String AUTHTOKEN_TYPE_READ_ONLY = "Read only";
    public static final String AUTHTOKEN_TYPE_READ_ONLY_LABEL = "Read only access to an HBazargan account";

    public static final String AUTHTOKEN_TYPE_FULL_ACCESS = "Full access";
    public static final String AUTHTOKEN_TYPE_FULL_ACCESS_LABEL = "Full access to an HBazargan account";

    public static final ServerAuthenticate sServerAuthenticate = new MeUServerAuthenticate();

}
