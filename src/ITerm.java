public interface ITerm {
   ITerm derivative(); // Calculates derivative of term
   double evaluate(double x); // Evaluates derivative at value x
   String toString(); // Converts derivative to string representation
}