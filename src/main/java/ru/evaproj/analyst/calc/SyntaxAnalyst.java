package ru.evaproj.analyst.calc;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

@Slf4j
public class SyntaxAnalyst {


    /*  Функция принимает список объектов и наименование строкового поля для
        дальнейшего синтаксического анализа.
        Функция разбирает стоку на слова и возвращает список сключенных слов
        с ссылками на объекты в которых данная строка присутствует.
    */
    public Map<String, Set<Object>> parsing (List<? extends Object> list, String fieldName) throws NoSuchFieldException {

        if (list.size() == 0)
            throw new RuntimeException ("Size of your data is 0.");

        Map <String, Set <Object>> links = new HashMap<>();
        Field field = list.get(0).getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        list.
                stream().
                forEach((obj) -> {
                    try {
                        Arrays.asList(((String)field.get(obj)).split(" "))
                                .stream()
                                .forEach(s -> {
                                    if (links.containsKey(s)) {
                                        links.get(s).add(obj);
                                    }
                                    else {
                                        links.put(s, new HashSet<>());
                                        links.get(s).add(obj);
                                    }
                                });
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        log.error(ex.getMessage());
                    }
                });

        return links;
    }
}
