package app.people;

public class Cluster {
    private int none = 0, minor = 0, normal = 0, major = 0, critical = 0;

    public void clusterDetection(int peopleCount, int[][] peopleIndex) {
        for (int i = 0; i < peopleCount; i++){
            if (i > 0 && peopleIndex[0][i] == -1 && peopleIndex[1][i] == -1){
                continue;
            }
            else {
                int cluster;
                if (i == peopleCount - 1)
                    cluster = 1;
                else
                    cluster = clusterCalculation(peopleIndex, i);

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
    }

    private int clusterCalculation(int[][] people, int i){//Проходится по всем Х в скоплении
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

    public void printCluster() {
        System.out.println("\nRisk groups report:\n----------\nNONE: " + none);//Вывод результата
        System.out.println("MINOR: " + minor);
        System.out.println("NORMAL: " + normal);
        System.out.println("MAJOR: " + major);
        System.out.println("CRITICAL: " + critical);
    }
}
