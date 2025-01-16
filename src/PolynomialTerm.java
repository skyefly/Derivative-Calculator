public class PolynomialTerm extends LinearTerm {
    private int a; // coefficient
    private int b; // exponent

    // Constructs a PolynomialTerm with the specified values
    public PolynomialTerm(int a, int b) {
        super(a);
        this.a = a;
        this.b = b;
    }
    
    // Gets exponent
    public int getExponent() {
        return b;
    }

    // Gets derivative of polynomial term
    @Override
    public ITerm derivative() {
        if (b == 2) {
            return new LinearTerm(2 * a);
        } else {
            return new PolynomialTerm(a * b, b - 1);
        }
    }
    
    // Evaluates derivative at value x
    @Override
    public double evaluate(double x) {
        return a * Math.pow(x, b);
    }
    
    // Converts term to string representation
    @Override
    public String toString() {
        return a + "x^" + b;
    }
}