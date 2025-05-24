import java.util.Scanner;

class zeroException extends Exception {
    public zeroException(String s) {
        super(s);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers for division : ");
        int num1=1, num2=1;
        try {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            if (num2 > num1) {
                throw new zeroException("2nd number shouldn't be greater than 1st number as the result is 'int' type.");
            }
            System.out.println(num1+"/"+num2+" = "+num1/num2);
        } catch (ArithmeticException e) {
            System.out.println("["+num1+"/"+num2+"]\t"+"Division by zero is not allowed. "+e);
        } catch (zeroException e) {
            System.out.println("["+num1+"/"+num2+"]\t"+e);
        } catch (Exception e) {
            System.out.println("["+num1+"/"+num2+"]\t"+"Any other error has occurred. "+e);
        } finally {
            sc.close();
        }
        System.out.println("Outside try-catch block.");
    }
}
