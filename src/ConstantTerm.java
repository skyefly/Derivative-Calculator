public class ConstantTerm implements ITerm {
    private int a; // coefficient
   
    // Constructs a ConstantTerm with the specified value
    public ConstantTerm(int a) {
        this.a = a;
    }
    
    // Calculates derivative of constant term
    @Override
    public ITerm derivative() {
        return new ConstantTerm(0);
    }
    
    // Evaluates derivative at value x
    @Override
    public double evaluate(double x) {
        return a;
    }
    
    // Converts term to string representation
    @Override
    public String toString() {
        return String.valueOf(a);
    }
}