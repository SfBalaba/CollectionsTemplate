package ru.naumen.collection.task3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Анализирует текст
 */
public class TextAnalytics {
    /**
     * Отображение, которое хранит частоту слов в тексте
     */
    static final Map<String, Integer> counter = new LinkedHashMap<>();

    /**
     * подсчитывает частоту слов в тексте
     * @param str слово для которого обновляется чатсота встречаемости в тексте
     */
    static void addToCounter(String str) {

        if (counter.containsKey(str)) {
            counter.put(str, counter.get(str) + 1);
        } else {
            counter.put(str, 1);
        }
    }

    /**
     * выводит в консоль топ 10 наиболее используемых слов
     */
    static void getTop10MostFrequency(){
        counter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10)
                .forEach(System.out::println);
    }

    /**
     * выводит в консоль топ 10 наименее используемых слов
     */
    static void getLast10LowestFrequency(){
        counter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()).limit(10)
                .forEach(System.out::println);
    }

}
