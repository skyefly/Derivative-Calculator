public class ConstantTerm implements ITerm {
    private int a;

    public ConstantTerm(int a) {
        this.a = a;
    }
    
    @Override
    public ITerm derivative() {
        return new ConstantTerm(0);
    }
    
    @Override
    public double evaluate(double x) {
        return a;
    }
    
    @Override
    public String toString() {
        return String.valueOf(a);
    }
}