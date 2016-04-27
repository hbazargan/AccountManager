package hbazargan.accountmanager;

/**
 * User: udinic
 * Date: 3/27/13
 * Time: 2:35 AM
 */
public interface AccountServerAuthenticatorInterface {
    String userSignUp(final String name, final String email, final String pass, String authType) throws Exception;
    String userSignIn(final String user, final String pass, String authType) throws Exception;
}
