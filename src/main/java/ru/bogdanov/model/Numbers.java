package ru.bogdanov.model;

public class Numbers {
    private int number;
    private EGender gender;
    private String именительный;
    private String родительный;
    private String дательный;
    private String винительный;
    private String творительный;
    private String предложный;

    public Numbers(int number, String именительный, String родительный, String дательный, String винительный, String творительный, String предложный) {
        this.number = number;
        this.именительный = именительный;
        this.родительный = родительный;
        this.дательный = дательный;
        this.винительный = винительный;
        this.творительный = творительный;
        this.предложный = предложный;
    }

    public Numbers(int number, EGender gender, String именительный, String родительный, String дательный, String винительный, String творительный, String предложный) {
        this.number = number;
        this.gender = gender;
        this.именительный = именительный;
        this.родительный = родительный;
        this.дательный = дательный;
        this.винительный = винительный;
        this.творительный = творительный;
        this.предложный = предложный;
    }

    public int getNumber() {
        return number;
    }

    public EGender getGender() {
        return gender;
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
        return "Numbers{" +
                "number=" + number +
                ", gender=" + gender +
                ", именительный='" + именительный + '\'' +
                ", родительный='" + родительный + '\'' +
                ", дательный='" + дательный + '\'' +
                ", винительный='" + винительный + '\'' +
                ", творительный='" + творительный + '\'' +
                ", предложный='" + предложный + '\'' +
                '}';
    }
}
