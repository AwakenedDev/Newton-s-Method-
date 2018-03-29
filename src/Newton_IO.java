/**
 * This class tests the NewtonsMethod
 * @author  Jigar D. Prajapati
 */
public class Newton_IO {

    public static void main(String[] args) {

        double zeroApprox = .00001; // Approximation of zero
        int maxIteration = 100; // Max number of Newton's method iterations

        NewtonsMethod newtonM = new NewtonsMethod(); //call the other class (i.e NewtonsMethod)

        newtonM.getf(); //know the equation by asking the user for coefficient values

        double x = newtonM.getX_Zero(); //get initial x_zero value from the user

        newtonM.findRoot(zeroApprox, maxIteration, x); //find the root. If root is not found then display error

    }
}
