package ru.naumen.collection.task3;

import java.nio.file.Path;


/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources",
            "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");


    public static void main(String[] args) {
//        Long time = System.currentTimeMillis();
        WordParser wp = new WordParser(WAR_AND_PEACE_FILE_PATH);
        wp.forEachWord(str -> TextAnalytics.addToCounter(str));
        TextAnalytics.getTop10MostFrequency();
        TextAnalytics.getLast10LowestFrequency();
//        System.out.println(System.currentTimeMillis() - time);
         //1134 LinkedHashMap
        // 1480 HashMap
    }
}
