package fr.nathanael2611.minecraftlauncherjson.auth;

import fr.nathanael2611.minecraftlauncherjson.auth.model.AuthError;

public class AuthenticationException extends Exception {

    /**
     * The given JSON model instance of the error
     */
    private AuthError model;

    /**
     * Create a new Authentication Exception
     *
     * @param model
     *            The given JSON model instance of the error
     */
    public AuthenticationException(AuthError model) {
        super(model.getErrorMessage());
        this.model = model;
    }

    /**
     * Returns the given JSON model instance of the error
     *
     * @return The error model
     */
    public AuthError getErrorModel() {
        return model;
    }
}