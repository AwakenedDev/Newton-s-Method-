import java.util.Scanner;

/***
 * @author Jigar D. Prajapati
 *
 *This class defines the Newton's Method
 */
public class NewtonsMethod {

    private int a;
    private int b;
    private int c;
    private int exp_a;
    private int exp_b;
    private int exp_c;

    /**
     * Get user input for coefficients
     */
    public void getf() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter coefficient for 'a': ");
        a = input.nextInt();
        System.out.print("Next enter the cofficients a's exponent: ");
        exp_a = input.nextInt();

        System.out.print("\n\nEnter coefficient for 'b': ");
        b = input.nextInt();
        System.out.print("Next enter the coefficient b's exponent: ");
        exp_b = input.nextInt();

        System.out.print("\n\nNext enter the constant c: ");
        c = input.nextInt();
        System.out.print("Next enter the coefficient c's exponent: ");
        exp_c = input.nextInt();
        System.out.println();

        System.out.println("Equeation: f(x) = " + a + "(x^" + exp_a + ") + " + b + "(x^" + exp_b + ") + " + c + "(x^" + exp_c + ")");
    }

    /**
     * get initial x_zero value from the user
     *
     * @return the initial x_zero
     */
    public double getX_Zero() {

        //Ask for user input
        System.out.print("\nPlease enter X\u2080: ");
        Scanner input = new Scanner(System.in);

        //If user enters wrong input, the program will assume that X0 = 0
        if (input.hasNextDouble()) {
            return input.nextDouble();
        } else {
            System.out.println("Invalid input. Assuming that  X\u2080 = 0");
            return 0;
        }

    }

    /**
     * This the function f
     *
     * @param x Initial X0
     * @return Math.sin(x)
     */
    public double f(double x) {

        return (a * (Math.pow(x, exp_a))) + (b * (Math.pow(x, exp_b))) + (c * (Math.pow(x, exp_c)));
    }

    /***
     * This method gives the derivative of function f
     *
     * @param x Initial X0
     * @return Math.cos(x)
     */
    public double finverse(double x) {

        double fInvAns = 0.0;

        int deriv_a = a * exp_a;
        int deriv_exp_a = exp_a - 1;

        if ((deriv_a != 0) && (deriv_exp_a != 0)) {
            fInvAns += (Math.pow((deriv_a * x), deriv_exp_a));
        }

        int deriv_b = b * exp_b;
        int deriv_exp_b = exp_b - 1;

        if ((deriv_b != 0) && (deriv_exp_b != 0)) {
            fInvAns += (Math.pow((deriv_b * x), deriv_exp_b));
        }

        int deriv_c = c * exp_c;
        int deriv_exp_c = exp_c - 1;

        if ((deriv_c != 0) && (deriv_exp_c != 0)) {
            fInvAns += (Math.pow((deriv_c * x), deriv_exp_c));
        }

        return fInvAns;

    }

    /**
     * Finds the root. If root is not found then display error
     *
     * @param tolerance
     * @param maxIteration
     * @param x
     */
    public void findRoot(double tolerance, int maxIteration, double x) {

        int count;

        //For loop that can iterate 200 times to find a root.
        for (count = 1; (Math.abs(f(x)) > tolerance) && (count <= maxIteration); count++) {
            x = x - (f(x) / finverse(x));
            System.out.printf("Step " + count + "| x: %.5f Value: %.5f\n", x, f(x));
        }
        //If root wasn't found in 100 iterations (for this case) then, outputs "Failed to find a zero"
        if (Math.abs(f(x)) <= tolerance) {
            System.out.printf("\nZero found at x= %.5f\n", x);
        } else {
            System.out.println("\nError: No root found (failed to find a zero)\n");
        }

    }

}

