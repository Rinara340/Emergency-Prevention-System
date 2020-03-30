package app.cmdLine;

import app.InputParameters;
import app.cmdLine.exceptions.ParametersException;
import org.apache.commons.cli.*;
import org.apache.commons.cli.ParseException;

public class CmdLine {
    public InputParameters parse(String[] args) {
        final String ROWS = "m";
        final String COLUMNS = "n";
        final String FILL_FACTOR = "f";

        CommandLineParser cmdLinePosixParser = new DefaultParser();
        CommandLine commandLine = null;

        try {
            commandLine = cmdLinePosixParser.parse(setOptions(), args);
        } catch (ParseException e) {
            System.out.println(Helper.getHelp());
            System.exit(1);
        }

        try {
            if (!commandLine.hasOption(ROWS)) {
                throw new ParametersException("Не указано количество строк.");
            }
            if (!commandLine.hasOption(COLUMNS)) {
                throw new ParametersException("Не указано количество столбцов.");
            }
            if (!commandLine.hasOption(FILL_FACTOR)) {
                throw new ParametersException("Не указана вероятность заполнения сектора.");
            }
        } catch (ParametersException e) {
            System.out.println(e.getMessage());
            System.out.println(Helper.getHelp());
            System.exit(1);
        }
            int rowCount = Integer.parseInt(commandLine.getOptionValue(ROWS));
            int columnCount = Integer.parseInt(commandLine.getOptionValue(COLUMNS));
            float fillFactor = Float.parseFloat(commandLine.getOptionValue(FILL_FACTOR));

            return new InputParameters(rowCount, columnCount, fillFactor);
        }

        private Options setOptions () {
            Option optionRowCount = new Option("m", "rowCount", true, "Row Count");
            Option optionColumnCount = new Option("n", "columnCount", true, "Column Count");
            Option optionFillFactor = new Option("f", "fillFactor", true, "Fill Factor");

            optionRowCount.setArgs(1);
            optionColumnCount.setArgs(1);
            optionFillFactor.setArgs(1);

            Options defaultOptions = new Options();
            defaultOptions.addOption(optionRowCount);
            defaultOptions.addOption(optionColumnCount);
            defaultOptions.addOption(optionFillFactor);

            return defaultOptions;
        }
    }
