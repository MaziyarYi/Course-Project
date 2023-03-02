package partA;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Rational first = new Rational(1,2);
        Rational second = new Rational(3,5);

        Rational sum = RationalOperationsService.sumOfRational(first,second);
        Rational subtract = RationalOperationsService.subtractOfRational(first,second);
        Rational divided = RationalOperationsService.divideOfRational(first,second);
        Rational multiplied = RationalOperationsService.multiplyOfRational(first,second);

        try {
            File file = new File("src/partA/result/Results.txt");
            file.createNewFile();
            FileWriter result = new FileWriter(file);
            result.write("a. " + first + "+" + second + "=" + sum + "\n");
            result.write("b. " + first + "-" + second + "=" + subtract + "\n");
            result.write("c. " + first + "/" + second + "=" + divided + "\n");
            result.write("d. " + first + "*" + second + "=" + multiplied + "\n");
            result.close();
            System.out.println("wrote to file successfully!!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
