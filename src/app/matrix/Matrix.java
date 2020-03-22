package app.matrix;

import app.InputParameters;

import java.util.ArrayList;
import java.util.Iterator;

public class Matrix {
    private ArrayList<Field> fields;
    private int rowsM, columnsN;

    public Matrix(InputParameters inputParameters) {
        fields = new ArrayList<>();
        this.rowsM = inputParameters.getRowCountM();
        this.columnsN = inputParameters.getColumnCountN();
        fillMatrix(inputParameters.getFillFactor());
    }

    private void fillMatrix(float fillFactor) {
        for (int row = 0; row < rowsM; row++) {
            for (int column = 0; column < columnsN; column++) {
                fields.add(new Field(row, column, Math.random() < fillFactor));
            }
        }
    }

    public String convertToStringMatrix() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= columnsN; i++) {
            stringBuilder.append(" " + i);
        }
        stringBuilder.append("\n");

        final int SINGLE_DIGIT = 9;
        for (Field field : fields) {
            if (field.getColumnN() == 0) {
                if (field.getRowM() < SINGLE_DIGIT) {
                    stringBuilder.append(" ");
                }

                stringBuilder.append(field.getRowM() + 1 + " ");
            }

            if (field.isEngaged()) {
                stringBuilder.append("X ");
            } else {
                stringBuilder.append("- ");
            }

            if (field.getColumnN() == columnsN - 1) {
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }

    public void deleteFreeFields() {
        Iterator<Field> fieldIterator = fields.iterator();
        while (fieldIterator.hasNext()) {
            Field field = fieldIterator.next();
            if (!field.isEngaged()) {
                fieldIterator.remove();
            }
        }
    }

    public ArrayList<Field> getFields() {
        return fields;
    }
}


