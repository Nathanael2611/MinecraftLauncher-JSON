package fr.nathanael2611.minecraftlauncherjson.auth.model.response;

import fr.nathanael2611.minecraftlauncherjson.auth.model.AuthProfile;

public class AuthResponse {

    /**
     * The access token
     */
    private String accessToken;

    /**
     * The client token (same as the one given by the request)
     */
    private String clientToken;

    /**
     * All available profiles
     */
    private AuthProfile[] availableProfiles;

    /**
     * The current selected profile from the agent
     */
    private AuthProfile selectedProfile;

    /**
     * Auth Response constructor
     *
     * @param accessToken       The access token
     * @param clientToken       The client token (same as the one given by the request)
     * @param availableProfiles All available profiles
     * @param selectedProfile   The current selected profile from the agent
     */
    public AuthResponse(String accessToken, String clientToken, AuthProfile[] availableProfiles, AuthProfile selectedProfile) {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
        this.availableProfiles = availableProfiles;
        this.selectedProfile = selectedProfile;
    }

    /**
     * Returns the access token
     *
     * @return The access token
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Returns the client token (same as the one given by the request)
     *
     * @return The client token
     */
    public String getClientToken() {
        return this.clientToken;
    }

    /**
     * Returns the available profiles
     *
     * @return The available profiles
     */
    public AuthProfile[] getAvailableProfiles() {
        return this.availableProfiles;
    }

    /**
     * Returns the selected profile from the agent
     *
     * @return The selected profile
     */
    public AuthProfile getSelectedProfile() {
        return this.selectedProfile;
    }

}