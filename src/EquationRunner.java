

import java.util.Scanner;




public class EquationRunner {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        // Get the first coordinate point
        System.out.println("Enter the first coordinate point (x1, y1): ");
        String point1 = scanner.nextLine();
        int x1 = Integer.parseInt(point1.substring(1, point1.indexOf(",")));
        int y1 = Integer.parseInt(point1.substring(point1.indexOf(",") + 1, point1.length() - 1));




        // Get the second coordinate point
        System.out.println("Enter the second coordinate point (x2, y2): ");
        String point2 = scanner.nextLine();
        int x2 = Integer.parseInt(point2.substring(1, point2.indexOf(",")));
        int y2 = Integer.parseInt(point2.substring(point2.indexOf(",") + 1, point2.length() - 1));




        // Create a LinearEquation object
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);




        // Print the equation
        System.out.println(equation);




        // Ask the user to input x to solve for y
        System.out.println("Enter an x-value to solve for y: ");
        double xValue = scanner.nextDouble();




        // Solve for y and print the result
        System.out.println("The coordinate point is: " + equation.solveForY(xValue));




        scanner.close();
    }
}















