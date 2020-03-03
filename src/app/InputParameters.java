package app;

public class InputParameters {
    private final int rowCountM;
    private final int columnCountN;
    private final float fillFactor;

    public InputParameters(int rowCountM, int columnCountN, float fillFactor) {
        this.rowCountM = rowCountM;
        this.columnCountN = columnCountN;
        this.fillFactor = fillFactor;
    }

    public int getRowCountM() {
        return rowCountM;
    }

    public int getColumnCountN() {
        return columnCountN;
    }

    public float getFillFactor() {
        return fillFactor;
    }
}
