package fr.nathanael2611.minecraftlauncherjson.auth;

public class AuthPoints {

    /**
     * The Mojang auth server auth points
     */
    public static final AuthPoints NORMAL_AUTH_POINTS = new AuthPoints("authenticate", "refresh", "validate", "signout", "invalidate");

    /**
     * The server authenticate point
     */
    private String authenticatePoint;

    /**
     * The server refresh point
     */
    private String refreshPoint;

    /**
     * The server validate point
     */
    private String validatePoint;

    /**
     * The server signout point
     */
    private String signoutPoint;

    /**
     * The server invalidate point
     */
    private String invalidatePoint;

    /**
     * AuthPoints constructor
     *
     * @param authenticatePoint
     *            Authenticate point
     * @param refreshPoint
     *            Refresh point
     * @param validatePoint
     *            Validate point
     * @param signoutPoint
     *            Signout point
     * @param invalidatePoint
     *            Invalidate point
     */
    public AuthPoints(String authenticatePoint, String refreshPoint, String validatePoint, String signoutPoint, String invalidatePoint) {
        this.authenticatePoint = authenticatePoint;
        this.refreshPoint = refreshPoint;
        this.validatePoint = validatePoint;
        this.signoutPoint = signoutPoint;
        this.invalidatePoint = invalidatePoint;
    }

    /**
     * Returns the server authenticate point
     *
     * @return The authenticate point
     */
    public String getAuthenticatePoint() {
        return this.authenticatePoint;
    }

    /**
     * Returns the server refresh point
     *
     * @return The refresh point
     */
    public String getRefreshPoint() {
        return this.refreshPoint;
    }

    /**
     * Returns the server validate point
     *
     * @return The validate point
     */
    public String getValidatePoint() {
        return this.validatePoint;
    }

    /**
     * Returns the server signout point
     *
     * @return The signout point
     */
    public String getSignoutPoint() {
        return this.signoutPoint;
    }

    /**
     * Returns the server invalidate point
     *
     * @return The invalidate point
     */
    public String getInvalidatePoint() {
        return this.invalidatePoint;
    }

}