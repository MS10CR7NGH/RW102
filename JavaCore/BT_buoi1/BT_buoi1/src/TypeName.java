public enum TypeName {
    ESSAY("Essay"),
    MULTIPLE_CHOICE("Multiple-Choice");

    private final String value;

    TypeName(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
}