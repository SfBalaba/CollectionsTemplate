package ru.naumen.collection.task3;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Анализирует текст
 */
public class TextAnalytics {
    /**
     * Отображение, которое хранит частоту слов в тексте
     * LinkedHashMap потому, что итерация проиходит быстрее, чем в HashMap
     * сложность операций get, put - O(1)
     */
    static final Map<String, Integer> counter = new LinkedHashMap<>();

    /**
     * подсчитывает частоту слов в тексте
     * @param str слово для которого обновляется чатсота встречаемости в тексте
     *  сложность операций get, put - O(1)
     */
    static void addToCounter(String str) {
       Object frequency = (Object)counter.get(str);
       if(frequency == null){
           counter.put(str, 1);
       }
       else{
           counter.put(str, (int)frequency+1);
       }
    }


    /**
     * @return отсортированные слвоа и их частотность в порядке от наиболее частотного к наименее
     * Сложность O(n log n), где n - количество элементов в частотном словаре
     * sorted O(n log n)
     * toList O(n)
     */
    static List<Map.Entry<String, Integer>> getEntryStream() {
    return counter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toList());
    }


    /**
     * @param freqList список частотности слов в порядке убывания
     * @param top flag порядок вывода в консоль. True если нужно вывести 10 наиболее используемых слов
     * создание ArrayList O(n) добавление элементов из коллекции совершается проходом по каждому элементу
     * получение элемента get ArrayList O(1) по индексу массива
     * Итоговая сложность: O(n) = n + 10
     */
    static void printResult(List<Map.Entry<String, Integer>> freqList, boolean top) {
        ArrayList<Map.Entry<String, Integer>> freq = new ArrayList<>(freqList);
        if (top) {
            for (int i = 0; i < 10; i++) {
                System.out.println(freq.get(i));
            }
        } else {
            for (int i = freq.size() - 1; i > freq.size() - 11; i--) {
                System.out.println(freq.get(i));
            }
        }
    }
}

