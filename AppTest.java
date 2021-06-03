package org.example;

import java.util.Scanner;

public class App
{
    public static final double  PI = 3.1415926;
    //вычисление арккосинуса разложением в ряд
    //e - epsilon
    public static double arccos(double x){
        int i = 0;
        double e = 0.0000001;
        double p = x;
        double s = x;
        while (p > e){
            p*=(x*x*(2*i + 1)*(2*i + 1))/(2*(i+1)*(2*i + 3));
            s+=p;
            i++;
        }
        return PI/2 - s;
    }

    //вычисление натурального логарифма разложением в ряд
    public static double ln(double x){
        double result;
        double eps = 0.0000000000001;
        double item = (x - 1) / (x + 1);
        double p = item;
        result = p;
        int i = 3;
        while (p > eps){
            for (int j = 0;j < i;j++){
                p *= p;
            }
            p *= (1.0 / i);
            result += p;
            i += 2;
        }

        result *= 2;
        return result;
    }

    public static void main( String[] args )
    {
        double x, y;
        double Radius = 5;      //из условия задачи
        System.out.println( "Введите Х: " );
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();

        //1 способ - с помощью формул преобразования
        double first = arccos(Math.pow(x, 1/5) / (Math.pow(x, 1/5) + 1));

        double second = ln(Math.pow(4, Math.tan(3 * x)) + Math.sqrt(Math.abs(3 * x - 1)) +
                Math.pow(Math.abs(x), Math.sin(2 * x)))/ln(5);
        second *= second;


        y = Math.pow(first, 9) + second;
        System.out.println("y(x) = " + y + " при х = " + x);

        //2 способ - с помощью модуля Math
        y = Math.pow(Math.acos(Math.pow(x, 1/5) / (Math.pow(x, 1/5) + 1)), 9) +
                Math.pow(Math.log(Math.pow(4, Math.tan(3 * x)) + Math.sqrt(Math.abs(3 * x - 1)) +
                        Math.pow(Math.abs(x), Math.sin(2 * x)))/Math.log(5), 2);

        System.out.println("y(x) = " + y + " при х = " + x);
        System.out.println(x <= Radius && (y <= 0 && Math.abs(y) <= Radius));

    }
}

