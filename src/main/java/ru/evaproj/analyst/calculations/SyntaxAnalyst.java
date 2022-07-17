package ru.evaproj.analyst.calculations;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

@Slf4j
public class SyntaxAnalyst {

    private final List <String> suffixList = Arrays.asList(new String[]{"ая", "яя", "ое", "ее", "ие", "ые", "ого", "его", "ому", "ему", "ом", "ем", "их", "ых", "ими", "ыми", "им", "ым", "ую", "юю", "ой", "ей", "ый", "ий"});
    private final String simbolsRegex = "[#@$%;,:^*?!№]";

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
                        Arrays.asList(((String)field.get(obj)).replaceAll(simbolsRegex, " ").split(" "))
                                .stream()
                                .forEach(s -> {
                                    if (!(s.equals(" ") || s.equals("") || s == null)) {
                                        if (links.containsKey(s.toLowerCase())) {
                                            links.get(s.toLowerCase()).add(obj);
                                        }
                                        else {
                                            links.put(s.toLowerCase(), new HashSet<>());
                                            links.get(s.toLowerCase()).add(obj);
                                        }
                                    }
                                });
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        log.error(ex.getMessage());
                    }
                });

        return links;
    }

    /*  Функция проверяет слово на наличие окончания и убирает его в случае
        нахождения.
        Функция возвращает слово без окончания.
    */
    private String checkSuffixEnd (String str) {
        for (String suffix: suffixList) {
            if (str.endsWith(suffix)) {
                return str.substring(0, str.lastIndexOf(suffix));
            }
        }

        return str;
    }


}
