package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String inputString;
        double result;
        String regExp = "\\d+\\s[+,\\- *, %, /, ^]\\s\\d+"; //класс для чтения регулярного выражения
        try (BufferedReader fr = new BufferedReader(new FileReader("C://Users//Artem//IdeaProjects//kalkulator2//src//input.txt"));
             BufferedWriter ad = new BufferedWriter(new FileWriter("C://Users//Artem//IdeaProjects//kalkulator2//src//output.txt"))) {

            while ((inputString = fr.readLine()) != null) {
                if ((inputString.trim().matches(regExp))) {
                    result = split(inputString.split(" "));
                    ad.write(result + "\n");
                } else {
                    ad.write("Введены некорректные данные" + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для работы с введенной пользователем строкой и поиска в нем нужных значений
     *
     * @param array массив для разрыва строки на значения, необходимый для длальнейшей работы с ними
     * @return возвращает значения для возможности их дальнейшего использования методе calculate
     * @throws Exception обрабатывает исключения
     */
    private static double split(String[] array) throws Exception {
        String operand;
        double number1;
        double number2;
        if (array.length == 3) {
            number1 = Double.parseDouble(array[0]);
            operand = array[1];
            number2 = Double.parseDouble(array[2]);
            return calculate(number1, number2, operand);
        } else {
            throw new Exception("Ввод не корректен");
        }
    }

    /**
     * метод для реализации базовых функций калькулятора
     * @param number1 значение 1
     * @param number2 значение 2
     * @param operand действие, которое должно быть применено к значению
     * @return возвращает результат действия
     * @throws Exception обрабатывает исключения
     */
    private static double calculate(double number1, double number2, String operand) throws Exception {
        switch (operand) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            case "^":
                return Math.pow(number1, number2);
            case "%":
                return number1 % number2;
            default:
                throw new Exception("Ввод не корректен");
        }
    }
}