package partA;

public class RationalOperationsService {

    private RationalOperationsService(){
    }

    public static Rational sumOfRational(Rational first , Rational second){
        int num = (first.getNumerator() * second.getDenominator()) + (second.getNumerator() * first.getDenominator());
        int den = first.getDenominator() * second.getDenominator();
        return new Rational(num , den);
    }

    public static Rational subtractOfRational(Rational first , Rational second){
        int num = (first.getNumerator() * second.getDenominator()) - (second.getNumerator() * first.getDenominator());
        int den = first.getDenominator() * second.getDenominator();
        return new Rational(num , den);
    }

    public static Rational multiplyOfRational(Rational first , Rational second){
        int num = first.getNumerator() * second.getNumerator();
        int den = first.getDenominator() * second.getDenominator();
        return new Rational(num , den);
    }

    public static Rational divideOfRational(Rational first , Rational second){
        int num = first.getNumerator() * second.getDenominator();
        int den = first.getDenominator() * second.getNumerator();
        return new Rational(num , den);
    }

}
