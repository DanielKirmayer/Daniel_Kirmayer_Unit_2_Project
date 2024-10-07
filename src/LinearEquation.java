public class LinearEquation {
    private int x1, y1, x2, y2;


    // Constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    // Method to calculate the distance between the two points
    public double distance() {
        return Math.round(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) * 100.0) / 100.0;
    }


    // Method to calculate the slope of the line
    public String slope() {
        int numerator = y2 - y1;
        int denominator = x2 - x1;


        // Handle undef
        if (denominator == 0) {
            return "undefined";
        }


        // Simplify slope to whole number if possible
        if (numerator % denominator == 0) {
            int slopeInt = numerator / denominator;
            if (slopeInt == 1) {
                return "";
            } else if (slopeInt == -1) {
                return "-";
            } else {
                return (slopeInt)+"x";
            }


        } else {
            // Return as fraction and convert negative/negative to positive/positive
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;


            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }


            if (numerator == 1) {
                return "x";
            } else if (numerator == -1) {
                return "-x";
            } else {
                return numerator + "/" + denominator + "x";
            }


        }
    }


    // Method to find greatest common denom.
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    // Method to calc y-intercept
    public double yIntercept() {
        double m = (double)(y2 - y1) / (x2 - x1);
        return Math.round((y1 - m * x1) * 100.0) / 100.0;
    }


    // Method to return the equation
    public String equation() {
        String equation = "";
        String m = slope();
        double b = yIntercept();
        String bVal = "";


        if (b > 0) {
            bVal = "+ " + b;
        } else if (b < 0) {
            bVal = "- " + Math.abs(b);
        }


        // Handle slope = 0 and y-intercept = 0
        if (m.equals("") && b == 0) {
            return "y = 0";
        }


        equation = "y = " + m;


        if (b != 0) {
            equation += " " + bVal; // Append the y-intercept if b isn't 0
        }
        return equation;


    }


    // Method to solve for y given x
    public String solveForY(double xValue) {
        double slope = (double)(y2 - y1) / (x2 - x1);
        double yValue = Math.round((slope * xValue + yIntercept()) * 100.0) / 100.0;
        return "(" + xValue + ", " + yValue + ")";
    }


    // Method to return deets of object
    public String toString() {
        return "Points: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n"
                + "Equation: " + equation() + "\n"
                + "Slope: " + slope() + "\n"
                + "Y-Intercept: " + yIntercept() + "\n"
                + "Distance between points: " + distance();
    }
}
