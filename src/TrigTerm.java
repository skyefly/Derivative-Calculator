public class TrigTerm extends LinearTerm {
    private TrigType type;
    
    public TrigTerm(int a, TrigType type) {
        super(a);
        this.type = type;
    }
    
    @Override
    public ITerm derivative() {
        if (type == TrigType.SINE) {
            return new TrigTerm(getCoefficient(), TrigType.COSINE);
        } else {
            return new TrigTerm(-getCoefficient(), TrigType.SINE);
        }
    }
    
    @Override
    public double evaluate(double x) {
        double radians = Math.toRadians(x);
        double result;
        
        if (type == TrigType.SINE) {
            result = getCoefficient() * Math.sin(radians);
        } else {
            result = getCoefficient() * Math.cos(radians);
        }
        return result;
    }
    
    @Override
    public String toString() {
        if (type == TrigType.SINE) {
            return getCoefficient() + "sin(x)";
        } else {
            return getCoefficient() + "cos(x)";
        }
    }
}