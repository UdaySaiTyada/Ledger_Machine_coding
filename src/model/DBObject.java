package model;

public abstract class DBObject {


    private static long NEW_UID = 0;
    private final long id;

    protected DBObject() {
        id = ++NEW_UID;
    }

    public long getId() {
        return id;
    }
}
