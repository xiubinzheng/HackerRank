package com.hakerrank;

/**
 * @author Anatoly Chernysh
 */
public class CollinearPoints {

    public static class Point2D {

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Point2D{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Point2D a1 = new Point2D(0, 0);
        Point2D a2 = new Point2D(1, 1);
        Point2D a3 = new Point2D(2, 2);
        Point2D a4 = new Point2D(3, 3);
        Point2D a5 = new Point2D(3, 2);
        Point2D a6 = new Point2D(4, 2);
        Point2D a7 = new Point2D(5, 1);

        System.out.println(calculateCollinearPoints(new Point2D[] {a1, a2, a3, a4, a5, a6, a7}));
    }

    public static int calculateCollinearPoints(Point2D []points) {
        int count = 0;
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (isCollinearPoints(points[i], points[j], points[k])) {
                        System.out.println("(" + points[i] + ")" + "(" + points[j] + ")" + "(" + points[k] + ")");
                        count++;
                    }
                }
            }
        }

        return count / 3;
    }

    public static boolean isCollinearPoints(Point2D p1, Point2D p2, Point2D p3) {
        return (p1.y - p2.y) * (p1.x - p3.x) == (p1.y - p3.y) * (p1.x - p2.x);
    }
}
