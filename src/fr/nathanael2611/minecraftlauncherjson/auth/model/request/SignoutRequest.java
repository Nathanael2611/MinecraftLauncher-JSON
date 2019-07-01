package fr.nathanael2611.minecraftlauncherjson.auth.model.request;

public class SignoutRequest {

    /**
     * The username of the player that you want to signout
     */
    private String username;

    /**
     * The password of the player that you want to signout
     */
    private String password;

    /**
     * Signout Request constructor
     *
     * @param username
     *            The username of the player that you want to signout
     * @param password
     *            The password of the player that you want to signout
     */
    public SignoutRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Sets a new username (Of the player that you want to signout)
     *
     * @param username
     *            The new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the username (Given by the constructor or the setter)
     *
     * @return The given username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets a new password (Of the player that you want to signout)
     *
     * @param password
     *            The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the password (Given by the constructor or the setter)
     *
     * @return The given password
     */
    public String getPassword() {
        return password;
    }

}
