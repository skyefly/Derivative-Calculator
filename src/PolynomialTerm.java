public class PolynomialTerm extends LinearTerm {
    private int a;
    private int b;

    public PolynomialTerm(int a, int b) {
        super(a);
        this.a = a;
        this.b = b;
    }
    
    public int getExponent() {
        return b;
    }

    @Override
    public ITerm derivative() {
        if (b == 2) {
            return new LinearTerm(2 * a);
        } else {
            return new PolynomialTerm(a * b, b - 1);
        }
    }
    
    @Override
    public double evaluate(double x) {
        return a * Math.pow(x, b);
    }
    
    @Override
    public String toString() {
        return a + "x^" + b;
    }
}