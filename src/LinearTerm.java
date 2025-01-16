public class LinearTerm extends ConstantTerm {
    private int a;

    public LinearTerm(int a) {
        super(a);
        this.a = a;
    }
    
    public int getCoefficient() {
        return a;
    }
    
    @Override
    public ITerm derivative() {
        return new ConstantTerm(a);
    }
    
    @Override
    public double evaluate(double x) {
        return a * x;
    }

    @Override
    public String toString() {
        return a + "x";
    }
}