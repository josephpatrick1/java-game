package engine;

public class KeyHandler {
    private String key;
    private String type;
    private Runnable runnable;

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public KeyHandler(String key, String type, Runnable runnable) {
        this.key = key;
        this.type = type;
        this.runnable = runnable;
    }
}