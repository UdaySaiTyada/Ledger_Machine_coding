package model;

public abstract class RepaymentDBObject {


    private static long NEW_UID = 0;
    private final long id;

    protected RepaymentDBObject() {
        id = ++NEW_UID;
    }

    public long getId() {
        return id;
    }
}
