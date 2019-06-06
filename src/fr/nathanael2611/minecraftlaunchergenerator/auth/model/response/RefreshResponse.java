package fr.nathanael2611.minecraftlaunchergenerator.auth.model.response;

import fr.nathanael2611.minecraftlaunchergenerator.auth.model.AuthProfile;

public class RefreshResponse {

    /**
     * The access token (not the same as the one given by the request)
     */
    private String accessToken;

    /**
     * The client token (same as the one given by the request)
     */
    private String clientToken;

    /**
     * The selected profile
     */
    private AuthProfile selectedProfile;

    /**
     * Refresh Response constructor
     *
     * @param accessToken
     *            The access token (not the same as the one given by the request)
     * @param clientToken
     *            The client token (same as the one given by the request)
     * @param selectedProfile
     *            The profile selected (depending of the sent AuthAgent) containing
     *            more information about the agent (the game) selected, like the
     *            username for Minecraft
     */
    public RefreshResponse(String accessToken, String clientToken, AuthProfile selectedProfile) {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
        this.selectedProfile = selectedProfile;
    }

    /**
     * Returns the access token (not the same as the one given by the request)
     *
     * @return The access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Returns the client token (same as the one given by the request)
     *
     * @return The client token
     */
    public String getClientToken() {
        return clientToken;
    }

    /**
     * Returns the selected profile
     *
     * @return The selected profile
     */
    public AuthProfile getSelectedProfile() {
        return selectedProfile;
    }

}