package com.example;

import java.io.IOException;


class Main {

    private static final String[] TASK_ONE = {"11", "34", "Main", "0010"};
    private static final String[] TASK_TWO = {"Arg1", "12", "1", "MainTest"};
    private static final String[] TASK_THREE = {"InputText.getText()", "InputText12.getString",
            "input_Text.getText()", "2inputText.get()", "Input!.set"};

    public static void main(String[] args) throws IOException {
        System.out.print("Enter # of example to run [1-3], w - Weather, m - Matrix or Q for Exit:");
        int input = System.in.read();
        char ch = (char) input;
        while (ch != 'q') {
            switch (ch) {
                case '1':
                    //Run test #1
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    TaskOneStrings test1 = new TaskOneStrings(TASK_ONE);
                    String testStr = test1.toString();
                    test1.printConsole();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case '2':
                    //Run test #2
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    TaskTwoStrings test2 = new TaskTwoStrings(TASK_TWO);
                    test2.printConsole();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case '3':
                    //Run test #3
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    TaskThreeStrings.TaskStart(TASK_THREE);
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 'w':
                    //Run weather class
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//                    Weather w1 = new Weather("North", 3, 12.5, true, false);
//                    Weather w2 = new Weather("South", 1, -10, false, false);
//                    Weather w3 = new Weather("West", 23, 22.7, false, false);
//                    Weather w4 = new Weather("North", 13, 12, false, true);
//                    System.out.println(w1.toString());
//                    System.out.println(w2.whatIsWeather());
//                    System.out.println(w3.whatIsWeather());
//                    System.out.println(w4.whatIsWeather());
//                    Weather w5 = new Weather("North", 3, 12.5, true, false);
//                    Weather w6;
//                    w6 = w5;
//                    Weather w7 = new Weather("North", 3, 12.5, true, false);
//                    System.out.println(w5.toString());
//                    System.out.println(w6.toString());
//                    System.out.println(w7.toString());
//
//                    if (w5.equals(w6)) {
//                        System.out.println("w5=w6");
//                    } else {
//                        System.out.println("w5!=w6");
//                    }
//
//                    if (w5.equals(w7)) {
//                        System.out.println("w5=w7");
//                    } else {
//                        System.out.println("w5!=w7");
//                    }
//
//                    if (w7.equals(w6)) {
//                        System.out.println("w7=w6");
//                    } else {
//                        System.out.println("w7!=w6");
//                    }
//                    Weather weather = new Weather("North", 100, 50, true, false);
////                    WeatherMoon weatherMoon = new WeatherMoon("North", 100, 50, true, false);
////                    if (weather.equals(weatherMoon)) {
////                        System.out.println("weather=weatherMoon");
////                    } else {
////                        System.out.println("weather!=weatherMoon");
////                    }
//
//                    if (weather.equals(new TaskOneStrings(TASK_ONE))) {
//                        System.out.println("weather=weatherMoon");
//                    } else {
//                        System.out.println("weather!=weatherMoon");
//                    }
                    Circle circle = new Circle(2);
                    System.out.println(circle.toString());
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    break;
                case 'm':
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                    Matrix matrix = new Matrix(5);  //new empty matrix 5x5
                    System.out.println(matrix.toString());
                    System.out.println("Sum is " + matrix.sumOfMatrix());
                    matrix.randomizeMatrix(-100, 100); //fill matrix with values
                    System.out.println(matrix.toString());
                    System.out.println("Sum is " + matrix.sumOfMatrix());

                    Matrix matrix1 = new Matrix(5, 0, 9); //new matrix 5x5 with values
                    System.out.println(matrix1.toString());
                    System.out.println("Sum is " + matrix1.sumOfMatrix());
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


                    break;
                default:
                    System.out.println("Warning! Wrong number. Please renter your key.");
            }
            System.out.print("Enter # of example to run [1-3], w - Weather, m - Matrix or Q for Exit:");
            input = System.in.read();
            ch = (char) input;
        }
    }

}
