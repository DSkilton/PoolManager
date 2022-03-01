/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poolcalculator;

import java.util.Scanner;

/**
 *
 * @author MC03353
 */
public class Main {

    private static final double PI = 3.14;
    private static double length, width, height, radius, depth, internalSurfaceArea, volume;
    private static String userName, poolType, dimensions;
    private static int menuOption = -1;
    private static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        System.out.println("Welcome to Pool Calculator\n"); //backslash n is for new line
        getName();

        while (menuOption != 0) {
            System.out.println("Selection an option\n"
                    + "1. Re-enter name\n"
                    + "2. Rectangular pool\n"
                    + "3. Cylinderical pool\n"
                    + "0. Exit");

            menuOption = SC.nextInt(); //stores user input in menuOption variable

            if (menuOption == 1) {    //compares menuOptional variable and runs 
                getName();          //appropriate method
                break;
            } else if (menuOption == 2) {
                poolType = "Rectangular";
                rectangleVolume();
                break;
            } else if (menuOption == 3) {
                poolType = "Cylindrical";
                cylinderVolume();
                break;
            } else {                //default statement for testing 
                System.out.println("Must be 1 to 3 or 0 to exit\n\n");
            }// end of IF statement            
        }// end of while loop
    }// end of menuMethod

    private static void getName() {
        System.out.println("Please input your name");
        userName = SC.next();
        //add validation later to check correct input 
    }

    private static void inputLength() {
        System.out.println("Please enter length: ");
        length = Double.valueOf(SC.next());
    }

    private static void inputWidth() {
        System.out.println("Please enter width: ");
        width = SC.nextDouble();
    }

    private static void inputHeight() {
        System.out.println("Please enter depth: ");
        height = SC.nextDouble();
    }

    private static void rectangleVolume() {
        inputLength();
        inputWidth();
        inputHeight();
        volume = (length * width * height);
        rectangleInternalSurfaceArea();
    }

    private static void rectangleInternalSurfaceArea() {
        internalSurfaceArea = (2 * (length * width) + 2 * (width * depth) + (width * length));
        //printOutput();
        formattedOutput();
    }

    private static void cylinderInternalSurfaceArea() {
        System.out.println("Made it to cylinder area");
        displayMenu();
    }

    private static void cylinderVolume() {

    }

    private static void printOutput() {
        printFirstAndLastLine();
        System.out.println("Pool Type: " + poolType);
        dimensions();
        System.out.println("Internal Surface Area: " + internalSurfaceArea + " Volume: " + volume);
        System.out.println("Name: " + userName + " ");
        printFirstAndLastLine();
    }

    private static void formattedOutput() {
        String alignTwo = "| %10s %-34s | \r\n"; //padding between strings
        String alignFour = "| %23s %-5s %6s %-6s | \r\n"; //padding between strings
        String alignSix = "| %10s %-5s %-6s %-4s %-4s %-7s | \r\n"; //different padding between strings
        String sFiller = ("|                                               | \n");

//        int iWidth = sFiller.length();
//        int iPadding = iWidth - 34;
//        int iPadStart = iPadding/2;
//      will work ou the middle of the String (remember to alter if your line width or string is odd or even 
        printFirstAndLastLine();
        System.out.print(sFiller);
        System.out.format(alignTwo, "Name:", "Duncan");//aligned Left and is formatted inline with line 26
        System.out.format(alignSix, "Length:", length, "Width:", width, " Height:", height); //different alignement
        System.out.print(sFiller);
        System.out.format(alignFour, "Internal Surface Area:", internalSurfaceArea, "Volume:", volume);
        System.out.print(sFiller);
        printFirstAndLastLine();
    }

    private static void dimensions() {
        if (poolType.equals("Rectangular")) {
            System.out.println("Length: " + length + " Width: " + width + " Height: " + height);
        } else if (poolType.equals("Cylindrical")) {
            System.out.println("Pi: " + PI + " Radius: " + radius + "Height: + " + height);
        } else {
            System.out.println("This block shouldn't run. Line 98");
        }
    }

    private static void printFirstAndLastLine() {
        System.out.format("+-----------------------------------------------+\n");
    }
}
