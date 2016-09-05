package functionalprog;

import java.util.Scanner;

/**
 * Created by abdaniel on 9/4/16.
 */
public class MthElementJava                      {

    public static void main(String[] args)  {
        Scanner inpObj = new Scanner(System.in);
        int n = Integer.valueOf(inpObj.nextLine());
        String[] nos = inpObj.nextLine().split(" ");
        if(nos.length < n)
            System.out.println("NIL");
        else
            System.out.println(nos[nos.length - n]);
    }
}
