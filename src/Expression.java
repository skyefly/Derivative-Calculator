import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Expression {
    private ProjLinkedList<ITerm> terms; // linked list of all terms
    
    // Constructs an empty expression
    public Expression() {
        terms = new ProjLinkedList<>();
    }
    
    // Adds new term to the expression
    public void add(ITerm term) {
        terms.add(term);
    }
    
    // Calculates derivate of expression
    public Expression getDerivative() {
        Expression derivativeExpr = new Expression();
        int index = 0;
        ITerm term;
        while ((term = terms.getAt(index++)) != null) {
            ITerm derivative = term.derivative();
            if (!(derivative instanceof ConstantTerm && derivative.evaluate(0) == 0)) {
                derivativeExpr.add(derivative);
            }
        }
        return derivativeExpr;
    }
    
    // Evaluates expression at value x
    public double getEvaluation(double x) {
        double sum = 0;
        int index = 0;
        ITerm term;
        while ((term = terms.getAt(index++)) != null) {
            sum += term.evaluate(x);
        }
        return sum;
    }
    
    // Converts expression to string representation
    @Override
    public String toString() {
        ArrayList<ITerm> termList = new ArrayList<>();
        
        int index = 0;
        ITerm term;
        while ((term = terms.getAt(index++)) != null) {
            termList.add(term);
        }
        
        // Sort terms
        Collections.sort(termList, new Comparator<ITerm>() {
            @Override
            public int compare(ITerm t1, ITerm t2) {
                int order1 = getOrder(t1);
                int order2 = getOrder(t2);
                
                if (order1 != order2) {
                    return Integer.compare(order2, order1);
                }
                
                double coeff1 = t1.evaluate(0);
                double coeff2 = t2.evaluate(0);
                return Double.compare(coeff1, coeff2);
            }
            
            private int getOrder(ITerm term) {
                if (term instanceof PolynomialTerm) {
                    return ((PolynomialTerm) term).getExponent();
                } 
                else if (term instanceof LinearTerm) {
                    return 1;
                } 
                else if (term instanceof ConstantTerm) {
                    return 0;
                } 
                else if (term instanceof TrigTerm) {
                    return -1;
                }
                return -1;
            }
        });
        
        // Build string representation
        StringBuilder sb = new StringBuilder();
        for (ITerm sortedTerm : termList) {
            sb.append(sortedTerm.toString()).append(" + ");
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 3);
        }
        
        return sb.toString();
    }
}