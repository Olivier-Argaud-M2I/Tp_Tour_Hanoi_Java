package fr.m2i.util;

public enum FrontColor {

//    ANSI_RESET ("\u001B[0m"),
//    ANSI_BLACK ("\u001B[30m"),
//    ANSI_RED ("\u001B[31m"),
//    ANSI_GREEN ("\u001B[32m"),
//    ANSI_YELLOW ("\u001B[33m"),
//    ANSI_BLUE ("\u001B[34m"),
//    ANSI_PURPLE ("\u001B[35m"),
//    ANSI_CYAN ("\u001B[36m"),
//    ANSI_WHITE ("\u001B[37m"),


    ROUGE( "\u001B[38;2;255;0;0m"),
    ORANGE( "\u001B[38;2;255;128;0m"),
    JAUNE( "\u001B[38;2;255;255;0m"),
    CITRON( "\u001B[38;2;128;255;0m"),
    VERT( "\u001B[38;2;0;255;0m"),
    EMMERAUDE( "\u001B[38;2;0;255;128m"),
    CYAN( "\u001B[38;2;0;255;255m"),
    AZUR( "\u001B[38;2;0;128;255m"),
    BLEU( "\u001B[38;2;0;0;255m"),
    VIOLET( "\u001B[38;2;128;0;255m"),
    MAGENTA( "\u001B[38;2;255;0;255m"),
    POURPRE( "\u001B[38;2;255;0;128m"),

    BLANC( "\u001B[38;2;255;255;255m"),
    NOIR( "\u001B[38;2;0;0;0m"),
    RESET("\u001B[0m");



    private final String value;

    private FrontColor(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
