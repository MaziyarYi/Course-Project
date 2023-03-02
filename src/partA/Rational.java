package partA;

import java.text.NumberFormat;

public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {

        if (denominator == 0) {
            throw new ArithmeticException("Denominator should not be zero");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        simplifyRational();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplifyRational();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        simplifyRational();
    }

    private void simplifyRational() {
        int gcf = greatestCommonFactor(numerator, denominator);
        numerator = numerator / gcf;
        denominator = denominator / gcf;
    }

    private int greatestCommonFactor(int num, int den) {
        if (num < 0) num = -num;
        if (den < 0) den = -den;
        if (den == 0) return num;
        else return greatestCommonFactor(den, num % den);
    }

    @Override
    public String toString() {
        if (denominator == 1) return numerator + "";
        else return numerator + "/" + denominator;
    }

    public String floatingString(int maxPrecisionDigits){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(maxPrecisionDigits);
        return nf.format((double) numerator / denominator);
    }
}
