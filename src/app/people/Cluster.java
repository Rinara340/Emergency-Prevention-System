package app.people;

import app.matrix.Field;

import java.util.ArrayList;

public class Cluster {
    private int none = 0;
    private int minor = 0;
    private int normal = 0;
    private int major = 0;
    private int critical = 0;

    public void clusterDetection(ArrayList<Field> fields) {
        final int MAXIMUM_NONE = 2;
        final int MAXIMUM_MINOR = 4;
        final int MAXIMUM_NORMAL = 7;
        final int MAXIMUM_MAJOR = 13;

        for (Field field : fields) {
            if (field.isChecked()) {
                continue;
            }

            int clusterSize = clusterCalculation(field, fields);

            if (clusterSize > MAXIMUM_MAJOR) {
                critical++;
            } else if (clusterSize > MAXIMUM_NORMAL) {
                major++;
            } else if (clusterSize > MAXIMUM_MINOR) {
                normal++;
            } else if (clusterSize > MAXIMUM_NONE) {
                minor++;
            } else {
                none++;
            }
        }
    }

    private int clusterCalculation(Field field, ArrayList<Field> fields) {
        int clusterSize = 1;

        field.setChecked();
        for (Field comparedField : fields) {
            if (comparedField.isChecked()) {
                continue;
            }

            if (isPartOfCluster(field, comparedField)) {
                clusterSize = clusterSize + clusterCalculation(comparedField, fields);
            }
        }

        return clusterSize;
    }

    private boolean isPartOfCluster(Field field, Field comparedField) {
        if (field.getRowM() == comparedField.getRowM() && (field.getColumnN() == comparedField.getColumnN() + 1 || field.getColumnN() == comparedField.getColumnN() - 1)) {
            return true;
        }

        if ((field.getRowM() == comparedField.getRowM() + 1 || field.getRowM() == comparedField.getRowM() - 1) && field.getColumnN() == comparedField.getColumnN()) {
            return true;
        }

        return false;
    }

    public String convertToStringCluster() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nRisk groups report:\n----------\nNONE: " + none + "\n");//Вывод результата
        stringBuilder.append("MINOR: " + minor + "\n");
        stringBuilder.append("NORMAL: " + normal + "\n");
        stringBuilder.append("MAJOR: " + major + "\n");
        stringBuilder.append("CRITICAL: " + critical + "\n");

        return stringBuilder.toString();
    }
}
