package app.matrix;

public class Field {
    private int rowM;
    private int columnN;
    private boolean engaged;
    private boolean checked;

    public Field(int rowM, int columnN, boolean engaged) {
        this.rowM = rowM;
        this.columnN = columnN;
        this.engaged = engaged;
        checked = false;
    }

    public void setChecked() {
        checked = true;
    }

    public boolean isEngaged() {
        return engaged;
    }

    public int getRowM() {
        return rowM;
    }

    public int getColumnN() {
        return columnN;
    }

    public boolean isChecked() {
        return checked;
    }
}
