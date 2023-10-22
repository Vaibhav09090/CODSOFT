import java.util.Scanner;
import java.util.Arrays;
public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of subjects");
        int n = sc.nextInt();
        double  [] arr = new double[n];
        double sum =0, avg =0;
        System.out.println("enter the marks obtained out of 100");
        for (int i =0;i<n;i++)
        {
            arr[i]=sc.nextDouble();
            sum = sum + arr[i];
        }
        avg = (sum/n);
        System.out.println("total marks="+sum);
        System.out.println("average percentage ="+avg+"%");
        if (90.0<= avg)
            System.out.println("Grade = A+");
        else
        if(80.0 <= avg&&  avg< 90.0)
            System.out.println("Grade is A");
        else
        if (70<= avg && avg < 80.0)
            System.out.println("Grade is B");
        else
        if(60.0 <= avg&&  avg< 70.0)
            System.out.println("Grade is C");
        else
        if(50.0 <= avg&&  avg< 60.0)
            System.out.println("Grade is D");
        else
        if(40.0 <= avg&&  avg< 50.0)
            System.out.println("Grade is E");
        else
        if(  avg< 40.0)
            System.out.println("Grade is Fail");


    }
}

