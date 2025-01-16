public interface ITerm {
   ITerm derivative();
   double evaluate(double x);
   String toString();
}