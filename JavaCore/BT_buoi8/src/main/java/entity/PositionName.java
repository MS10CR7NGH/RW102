package entity;

public enum PositionName {
    DEV("Dev"),
    TEST("Test"),
    SCRUM_MASTER("Scrum_Master"),
    PM("PM");
    private final String value;

    PositionName(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
}
