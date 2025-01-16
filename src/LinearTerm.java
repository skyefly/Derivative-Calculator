public class LinearTerm extends ConstantTerm {
    private int a; // coefficient

    // Constructs a LinearTerm with the specified value
    public LinearTerm(int a) {
        super(a);
        this.a = a;
    }
    
    // Gets coefficient value
    public int getCoefficient() {
        return a;
    }
    
    // Calculates derivative of linear term
    @Override
    public ITerm derivative() {
        return new ConstantTerm(a);
    }
    
    // Evaluates derivative at value x
    @Override
    public double evaluate(double x) {
        return a * x;
    }

    // Converts term to string representation
    @Override
    public String toString() {
        return a + "x";
    }
}