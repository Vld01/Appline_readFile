package main;


import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> words = new HashMap<>();

        readAndSplitFile(words);
        printSortedWords(words);
        printWordStatistic(words);
        printWordMax(words);
    }

    private static void readAndSplitFile(Map<String, Integer> words) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //FileReader fileReader = new FileReader(reader.readLine());
        FileReader fileReader = new FileReader("D:\\Загрузки хром\\Учеба Appline\\7. Collections от 22.11.2020\\test.txt");
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()){
            String[] wordsInLine = bufferedReader.readLine().split("[^a-zа-яA-ZА-Я]");
            for (String s : wordsInLine) {
                String s2 = s.toLowerCase();
                if (!s2.equals("")) {
                    if (!words.containsKey(s2)) {
                        words.put(s2, 1);
                    } else {
                        words.put(s2, words.get(s2) + 1);
                    }
                }
            }
        }
        fileReader.close();
    }

    private static void printWordStatistic(Map<String, Integer> map) {
        System.out.println("  Статистика слов:");
        sortedWords(map).forEach(x -> System.out.println(x + " - " + map.get(x)));
    }

    private static List<String> sortedWords(Map<String, Integer> map) {
        ArrayList<String> sortedWords = new ArrayList<>(map.keySet());
        Collections.sort(sortedWords);
        return sortedWords;
    }

    private static void printSortedWords(Map<String, Integer> map) {
        System.out.println("  Отсортированные по алфавиту слова:");
        sortedWords(map).forEach(System.out::println);
    }

    private static void printWordMax(Map<String, Integer> map) {
        Integer max = 0;
        for (Map.Entry<String, Integer> entry:
             map.entrySet()) {
            if (entry.getValue() != null) {
                Integer i = entry.getValue();
                if (i > max) max = i;
            }
        }
        for (Map.Entry<String, Integer> entry:
             map.entrySet()) {
            if (entry.getValue() != null) {
                if (entry.getValue().equals(max)) {
                    System.out.println("Слово с максимальным количеством повторений в тексте: " + entry.getKey() + " - " + entry.getValue() + " совпадений");
                }
            }
        }
    }
}
