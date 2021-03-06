# Emergency-Prevention-System
Параметры указываются в формате: -m 'Количество строк матрицы' -n 'Количество столбцов матрицы' -f 'Вероятность заполнения клетки матрицы (от 0.0 до 1.0)'
Пример: -m 14 -n 9 -f 0.3

# Концептуальная модель
Данное приложение должно имитировать работу системы предупреждения чрезвычайных ситуаций, отлавливая и передавая оператору отчет о скоплении групп людей в секторе наблюдения.
Сектор наблюдения представляет собой прямоугольное поле в виде матрицы клеток фиксированного размера M x N (передаются в качестве параметров командной строки). Клетка имеет два состояния: занято (“|X|”) и свободно (“ - ”).

К одной группе относятся все клетки, расположенные в непосредственной близости друг от друга (слева, справа, снизу сверху, но не по диагонали).

Заполнение поля происходит с некоторой вероятностью “FILL_FACTOR” (от 0.0 – поле пустое, до 1.0 – поле полностью заполнено). Значение задается в качестве параметра командной строки. Данный функционал следует реализовать, используя random из класса java.lang.Math.

Система должна ранжировать группы по 5 степеням риска. Степень риска определяет минимальное количество людей, входящих в группу и может иметь следующие наименования: CRITICAL, MAJOR, NORMAL, MINOR, NONE.

Каждой группе должна соответствовать определенная степень риска:

NONE : 1 - 2
MINOR : 3 - 4
NORMAL : 5 - 7
MAJOR : 8 - 13
CRITICAL : свыше 13
В итоге приложение должно выводить:

Размер матрицы ***M x N***.
Вероятность заполнения поля **FILL_FACTOR**.
Пять степеней риска в формате **'name'**=**'max count'**.
Заполненное поле и кол-во групп для каждой степени риска.
