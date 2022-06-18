package model;

public abstract class LoanDBObject {


    private static long NEW_UID = 0;
    private final long id;

    protected LoanDBObject() {
        id = ++NEW_UID;
    }

    public long getId() {
        return id;
    }
}
