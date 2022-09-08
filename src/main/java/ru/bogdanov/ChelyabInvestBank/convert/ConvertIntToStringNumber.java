package ru.bogdanov.ChelyabInvestBank.convert;

import ru.bogdanov.ChelyabInvestBank.model.ECase;
import ru.bogdanov.ChelyabInvestBank.model.EGender;

import static ru.bogdanov.ChelyabInvestBank.convert.UtilsSearchData.*;

public class ConvertIntToStringNumber {
    /**
     * Данный метод принимает на вход три параметра
     * @param number - число;
     * @param aCase - падеж;
     * @param gender - род;
     * После проверяет не является ли число 0 или не выходит за диапазон,
     * далее разбивает число на миллионы, тысячи, и до тысячи числами,
     * далее проверяется миллионы, тысячи, до тысячи на 0
     * если цифры не равно нулю, то вызывается метод convertToThousand(million, 1, aCase, gender)
     * */
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

    /**
     * Данный метод принимает на вход 4 параметра
     * @param number - число;
     * @param level - (1 - миллионы), (2 - тысячи), (3 - до тысячи) необходимые для описания миллионов и тысяч;
     * @param aCase - падеж;
     * @param gender - род;
     * Данный метод разбивает число на сотни, десятки и единицы
     * Входные параметры: 1_568_101
     *               hundreds = 0 0 1
     *               decimal = 5 6 8
     *               units = 1 0 1
     * */
    private static String convertToThousand(int number, int level, ECase aCase, EGender gender){
        StringBuilder sb = new StringBuilder();

        int hundreds = number / 100;
        int decimal = (number - (hundreds * 100)) / 10;
        int units = number % 10 ;

        /*
        * Если hundreds не равен 0, через метод convertIntNumberToStringCase()
        * ищем нужное слово по числу(int) и падежу, в результате получает сотни в прописи(String)
        * */
        if (hundreds != 0) {
            sb.append(convertIntNumberToStringCase(hundreds * 100, aCase)).append(" ");
        }

        // Переменная для числа от 10 до 20
        int number10Between20 = (decimal * 10) + units;
        if (decimal != 0) {
            // Числа прописи от десяти до девятнадцати
            if (number10Between20 > 10 && number10Between20 < 20)
                sb.append(convertIntNumberToStringCase(number10Between20, aCase)).append(" ");
            // Остальные десятичные числа
            else
                sb.append(convertIntNumberToStringCase(decimal * 10, aCase)).append(" ");
        }

        // Проверка единиц
        if (units != 0 && !(number10Between20 > 10 && number10Between20 < 20)) {
            // склонение прописи числа для миллионов
            if (level == 1 && (units == 1 || units == 2))
                // EGender.МУРЖСКОЙ
                sb.append(convertIntOneAndNumberToStringCase(units, aCase, gender)).append(" ");
            // склонение прописи числа для  1000(Одна) и 2000(Две)
            if (level == 2 && (units == 1 || units == 2))
                // EGender.ЖЕНСКИЙ
                sb.append(convertIntOneAndNumberToStringCase(units, aCase, gender)).append(" ");
            // склонение прописи числа для 1(Один) и 2(Два)
            if (level == 3 && (units == 1 || units == 2)) // Один и Два
                // EGender.МУРЖСКОЙ
                sb.append(convertIntOneAndNumberToStringCase(units, aCase, gender)).append(" ");

            // Перевод остальных чисел от 3 до 9
            if (units != 1 && units != 2)
                sb.append(convertIntNumberToStringCase(units, aCase)).append(" ");
        }

        /*
        * Данный участок кода отвечает за правильное форматирование слов миллион и тысяча
        * @Param level; 1 - миллионы, 2 - тысячи, 3 - сотни и т.к
        * */
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
