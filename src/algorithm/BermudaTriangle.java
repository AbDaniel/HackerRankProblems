package algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by abdaniel on 9/10/16.
 */
public class BermudaTriangle {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _x1;
        _x1 = Integer.parseInt(in.nextLine().trim());

        int _y1;
        _y1 = Integer.parseInt(in.nextLine().trim());

        int _x2;
        _x2 = Integer.parseInt(in.nextLine().trim());

        int _y2;
        _y2 = Integer.parseInt(in.nextLine().trim());

        int _x3;
        _x3 = Integer.parseInt(in.nextLine().trim());

        int _y3;
        _y3 = Integer.parseInt(in.nextLine().trim());

        int _px;
        _px = Integer.parseInt(in.nextLine().trim());

        int _py;
        _py = Integer.parseInt(in.nextLine().trim());

        int _bx;
        _bx = Integer.parseInt(in.nextLine().trim());

        int _by;
        _by = Integer.parseInt(in.nextLine().trim());

        res = foundInBermudatriangle(_x1, _y1, _x2, _y2, _x3, _y3, _px, _py, _bx, _by);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    private static int foundInBermudatriangle(int x1, int y1, int x2, int y2, int x3, int y3, int px, int py, int bx, int by) {
        int areaOfTriangle = areaOfTriangle(x1, y1, x2, y2, x3, y3);
        if(areaOfTriangle == 0) return 0;
        if(isPointInTriangle(x1, y1, x2, y2, x3, y3, px, py) &&
                !isPointInTriangle(x1, y1, x2, y2, x3, y3, bx, by)) return 1;
        if(!isPointInTriangle(x1, y1, x2, y2, x3, y3, px, py) &&
                isPointInTriangle(x1, y1, x2, y2, x3, y3, bx, by)) return 2;
        if(isPointInTriangle(x1, y1, x2, y2, x3, y3, px, py) &&
                isPointInTriangle(x1, y1, x2, y2, x3, y3, bx, by)) return 3;
        return 4;
    }

    static boolean isPointInTriangle (int x1, int y1, int x2, int y2, int x3, int y3, int px, int py)
    {
        boolean one = areaOfTriangle(px, py, x1, y1, x2, y2) < 0;
        boolean two = areaOfTriangle(px, py, x2, y2, x3, y3) < 0;
        boolean three = areaOfTriangle(px, py, x3, y3, x1, y1) < 0;

        return ((one == two) && (two == three));
    }

    private static int areaOfTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
    }
}
