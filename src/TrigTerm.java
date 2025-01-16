public class TrigTerm extends LinearTerm {
    private TrigType type; // Trig type (sin or cos)
    
    // Constructs a TrigTerm with the specified value and type
    public TrigTerm(int a, TrigType type) {
        super(a);
        this.type = type;
    }
    
    // Calculates derivative of trig term
    @Override
    public ITerm derivative() {
        if (type == TrigType.SINE) {
            return new TrigTerm(getCoefficient(), TrigType.COSINE);
        } else {
            return new TrigTerm(-getCoefficient(), TrigType.SINE);
        }
    }
    
    // Evaluates derivative at value x
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
    
    // Converts term to string representation
    @Override
    public String toString() {
        if (type == TrigType.SINE) {
            return getCoefficient() + "sin(x)";
        } else {
            return getCoefficient() + "cos(x)";
        }
    }
}