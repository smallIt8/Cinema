package org.example.util.constant;

public final class RegexConstant {
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9]{4,100}$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9_]{8,25}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]{4,25}@[a-zA-Z0-9-]{2,25}\\.[a-zA-Z]{2,10}$";
    public static final String STEP_REGEX = "^[0-9]+$";
    public static final String FILM_NAME = "^[a-zA-Z0-9][a-zA-Z0-9.,?!\\-_\\s'\":()]{2,99}$";
    public static final String YEAR = "^19[2-9][0-9]|20[0-9]{2}$";
    public static final String COUNTRY = "^[a-zA-Z\\s\\-,]{2,100}$";
    public static final String DESCRIPTION = "^[a-zA-Z0-9.,?!\\-_'\"\\s():;\\n]{5,200}$";

    private RegexConstant() {
    }
}