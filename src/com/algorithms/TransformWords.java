package com.algorithms;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class TransformWords {

    public LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
        startWord = startWord.toUpperCase();
        stopWord = stopWord.toUpperCase();

        TreeMap<String, String> backtrack = new TreeMap<String, String>();
        HashSet<String> visitedSet = new HashSet<>();
        Queue<String> actionQueue = new LinkedList<>();

        actionQueue.add(startWord);
        visitedSet.add(startWord);

        while (!actionQueue.isEmpty()) {
            String w = actionQueue.poll();
            for (String v : getEditedWords(w)) {
                if (stopWord.equals(v)) {
                    LinkedList<String> list = new LinkedList<String>();
                    list.add(v);

                    while (w != null) {
                        list.add(0, w);
                        w = backtrack.get(w);
                    }

                    return list;
                }

                if (!visitedSet.contains(v)) {
                    if (dictionary.contains(v)) {
                        visitedSet.add(v);
                        actionQueue.add(v);
                        backtrack.put(v, w);
                    }
                }
            }
        }

        return null;
    }

    public List<String> getEditedWords(String word) {
        List<String> words = new ArrayList<String>();

        for (int i = 0;i < word.length();i++) {
            char []wordArray = word.toCharArray();

            for (int c = 'A'; c <= 'Z'; c++) {
                if (wordArray[i] != c) {
                    wordArray[i] = (char)c;
                    words.add(new String(wordArray));
                }
            }
        }

        return words;
    }

    public static void main(String[] args) {
        TransformWords transformWords = new TransformWords();
        Set<String> dictionary = new HashSet<>();
        dictionary.add("LAMP");
        dictionary.add("LIMP");
        dictionary.add("LIME");

        System.out.println(transformWords.transform("DAMP", "LIKE", dictionary));
    }
}
