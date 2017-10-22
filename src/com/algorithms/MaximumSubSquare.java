package com.algorithms;

/**
 * @author Anatoly Chernysh
 */
public class MaximumSubSquare {

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        matrix[0][0] = 1; matrix[0][1] = 0; matrix[0][2] = 1;
        matrix[1][0] = 0; matrix[1][1] = 0; matrix[1][2] = 1;
        matrix[2][0] = 0; matrix[2][1] = 0; matrix[2][2] = 1;

        MaximumSubSquare maximumSubSquare = new MaximumSubSquare();
        SubSquare subSquare = maximumSubSquare.findSquare(matrix);
        System.out.println("Maximum sub square in matrix (O(n^3)): " + subSquare);
    }

    public SubSquare findSquare(int matrix[][]) {
        SquareCell  processedMatrix[][] = processSquare(matrix);
        for (int i = matrix.length;i >= 0;i--) {
            SubSquare subSquare = findSquareWithSize(processedMatrix, i);
            if (subSquare != null) {
                return subSquare;
            }
        }
        return null;
    }

    public SubSquare findSquareWithSize(SquareCell processedMatrix[][], int size) {
        int count = processedMatrix.length - size + 1;
        for (int r = 0;r < count;r++) {
            for (int c = 0;c < count;c++) {
                if (isSquare(processedMatrix, r, c, size)) {
                    return new SubSquare(r, c, size);
                }
            }
        }
        return null;
    }

    public boolean isSquare(SquareCell matrix[][], int row, int column, int size) {
        SquareCell topLeft = matrix[row][column];
        SquareCell topRight = matrix[row][column + size - 1];
        SquareCell bottomLeft = matrix[row + size - 1][column];

        if (topLeft.zerosRight < size) {
            return false;
        }
        if (topRight.zerosBellow < size) {
            return false;
        }
        if (bottomLeft.zerosRight < size) {
            return false;
        }
        return true;
    }

    public SquareCell[][] processSquare(int matrix[][]) {
        SquareCell processed[][] = new SquareCell[matrix.length][matrix.length];
        for (int i = 0;i< matrix.length;i++) {
            processed[i] = new SquareCell[matrix.length];
            for (int j = 0;j < matrix.length;j++) {
                processed[i][j] = new SquareCell();
            }
        }

        for (int r = matrix.length - 1;r >= 0;r--) {
            for (int c = matrix.length - 1;c >= 0;c--) {
                int zerosRight = 0;
                int zerosBellow = 0;
                if (matrix[r][c] == 0) {
                    zerosRight++;
                    zerosBellow++;

                    if (c + 1 < matrix.length) {
                        zerosRight += processed[r][c + 1].zerosRight;
                    }

                    if (r + 1 < matrix.length) {
                        zerosBellow += processed[r + 1][c].zerosBellow;
                    }
                }
                processed[r][c].zerosRight = zerosRight;
                processed[r][c].zerosBellow = zerosBellow;
            }
        }

        return processed;
    }

}

class SquareCell {

    public int zerosRight = 0;

    public int zerosBellow = 0;

}

class SubSquare {

    SubSquare(int row, int column, int size) {
        this.row = row;
        this.column = column;
        this.size = size;
    }

    public int row;

    public int column;

    public int size;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SubSquare{");
        sb.append("row=").append(row);
        sb.append(", column=").append(column);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}