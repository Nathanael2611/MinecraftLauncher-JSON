package fr.nathanael2611.minecraftlauncherjson.auth.model.request;

public class InvalidateRequest {

    /**
     * The access token you want to invalidate
     */
    private String accessToken;

    /**
     * The client token associated with the access token
     */
    private String clientToken;

    /**
     * Invalidate Request constructor
     *
     * @param accessToken
     *            The access token you want to invalidate
     * @param clientToken
     *            The client token associated with the access token
     */
    public InvalidateRequest(String accessToken, String clientToken) {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
    }

    /**
     * Sets a new access token (That you want to invalidate)
     *
     * @param accessToken
     *            The new access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
     * Sets a new client token (Need to be associated with the access token)
     *
     * @param clientToken
     *            The new client token
     */
    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    /**
     * Returns the client token (Given by the constructor or the setter)
     *
     * @return The given client token
     */
    public String getClientToken() {
        return clientToken;
    }

}
