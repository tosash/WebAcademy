package com.example;

//Вариант 2-26
//Анализ аргументов, задаваемых при запуске программы. Аргумент имеет следующий формат:
//   имя-типа-или-имя-класса.имя-переменной-или-имя-метода
//и представляет собой обращение к переменной или вызов метода для объекта или класса в Java.
//Шаблон аргумента: латинские буквы, цифры и символы "$" и "_", считающиеся буквами, и, кроме того,
//первый символ является буквой. Если первый символ обращения – заглавная буква, то выводится
//тип "Static", если строчная буква – выводится "Object". Если имя переменной или метода начинается
//со строчной буквы, то если имя содержит символы "("и ")", то выводится тип обращения "Method",
//иначе выводится тип обращения "Variable". Если какое-либо из приведенных условий не выполняется,
//то выводится тип обращения "Illegal". Программа выводит количество заданных аргументов и,
//для каждого аргумента, его тип, тип обращения и значение.

public class TaskThreeStrings {

    private static final String FORMAT = "^[a-zA-Z][a-zA-Z0-9$_]+.[a-z][a-zA-Z0-9_$()]+";
    private static final String ERR_STR = "Error: Input arguments!";
    private static String[] argDescription;


    public static void TaskStart(String[] args) {
        if (args.length == 0) {
            System.out.println(ERR_STR);
            return;
        }
        argDescription = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i].matches(FORMAT)) {
                char firstCH = args[i].charAt(0);
                int dotIndex = args[i].indexOf('.');
                boolean endString = args[i].endsWith("()");
                argDescription[i] = Character.isUpperCase(firstCH) ? "Static" : "Object";
                argDescription[i] = argDescription[i] + (endString ? ".Method" : ".Variable");
            } else {
                argDescription[i] = "Illegal";
            }
        }
        System.out.println("Entered arguments: " + Integer.toString(args.length));
        System.out.println("List of arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Value: " + args[i] + ", Description: " + argDescription[i]);
        }
    }
}

