package com.example;

//Вариант 2-06
//Анализ типов аргументов, задаваемых при запуске программы.
//Если аргумент является целым двоичным  числом (шаблон: одна и более цифр  0 и 1),
//то  тип аргумента "Binary", иначе "String".
//Программа выводит количество заданных аргументов и, для каждого аргумента, его тип и значение.

public class TaskOneStrings {


    private String[] args;
    private boolean[] typeOfArgs; // true-Binary false-String


    public TaskOneStrings(String[] tempArgs) {

        if (tempArgs.length == 0) {
            System.out.println("Error: Input arguments!");
            return;
        }
        args = new String[tempArgs.length];
        typeOfArgs = new boolean[tempArgs.length];
        for (int i = 0; i < tempArgs.length; i++) {
            setArgsItem(i, tempArgs[i]);
            setTypeOfArgsItem(i, tempArgs[i].matches("[0-1]+") ? true : false);
        }

    }


    public void printConsole() {
        String sTemp;

        System.out.println("Entered arguments: " + Integer.toString(args.length));
        System.out.println("List of arguments:");
        for (int i = 0; i < args.length; i++) {
            sTemp = " Value: " + getArgsItem(i) + ", Type is " + (getTypeOfArgsItem(i) ? "Binary" :
                    "String");
            System.out.println(sTemp);
        }
    }


    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public boolean[] getTypeOfArgs() {
        return typeOfArgs;
    }

    public void setTypeOfArgs(boolean[] typeOfArgs) {
        this.typeOfArgs = typeOfArgs;
    }

    public boolean getTypeOfArgsItem(int i) {
        return typeOfArgs[i];
    }

    public void setTypeOfArgsItem(int i, boolean value) {
        this.typeOfArgs[i] = value;
    }

    public void setArgsItem(int i, String value) {
        this.args[i] = value;
    }

    public String getArgsItem(int i) {
        return args[i];
    }

    @Override
    public String toString() {
        String sTemp;
        String resultString;

        resultString = "";
        for (int i = 0; i < args.length; i++) {
            sTemp = " Value: " + getArgsItem(i) + ", Type is " + (getTypeOfArgsItem(i) ? "Binary" :
                    "String" + "\n");
            resultString = resultString + sTemp;
        }
        return resultString;
    }
}