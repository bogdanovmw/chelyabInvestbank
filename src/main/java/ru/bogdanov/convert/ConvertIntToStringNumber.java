package ru.bogdanov.convert;

import ru.bogdanov.model.ECase;
import ru.bogdanov.model.EGender;

import static ru.bogdanov.convert.UtilsSearchData.*;

public class ConvertIntToStringNumber {
    public static String convertIntToStringNumber (long number, ECase aCase, EGender gender) {
        StringBuilder sb = new StringBuilder();

        if (number > 999_999_999)
            return "Число выходит за рамки указанного диапазона";
        if (number == 0)
            return "ноль";

        int million = (int) number / 1_000_000 ; // миллионы
        int thousand = (int) (number - (million * 1_000_000)) / 1000; // тысячи
        int toThousand = (int) (number % 1000) ; // до тысячи

        if (million != 0) // если миллионы есть
            sb.append(convertToThousand(million, 1, aCase, gender));
        if (thousand != 0) // если тысячи есть
            sb.append(convertToThousand(thousand, 2, aCase, gender));
        if (toThousand != 0) // если до тысячи есть
            sb.append(convertToThousand(toThousand, 3, aCase, gender));

        return  sb.toString();
    }

    private static String convertToThousand(int number, int level, ECase aCase, EGender gender){
        StringBuilder sb = new StringBuilder();

        int hundreds = number / 100;
        int decimal = (number - (hundreds * 100)) / 10;
        int units = number % 10 ;

        if (hundreds != 0) {
            sb.append(convertIntNumberToStringCase(hundreds * 100, aCase)).append(" ");
        }

        int number10Between20 = (decimal * 10) + units;
        if (decimal != 0) {
            if (number10Between20 > 10 && number10Between20 < 20)
                sb.append(convertIntNumberToStringCase(number10Between20, aCase)).append(" ");
            else
                sb.append(convertIntNumberToStringCase(decimal * 10, aCase)).append(" ");
        }

        if (units != 0 && !(number10Between20 > 10 && number10Between20 < 20)) {
            if (level == 1 && (units == 1 || units == 2)) // для миллионов
                // EGender.МУРЖСКОЙ
                sb.append(convertIntOneAndNumberToStringCase(units, aCase, gender)).append(" ");
            if (level == 2 && (units == 1 || units == 2)) // для 1000(Одна) и 2000(Две)
                // EGender.ЖЕНСКИЙ
                sb.append(convertIntOneAndNumberToStringCase(units, aCase, gender)).append(" ");
            if (level == 3 && (units == 1 || units == 2)) // Один и Два
                // EGender.МУРЖСКОЙ
                sb.append(convertIntOneAndNumberToStringCase(units, aCase, gender)).append(" ");

            if (units != 1 && units != 2)
                sb.append(convertIntNumberToStringCase(units, aCase)).append(" ");
        }

        // @Param level; 1 - миллионы, 2 - тысячи, 3 - сотни и т.к
        if (level == 1){
            int million = number % 10;
            if (million == 1)
                sb.append(getSystemName("millionOne", aCase)).append(" ");
            else if (million >= 2 && million <= 4)
                sb.append(getSystemName("millionTwo_1", aCase)).append(" ");
            else
                sb.append(getSystemName("millionTwo_2", aCase)).append(" ");
        } else if (level == 2) {
            int thousand = number % 10;
            if (thousand == 1)
                sb.append(getSystemName("thousandOne", aCase)).append(" ");
            else if (thousand >= 2 && thousand <= 4)
                sb.append(getSystemName("thousandMany_1", aCase)).append(" ");
            else
                sb.append(getSystemName("thousandMany_2", aCase)).append(" ");
        }

        return sb.toString();
    }
}
