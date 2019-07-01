package fr.nathanael2611.minecraftlauncherjson.auth.model;

public class AuthAgent {

    /**
     * The Minecraft auth agent
     */
    public static final AuthAgent MINECRAFT = new AuthAgent("Minecraft", 1);

    /**
     * The Scroll auth agent
     */
    public static final AuthAgent SCROLLS = new AuthAgent("Scrolls", 1);

    /**
     * The agent name
     */
    private String name;

    /**
     * The agent version
     */
    private int version;

    /**
     * Agent constructor
     *
     * @param name
     *            The name of the agent
     * @param version
     *            The version of the agent (1 by default)
     */
    public AuthAgent(String name, int version) {
        this.name = name;
        this.version = version;
    }

    /**
     * Sets a new name
     *
     * @param name
     *            The new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the agent
     *
     * @return The agent name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets a new version
     *
     * @param version
     *            The new version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Returns the version of the agent
     *
     * @return The agent version
     */
    public int getVersion() {
        return this.version;
    }

}