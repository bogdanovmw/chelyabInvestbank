package ru.bogdanov;

import ru.bogdanov.model.ECase;
import ru.bogdanov.model.EGender;

import static ru.bogdanov.convert.ConvertIntToStringNumber.convertIntToStringNumber;

public class Main {
    public static void main(String[] args) {
        sumProp(31, ECase.РОДИТЕЛЬНЫЙ, EGender.МУРЖСКОЙ);
        sumProp(22, ECase.ТВОРИТЕЛЬНЫЙ, EGender.СРЕДНИЙ);
        sumProp(154323, ECase.ИМЕНИТЕЛЬНЫЙ, EGender.МУРЖСКОЙ);
        sumProp(154323, ECase.ТВОРИТЕЛЬНЫЙ, EGender.МУРЖСКОЙ);
    }

    private static void sumProp(long nSum, ECase eCase, EGender gender) {
        System.out.println(convertIntToStringNumber(nSum, eCase, gender));
    }

    private static void print(int x) {
        System.out.println("Число: " + x);
        System.out.println("Именительный падеж: " + convertIntToStringNumber(x, ECase.ИМЕНИТЕЛЬНЫЙ, EGender.ЖЕНСКИЙ));
        System.out.println("Родительный падеж: " + convertIntToStringNumber(x, ECase.РОДИТЕЛЬНЫЙ, EGender.ЖЕНСКИЙ));
        System.out.println("Дательный падеж: " + convertIntToStringNumber(x, ECase.ДАТЕЛЬНЫЙ, EGender.ЖЕНСКИЙ));
        System.out.println("Винительный падеж: " + convertIntToStringNumber(x, ECase.ВИНИТЕЛЬНЫЙ, EGender.ЖЕНСКИЙ));
        System.out.println("Творительный падеж: " + convertIntToStringNumber(x, ECase.ТВОРИТЕЛЬНЫЙ, EGender.ЖЕНСКИЙ));
        System.out.println("Предложный падеж: " + convertIntToStringNumber(x, ECase.ПРЕДЛОЖНЫЙ, EGender.ЖЕНСКИЙ));
    }
}
