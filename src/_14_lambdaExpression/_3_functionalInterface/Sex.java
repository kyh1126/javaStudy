package _14_lambdaExpression._3_functionalInterface;

public enum Sex {
    MAN("M"), WOMAN("W");
    private String code;

    Sex(String code) {
        this.code = code;
    }

    public static Sex fromCode(String code) {
        if (code == null) return null;

        switch (code) {
            case "M":
                return Sex.MAN;
            case "W":
                return Sex.WOMAN;
            default:
                throw new IllegalArgumentException(code + " is not supported type.");
        }
    }
}
