package ru.university.lab1.task4;

public class Task04TextProcessing {
    public void run() {
        demonstratePalindrome();
        demonstrateReverseWords();
        demonstrateCountChars();
        demonstrateCaesarCipher();
        demonstrateLongestWord();
    }

    private void demonstratePalindrome() {
        String s = "А роза упала на лапу Азора";
        System.out.println(" Палиндром ");
        System.out.println("'" + s + "' палиндром: " + isPalindrome(s));
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(chars[left])) left++;
            else if (!Character.isLetterOrDigit(chars[right])) right--;
            else {
                if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
                left++; right--;
            }
        }
        return true;
    }

    private void demonstrateReverseWords() {
        String s = "кот съел мышь";
        System.out.println("\n Разворот слов ");
        System.out.println("До: " + s);
        System.out.println("После: " + reverseWords(s));
    }

    private String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left]; chars[left] = chars[right]; chars[right] = temp;
            left++; right--;
        }
    }

    private void demonstrateCountChars() {
        String s = "Hello 123!";
        int[] counts = countChars(s);
        System.out.println("\n Подсчёт символов ");
        System.out.println("Гласные: " + counts[0] + ", Согласные: " + counts[1] +
                ", Цифры: " + counts[2] + ", Пробелы: " + counts[3]);
    }

    private int[] countChars(String s) {
        int[] res = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == ' ') res[3]++;
            else if (c >= '0' && c <= '9') res[2]++;
            else if ("aeiouаеёиоуыэюя".indexOf(c) != -1) res[0]++;
            else if (Character.isLetter(c)) res[1]++;
        }
        return res;
    }

    private void demonstrateCaesarCipher() {
        String s = "Hello World";
        System.out.println("\n Шифр Цезаря ");
        String enc = caesarEncrypt(s, 3);
        System.out.println("Оригинал: " + s);
        System.out.println("Зашифровано: " + enc);
        System.out.println("Расшифровано: " + caesarEncrypt(enc, 23));
    }

    private String caesarEncrypt(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) chars[i] = (char) ('A' + (chars[i] - 'A' + k) % 26);
            else if (Character.isLowerCase(chars[i])) chars[i] = (char) ('a' + (chars[i] - 'a' + k) % 26);
        }
        return new String(chars);
    }

    private void demonstrateLongestWord() {
        String s = "The quick brown fox jumped";
        System.out.println("\n Самое длинное слово ");
        System.out.println("Результат: " + findLongestWord(s));
    }

    private String findLongestWord(String s) {
        String longest = "", current = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) current += c;
            else {
                if (current.length() > longest.length()) longest = current;
                current = "";
            }
        }
        if (current.length() > longest.length()) longest = current;
        return longest;
    }
}