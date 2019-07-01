package fr.nathanael2611.minecraftlauncherjson.auth.model.request;

import fr.nathanael2611.minecraftlauncherjson.auth.model.AuthAgent;

public class AuthRequest {

    /**
     * The authentication agent (Optional, the game profile you want to use, Minecraft, Scrolls, etc...)
     */
    private AuthAgent agent;

    /**
     * The username (The username of the player you want to authenticate)
     */
    private String username;

    /**
     * The password (The password of the player you want to authenticate)
     */
    private String password;

    /**
     * The client token (Optional, it's like a password for the access token)
     */
    private String clientToken;

    /**
     * Authentication Request
     *
     * @param agent
     *            The authentication agent (Optional, the game you want to use, Minecraft, Scrolls, etc...)
     * @param username
     *            The username (The username of the player you want to authenticate)
     * @param password
     *            The password (The password of the player you want to authenticate)
     * @param clientToken
     *            The client token (Optional, It's like a password for the access token)
     */
    public AuthRequest(AuthAgent agent, String username, String password, String clientToken) {
        this.agent = agent;
        this.username = username;
        this.password = password;
        this.clientToken = clientToken;
    }

    /**
     * Sets a new authentication agent (Optional, the game you want to use, Minecraft, Scrolls, etc...)
     *
     * @param agent
     *            The new agent
     */
    public void setAgent(AuthAgent agent) {
        this.agent = agent;
    }

    /**
     * Returns the authentication agent (Given with the constructor or the setter)
     *
     * @return The given auth agent
     */
    public AuthAgent getAgent() {
        return this.agent;
    }

    /**
     * Sets a new username (The username of the player you want to authenticate)
     *
     * @param username
     *            The new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the username (Given with the constructor or the setter)
     *
     * @return The given username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets a new password (The password of the player you want to authenticate)
     *
     * @param password
     *            The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the password (Given with the constructor or the setter)
     *
     * @return The given password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets a new client token (It's like a password for the access token)
     *
     * @param clientToken
     *            The new client token
     */
    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    /**
     * Returns the client token (Given with the constructor or the setter)
     *
     * @return The given client token
     */
    public String getClientToken() {
        return clientToken;
    }

}