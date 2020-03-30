package app;

import app.cmdLine.CmdLine;
import app.matrix.Matrix;
import app.people.Cluster;
import app.reporter.Reporter;

public class Main {
    public static void main(String[] args) {
        CmdLine cmdLine = new CmdLine();
        InputParameters inputParameters = null;

        inputParameters = cmdLine.parse(args);

        Matrix matrix = new Matrix(inputParameters);
        String reporter = Reporter.printMatrix(matrix);

        matrix.deleteFreeFields();

        Cluster clusters = new Cluster();
        clusters.clusterDetection(matrix.getFields());

        reporter += Reporter.makeReport(clusters);
        System.out.println(reporter);
    }
}
