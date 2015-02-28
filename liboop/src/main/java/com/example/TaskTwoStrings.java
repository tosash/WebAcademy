package com.example;

//Вариант 2-18
//Анализ аргументов, задаваемых при запуске программы.
//Программа переставляет введенные аргументы в порядке возрастания их длины.
//Шаблон аргумента: строка либо цифр, либо латинских букв, либо букв кириллицы.
//Программа выводит количество заданных аргументов, их значения, а также список
//значений аргументов в порядке возрастания  их длины.

import java.util.Arrays;
import java.util.Comparator;

public class TaskTwoStrings extends TaskOneStrings {

    private String[] sortedArgs;

    public TaskTwoStrings(String[] tempArgs) {
        super(tempArgs);
        sortedArgs = this.getArgs().clone();
        Arrays.sort(sortedArgs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
    }

    @Override
    public void printConsole() {
        String sTemp;

        System.out.println("Entered not sorted arguments : ");
        for (int i = 0; i < getArgs().length; i++) {
            System.out.println(getArgsItem(i));
        }
        System.out.println("Sorted arguments: ");
        for (int i = 0; i < sortedArgs.length; i++) {
            System.out.println("Value: " + sortedArgs[i] +
                    ", Length is " + Integer.toString(sortedArgs[i].length()));
        }
    }
}
