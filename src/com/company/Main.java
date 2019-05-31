package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String HELP_TEXT = "init array\t- инициализация списков набором значений array\n" +
            "print \t\t- печать всех списков \n" +
            "print type \t- печать конкретного списка, где type принимает значения X,S,M\n" +
            "anyMore\t\t- выводит на экран были ли значения не вошедшие ни в один список, возможные значения true, false\n" +
            "clear type\t- чистка списка , где type принимает значения X,S,M\n" +
            "merge\t\t- слить все списки в один вывести на экран и очистить все списки\n" +
            "help\t\t- вывод справки по командам \n";
    private static final String DEFAULT_MENU_TEXT = "вы ввели неверную команду, пожлуйста повторите ввод, \n" +
                                                    "для того, чтобы вывести список команд введите \"help\"";

    private static boolean hasAnyMore = false;
    private static ArrayList<Integer> xList = new ArrayList<>();
    private static ArrayList<Integer> sList = new ArrayList<>();
    private static ArrayList<Integer> mList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("введите команду:");
            menu(scanner.nextLine());
        }
    }

    private static void menu(String menuAction) {
        switch (menuAction) {
            case "init array":
                initArray();
                break;
            case "print":
                print();
                break;
            case "print X":
                print(Type.X_TYPE);
                break;
            case "print S":
                print(Type.S_TYPE);
                break;
            case "print M":
                print(Type.M_TYPE);
                break;
            case "anyMore":
                System.out.println(hasAnyMore);
                break;
            case "clearX":
                clear(Type.X_TYPE);
                break;
            case "clearS":
                clear(Type.S_TYPE);
                break;
            case "clearM":
                clear(Type.M_TYPE);
                break;
            case "merge":
                merge();
                break;
            case "help":
                System.out.println(HELP_TEXT);
                break;
            default:
                System.out.println(DEFAULT_MENU_TEXT);
                break;
        }
    }

    private static void initArray() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
    }

    private static void print() {
    }

    private static void print(Type type) {
        switch (type) {
            case X_TYPE:
                print(xList);
                break;
            case M_TYPE:
                print(mList);
                break;
            case S_TYPE:
                print(sList);
                break;
        }
    }

    private static void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer + ", ");
        }
    }

    private static void clear(Type type) {

    }

    private static void merge() {

    }
}