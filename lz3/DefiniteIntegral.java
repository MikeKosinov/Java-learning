
package lz3;
import java.util.function.Function;
public class DefiniteIntegral {
    private Function<Double, Double> integrand;
    private double lowerLimit;
    private double upperLimit;

    // Конструктор
    public DefiniteIntegral(Function<Double, Double> integrand, double lowerLimit, double upperLimit) {
        this.integrand = integrand;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    // Метод для обчислення інтегралу за формулою лівих прямокутників
    public double leftRectanglesMethod(int n) {
        double h = (upperLimit - lowerLimit) / n;
        double result = 0;

        for (int i = 0; i < n; i++) {
            double x = lowerLimit + i * h;
            result += integrand.apply(x);
        }

        return h * result;
    }

    // Метод для обчислення інтегралу за формулою правих прямокутників
    public double rightRectanglesMethod(int n) {
        double h = (upperLimit - lowerLimit) / n;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            double x = lowerLimit + i * h;
            result += integrand.apply(x);
        }

        return h * result;
    }

    // Метод для обчислення інтегралу за формулою середніх прямокутників
    public double midRectanglesMethod(int n) {
        double h = (upperLimit - lowerLimit) / n;
        double result = 0;

        for (int i = 0; i < n; i++) {
            double x = lowerLimit + (i + 0.5) * h;
            result += integrand.apply(x);
        }

        return h * result;
    }

    // Метод для обчислення інтегралу за формулою трапецій
    public double trapezoidalMethod(int n) {
        double h = (upperLimit - lowerLimit) / n;
        double result = 0;

        for (int i = 1; i < n; i++) {
            double x = lowerLimit + i * h;
            result += integrand.apply(x);
        }

        result += 0.5 * (integrand.apply(lowerLimit) + integrand.apply(upperLimit));

        return h * result;
    }

    // Метод для обчислення інтегралу за формулою Сімпсона (параболічних трапецій)
    public double simpsonsMethod(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("The number of subintervals (n) must be even for Simpson's rule.");
        }

        double h = (upperLimit - lowerLimit) / n;
        double result = integrand.apply(lowerLimit) + integrand.apply(upperLimit);

        for (int i = 1; i < n; i += 2) {
            double x = lowerLimit + i * h;
            result += 4 * integrand.apply(x);
        }

        for (int i = 2; i < n - 1; i += 2) {
            double x = lowerLimit + i * h;
            result += 2 * integrand.apply(x);
        }

        return h / 3 * result;
    }

    public static void main(String[] args) {
        // Приклад використання
        Function<Double, Double> function = x -> x * x; // Функція x^2
        DefiniteIntegral integral = new DefiniteIntegral(function, 0, 2);

        int n = 1000; // Кількість підінтервалів

        double leftRectanglesResult = integral.leftRectanglesMethod(n);
        double rightRectanglesResult = integral.rightRectanglesMethod(n);
        double midRectanglesResult = integral.midRectanglesMethod(n);
        double trapezoidalResult = integral.trapezoidalMethod(n);
        double simpsonsResult = integral.simpsonsMethod(n);

        System.out.println("Left Rectangles Method: " + leftRectanglesResult);
        System.out.println("Right Rectangles Method: " + rightRectanglesResult);
        System.out.println("Mid Rectangles Method: " + midRectanglesResult);
        System.out.println("Trapezoidal Method: " + trapezoidalResult);
        System.out.println("Simpson's Method: " + simpsonsResult);
    }
}


