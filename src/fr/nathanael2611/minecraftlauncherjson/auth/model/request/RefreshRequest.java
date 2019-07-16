package fr.nathanael2611.minecraftlauncherjson.auth.model.request;

public class RefreshRequest {

    /**
     * The saved access token that you want to refresh
     */
    private String accessToken;

    /**
     * The saved client token associated with the access token
     */
    private String clientToken;

    /**
     * Refresh Request constructor
     *
     * @param accessToken The saved access token that you want to refresh
     * @param clientToken The saved client token associated with the access token
     */
    public RefreshRequest(String accessToken, String clientToken) {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
    }

    /**
     * Returns the access token (Given by the constructor or the setter)
     *
     * @return The given access token
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Sets a new access token (That you want to refresh)
     *
     * @param accessToken The new access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Returns the client token (Given by the constructor or the setter)
     *
     * @return The given client token
     */
    public String getClientToken() {
        return this.clientToken;
    }

    /**
     * Sets a new client token (Need to be associated with the access token)
     *
     * @param clientToken The new client token
     */
    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

}