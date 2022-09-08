package ru.bogdanov.convert;

import ru.bogdanov.data.DataNumbers;
import ru.bogdanov.model.ECase;
import ru.bogdanov.model.EGender;
import ru.bogdanov.model.SystemName;

import java.util.stream.Collectors;

public class UtilsSearchData {
    public static String convertIntNumberToStringCase(int number, ECase eCase) {
        return DataNumbers.numbers
                .stream()
                .filter(el -> el.getNumber() == number)
                .map(m -> {
                    if (eCase.equals(ECase.ИМЕНИТЕЛЬНЫЙ))
                        return m.getИменительный();
                    if (eCase.equals(ECase.РОДИТЕЛЬНЫЙ))
                        return m.getРодительный();
                    if (eCase.equals(ECase.ДАТЕЛЬНЫЙ))
                        return m.getДательный();
                    if (eCase.equals(ECase.ВИНИТЕЛЬНЫЙ))
                        return m.getВинительный();
                    if (eCase.equals(ECase.ТВОРИТЕЛЬНЫЙ))
                        return m.getТворительный();
                    if (eCase.equals(ECase.ПРЕДЛОЖНЫЙ))
                        return m.getПредложный();

                    return "Ошибка";
                })
                .collect(Collectors.joining(","));
    }

    public static String convertIntOneAndNumberToStringCase(int number, ECase eCase, EGender gender) {
        return DataNumbers.numbersOneAndTwo
                .stream()
                .filter(el -> el.getNumber() == number && el.getGender().equals(gender))
                .map(m -> {
                    if (eCase.equals(ECase.ИМЕНИТЕЛЬНЫЙ))
                        return m.getИменительный();
                    if (eCase.equals(ECase.РОДИТЕЛЬНЫЙ))
                        return m.getРодительный();
                    if (eCase.equals(ECase.ДАТЕЛЬНЫЙ))
                        return m.getДательный();
                    if (eCase.equals(ECase.ВИНИТЕЛЬНЫЙ))
                        return m.getВинительный();
                    if (eCase.equals(ECase.ТВОРИТЕЛЬНЫЙ))
                        return m.getТворительный();
                    if (eCase.equals(ECase.ПРЕДЛОЖНЫЙ))
                        return m.getПредложный();

                    return "Ошибка";
                })
                .collect(Collectors.joining(","));
    }

    public static String getSystemName(String name, ECase eCase) {
        SystemName systemNameSystem = DataNumbers.systemNameSystem.get(name);
        if (eCase.equals(ECase.ИМЕНИТЕЛЬНЫЙ))
            return systemNameSystem.getИменительный();
        if (eCase.equals(ECase.РОДИТЕЛЬНЫЙ))
            return systemNameSystem.getРодительный();
        if (eCase.equals(ECase.ТВОРИТЕЛЬНЫЙ))
            return systemNameSystem.getТворительный();
        if (eCase.equals(ECase.ДАТЕЛЬНЫЙ))
            return systemNameSystem.getДательный();
        if (eCase.equals(ECase.ПРЕДЛОЖНЫЙ))
            return systemNameSystem.getПредложный();
        if (eCase.equals(ECase.ВИНИТЕЛЬНЫЙ))
            return systemNameSystem.getВинительный();

        return "Ошибка";
    }
}
