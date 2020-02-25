package app;

import app.cmdLine.CmdLine;
import app.cmdLine.exceptions.ParametersException;
import app.matrix.Matrix;
import app.people.Cluster;
import app.people.People;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        CmdLine cmdLine = new CmdLine();
        InputParameters inputParameters = null;
        try {
            inputParameters = cmdLine.parse(args);
        }
        catch (ParseException | ParametersException e) {
            System.out.println(e.getMessage());
            System.out.println(cmdLine.getHelp());
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println(cmdLine.getHelp());
            System.exit(1);
        }

        Matrix matrix = new Matrix(inputParameters.getRowCountM(), inputParameters.getColumnCountN(), inputParameters.getFillFactor());
        matrix.printMatrix();

        People people = new People(matrix.getPeopleCount());
        people.determiningPositionPeople(inputParameters.getRowCountM(), inputParameters.getColumnCountN(), matrix.getField());

        Cluster clusters = new Cluster();
        clusters.clusterDetection(matrix.getPeopleCount(), people.getPeopleIndices());
        clusters.printCluster();
    }
}
