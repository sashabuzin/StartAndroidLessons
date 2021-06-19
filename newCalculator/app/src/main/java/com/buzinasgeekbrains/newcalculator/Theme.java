package com.buzinasgeekbrains.newcalculator;

public final class Theme {
    private static final int MY_THEME_CODE_STYLE = 0;
    private static final int DARK_THEME_CODE_STYLE = 1;
    private static final String SETTINGS_THEME_STYLE = "SETTINGS_THEME_STYLE";

    public static int getMyThemeCodeStyle() {
        return MY_THEME_CODE_STYLE;
    }

    public static int getDarkThemeCodeStyle() {
        return DARK_THEME_CODE_STYLE;
    }

    public static String getSettingsThemeStyle() {
        return SETTINGS_THEME_STYLE;
    }
}
