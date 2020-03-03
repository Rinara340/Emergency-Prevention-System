package app.people;

public class People {
    private int[][] peopleIndex;
    private int peopleCount;

    public People(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void determiningPositionPeople(int rowsM, int columnsN, boolean[][] field) {
        final int NUMBER_OF_INDICES = 2;
        peopleIndex = new int[NUMBER_OF_INDICES][peopleCount];
        int currentHuman = 0;
        
        for (int i = 0; i < rowsM; i++) {
            for (int j = 0; j < columnsN; j++) {
                if (field[i][j]) {
                    peopleIndex[0][currentHuman] = i;
                    peopleIndex[1][currentHuman] = j;
                    currentHuman++;
                }
            }
        }
    }

    public int[][] getPeopleIndices() {
        return peopleIndex;
    }
}
