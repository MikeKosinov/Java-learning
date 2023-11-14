package lz3;
import java.util.Arrays;

class Polynomial {
    private double[] coefficients;

    // Конструктор
    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    // Геттер та сеттер для коефіцієнтів
    public double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }

    // Метод для обчислення значення полінома для заданого x
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    // Метод для додавання поліномів
    public Polynomial add(Polynomial other) {
        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        double[] resultCoefficients = new double[maxLength];
        for (int i = 0; i < this.coefficients.length; i++) {
            resultCoefficients[i] += this.coefficients[i];
        }
        for (int i = 0; i < other.coefficients.length; i++) {
            resultCoefficients[i] += other.coefficients[i];
        }
        return new Polynomial(resultCoefficients);
    }

    // Метод для віднімання поліномів
    public Polynomial subtract(Polynomial other) {
        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        double[] resultCoefficients = new double[maxLength];
        for (int i = 0; i < this.coefficients.length; i++) {
            resultCoefficients[i] += this.coefficients[i];
        }
        for (int i = 0; i < other.coefficients.length; i++) {
            resultCoefficients[i] -= other.coefficients[i];
        }
        return new Polynomial(resultCoefficients);
    }

    // Метод для множення поліномів
    public Polynomial multiply(Polynomial other) {
        int resultDegree = this.coefficients.length + other.coefficients.length - 1;
        double[] resultCoefficients = new double[resultDegree];
        for (int i = 0; i < this.coefficients.length; i++) {
            for (int j = 0; j < other.coefficients.length; j++) {
                resultCoefficients[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }
        return new Polynomial(resultCoefficients);
    }
    // Перевизначений метод toString для зручного виводу
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (coefficients[i] > 0 && i != coefficients.length - 1) {
                    result.append("+");
                }
                if (i == 0) {
                    result.append(coefficients[i]);
                } else if (i == 1) {
                    result.append(coefficients[i]).append("x");
                } else {
                    result.append(coefficients[i]).append("x^").append(i);
                }
            }
        }
        return result.toString();
    }
}

class PolynomialArray {
    private Polynomial[] polynomials;

    // Конструктор
    public PolynomialArray(Polynomial[] polynomials) {
        this.polynomials = polynomials;
    }

    // Метод для обчислення суми поліномів масиву
    public Polynomial sum() {
        if (polynomials.length == 0) {
            return new Polynomial(new double[]{0});
        }

        Polynomial result = polynomials[0];
        for (int i = 1; i < polynomials.length; i++) {
            result = result.add(polynomials[i]);
        }

        return result;
    }

    // Перевизначений метод toString для зручного виводу
    @Override
    public String toString() {
        return "PolynomialArray{" +
                "polynomials=" + Arrays.toString(polynomials) +
                '}';
    }

    public static void main(String[] args) {
        Polynomial poly1 = new Polynomial(new double[]{1, 2, 3});  // 1 + 2x + 3x^2
        Polynomial poly2 = new Polynomial(new double[]{0, 1, -1}); // x - x^2
        Polynomial poly3 = new Polynomial(new double[]{2, -1});    // 2 - x

        PolynomialArray polynomialArray = new PolynomialArray(new Polynomial[]{poly1, poly2, poly3});

        System.out.println("Polynomials:");
        System.out.println("Poly1: " + poly1);
        System.out.println("Poly2: " + poly2);
        System.out.println("Poly3: " + poly3);

        System.out.println("\nSum of Polynomials in the Array:");
        System.out.println(polynomialArray.sum());
    }
}
