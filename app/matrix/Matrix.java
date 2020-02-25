package app.matrix;

public class Matrix {
    private boolean[][] field;
    private int rowsM, columnsN, peopleCount = 0;

    public Matrix(int rowsM, int columnsN, float fillFactor) {
        this.rowsM = rowsM;
        this.columnsN = columnsN;
        field = new boolean[this.rowsM][this.columnsN];
        for (int i = 0; i < this.rowsM; i++){
            for (int j = 0; j < this.columnsN; j++){
                field [i][j] = Math.random() < fillFactor;
            }
        }

        for (int i = 0; i < rowsM; i++) {
            for (int j = 0; j < columnsN; j++) {
                if (field[i][j]) {
                    peopleCount++;
                }
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i <= columnsN; i++){
            System.out.print(" " + i);
        }
        System.out.println("");

        final int SINGLE_DIGIT = 9;
        for (int i = 0; i < rowsM; i++){
            if(i < SINGLE_DIGIT) {
                System.out.print(" " + (i + 1) + " ");
            }
            else {
                System.out.print(i + 1 + " ");
            }

            for (int j = 0; j < columnsN; j++){
                if (field [i][j]) {
                    System.out.print("X ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public boolean[][] getField() {
        return field;
    }
}


