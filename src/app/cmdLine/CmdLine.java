package app.cmdLine;

import app.InputParameters;
import app.cmdLine.exceptions.ParametersException;
import org.apache.commons.cli.*;

public class CmdLine {
    public InputParameters parse(String[] args) throws ParseException, ParametersException {

        CommandLineParser cmdLinePosixParser = new DefaultParser();
        CommandLine commandLine = cmdLinePosixParser.parse(setOptions(), args);

        if (!commandLine.hasOption("m")) {
            throw new ParametersException("Не указано количество строк.");
        }
        if (!commandLine.hasOption("n")) {
            throw new ParametersException("Не указано количество столбцов.");
        }
        if (!commandLine.hasOption("f")) {
            throw new ParametersException("Не указана вероятность заполнения сектора.");
        }

        int rowCount = Integer.parseInt(commandLine.getOptionValue("m"));
        int columnCount = Integer.parseInt(commandLine.getOptionValue("n"));
        float fillFactor = Float.parseFloat(commandLine.getOptionValue("f"));

        return new InputParameters(rowCount, columnCount, fillFactor);
    }

    private Options setOptions() {
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

    public String getHelp() {
        return "Параметры указываются в формате:\n" +
                "-m 'Количество строк матрицы' (целое число)\n" +
                "-n 'Количество столбцов матрицы' (целое число)\n" +
                "-f 'Вероятность заполнения клетки матрицы (от 0.0 до 1.0)'\n" +
                "Пример: '-m 14 -n 9 -f 0.3'.\n";
    }
}
