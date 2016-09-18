package algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by abdaniel on 9/10/16.
 */
public class SecretLetters {


    public static void main(String[] args)  {
        String msg = "this is    sparta";
            String m = java.util.Arrays.stream(msg.split(" "))
                            .map(x -> new StringBuilder(x).reverse().toString())
                            .collect(java.util.stream.Collectors.joining(" "));
    }

}
