package ru.bogdanov.ChelyabInvestBank.model;

/**
 * Класс для систем счисления (миллион, тысяча и т.д.)
 * */
public class SystemName {
    private String именительный;
    private String родительный;
    private String дательный;
    private String винительный;
    private String творительный;
    private String предложный;

    public SystemName(String именительный, String родительный, String дательный, String винительный, String творительный, String предложный) {
        this.именительный = именительный;
        this.родительный = родительный;
        this.дательный = дательный;
        this.винительный = винительный;
        this.творительный = творительный;
        this.предложный = предложный;
    }

    public String getИменительный() {
        return именительный;
    }

    public String getРодительный() {
        return родительный;
    }

    public String getДательный() {
        return дательный;
    }

    public String getВинительный() {
        return винительный;
    }

    public String getТворительный() {
        return творительный;
    }

    public String getПредложный() {
        return предложный;
    }

    @Override
    public String toString() {
        return "SystemNameSystem{" +
                ", именительный='" + именительный + '\'' +
                ", родительный='" + родительный + '\'' +
                ", дательный='" + дательный + '\'' +
                ", винительный='" + винительный + '\'' +
                ", творительный='" + творительный + '\'' +
                ", предложный='" + предложный + '\'' +
                '}';
    }
}
