package app.reporter;

import app.matrix.Matrix;
import app.people.Cluster;

public class Reporter {
    public static String printMatrix(Matrix matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matrix.convertToStringMatrix());
        return stringBuilder.toString();
    }

    public static String makeReport(Cluster cluster) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cluster.convertToStringCluster());
        return stringBuilder.toString();
    }
}
