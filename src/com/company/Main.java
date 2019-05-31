package com.company;

import java.util.ArrayList;
import java.util.Comparator;
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
    private static final String EMPTY_LIST_TEXT = "Список %s пуст";

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
                print(Type.X_TYPE);
                print(Type.S_TYPE);
                print(Type.M_TYPE);
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
            case "clear X":
                xList.clear();
                break;
            case "clear S":
                sList.clear();
                break;
            case "clear M":
                mList.clear();
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
        list.sort(Comparator.naturalOrder());
        for (Integer integer : list) {
            if (integer % 3 == 0) {
                xList.add(integer);
                if (integer % 7 == 0) {
                    sList.add(integer);
                    mList.add(integer);
                }
            } else {
                if (integer % 7 == 0) {
                    sList.add(integer);
                } else hasAnyMore = true;
            }
        }
    }

    private static void print(Type type) {
        switch (type) {
            case X_TYPE:
                if (xList.isEmpty()) {
                    System.out.println(String.format(EMPTY_LIST_TEXT, "X"));
                } else {
                    print(xList);
                }
                break;
            case M_TYPE:
                if (mList.isEmpty()) {
                    System.out.println(String.format(EMPTY_LIST_TEXT, "M"));
                } else {
                    print(mList);
                }
                break;
            case S_TYPE:
                if (sList.isEmpty()) {
                    System.out.println(String.format(EMPTY_LIST_TEXT, "S"));
                } else {
                    print(sList);
                }
                break;
        }
    }

    private static void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }

    private static void merge() {

    }
}