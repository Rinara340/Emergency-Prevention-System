package Test;

public class EmergecySystem {
    public static void main(String[] args) {
        int m = 0, n = 0;//Размеры матрицы
        float FILL_FACTOR = 0;
        if (args.length > 0) { //Получение входных данных
            try {
                m = Integer.parseInt(args[0]);
                n = Integer.parseInt(args[1]);
                FILL_FACTOR = Float.parseFloat(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Bad argument");
                System.exit(1);
            }
        }

        boolean[][] field = new boolean[m][n];//Заполнение матрицы
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                field [i][j] = Math.random() < FILL_FACTOR;
            }
        }

        for (int i = 0; i <= n; i++){
            System.out.print(" " + i);
        }
        System.out.println("");

        int peopleCount = 0;
        for (int i = 0; i < m; i++){//Вывод матрицы и подсчет количества Х
            if(i < 9) System.out.print(" " + (i + 1) + " ");
            else System.out.print(i + 1 + " ");

            for (int j = 0; j < n; j++){
                if (field [i][j]) {
                    System.out.print("X ");
                    peopleCount++;
                }
                else System.out.print("- ");
            }
            System.out.println("");
        }

        int[][] people = new int[2][peopleCount];//Массив из Х
        int currentHuman = 0;
        for (int i = 0; i < m; i++){//Его заполнение
            for (int j = 0; j < n; j++){
                if (field [i][j]) {
                    people[0][currentHuman] = i;
                    people[1][currentHuman] = j;
                    currentHuman++;
                }
            }
        }

        int none = 0, minor = 0, normal = 0, major = 0, critical = 0;
        for (int i = 0; i < peopleCount; i++){//Подсчет скоплений людей
            if (i > 0 && people[0][i] == -1 && people[1][i] == -1){
                continue;
            }
            else {
                int cluster;
                if (i == peopleCount - 1)
                    cluster = 1;
                else
                    cluster = clusterCalculation(people, i);

                if (cluster > 13)
                    critical++;
                else if (cluster > 7)
                    major++;
                else if (cluster > 4)
                    normal++;
                else if (cluster > 2)
                    minor++;
                else none++;
            }
        }

        System.out.println("\nRisk groups report:\n----------\nNONE: " + none);//Вывод результата
        System.out.println("MINOR: " + minor);
        System.out.println("NORMAL: " + normal);
        System.out.println("MAJOR: " + major);
        System.out.println("CRITICAL: " + critical);
    }

    private static int clusterCalculation(int[][] people, int i){//Проходится по всем Х в скоплении
        int cluster = 1;
        int peopleFirst = people[0][i];
        int peopleSecond = people[1][i];
        people[0][i] = -1;
        people[1][i] = -1;
        for (int j = 1; j < people[0].length; j++){
            if (people[0][j] == -1 && people[1][j] == -1)
                continue;
            if (people[0][j] == peopleFirst && people[1][j] == peopleSecond + 1)
                cluster = cluster + clusterCalculation(people, j);
            if (people[0][j] == peopleFirst + 1 && people[1][j] == peopleSecond)
                cluster = cluster + clusterCalculation(people, j);
            if (people[0][j] == peopleFirst && people[1][j] == peopleSecond - 1)
                cluster = cluster + clusterCalculation(people, j);
            if (people[0][j] == peopleFirst - 1 && people[1][j] == peopleSecond)
                cluster = cluster + clusterCalculation(people, j);
        }
        return cluster;
    }
}
