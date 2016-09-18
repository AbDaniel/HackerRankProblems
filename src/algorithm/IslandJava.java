package algorithm;

import scala.Tuple2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abdaniel on 9/10/16.
 */
public class IslandJava {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int numberOfGroups(int[][] venue) {
        boolean[][] visited = new boolean[venue.length][venue[0].length];

        int count = 0;
        for (int i = 0; i < venue.length; i++) {
            for (int j = 0; j < venue[0].length; j++) {
                if (venue[i][j] == 1 && visited[i][j]) {
                    count += 1;
                    DFS(venue, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void DFS(int[][] venue, int row, int col, boolean[][] visited) {
        List<Point> neighbours = neighbours();

        visited[row][col] = true;

        for (Point p : neighbours) {
            if(valid(p.x + row, p.y + col, venue, visited))
                DFS(venue, p.x + row, p.y + col, visited);
        }
    }

    private static boolean valid(int row, int col, int[][] venue, boolean[][] visited) {
        return (row >= 0 && col >= 0) && (row < venue.length && col < venue[0].length) &&
                (venue[row][col] == 1 && !visited[row][col]);
    }

    private static List<Point> neighbours() {
        List<Point> neighbours = new LinkedList<>();
        neighbours.add(new Point(-1, -1));
        neighbours.add(new Point(-1, -0));
        neighbours.add(new Point(-1, 1));
        neighbours.add(new Point(0, -1));
        neighbours.add(new Point(0, 1));
        neighbours.add(new Point(1, -1));
        neighbours.add(new Point(1, 0));
        neighbours.add(new Point(1, 1));
        return neighbours;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _venue_rows = 0;
        int _venue_cols = 0;
        _venue_rows = Integer.parseInt(in.nextLine().trim());
        _venue_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _venue = new int[_venue_rows][_venue_cols];
        for (int _venue_i = 0; _venue_i < _venue_rows; _venue_i++) {
            for (int _venue_j = 0; _venue_j < _venue_cols; _venue_j++) {
                _venue[_venue_i][_venue_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = numberOfGroups(_venue);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}

