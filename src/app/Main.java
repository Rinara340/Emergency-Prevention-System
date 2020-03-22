package app;

import app.cmdLine.CmdLine;
import app.cmdLine.Helper;
import app.cmdLine.exceptions.ParametersException;
import app.matrix.Matrix;
import app.people.Cluster;
import app.reporter.Reporter;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        CmdLine cmdLine = new CmdLine();
        InputParameters inputParameters = null;
        try {
            inputParameters = cmdLine.parse(args);
        } catch (ParseException | ParametersException e) {
            System.out.println(e.getMessage());
            System.out.println(Helper.getHelp());
            System.exit(1);
        } catch (Exception e) {
            System.out.println(Helper.getHelp());
            System.exit(1);
        }

        Matrix matrix = new Matrix(inputParameters);
        String reporter = Reporter.printMatrix(matrix);

        matrix.deleteFreeFields();

        Cluster clusters = new Cluster();
        clusters.clusterDetection(matrix.getFields());

        reporter += Reporter.makeReport(clusters);
        System.out.println(reporter);
    }
}
