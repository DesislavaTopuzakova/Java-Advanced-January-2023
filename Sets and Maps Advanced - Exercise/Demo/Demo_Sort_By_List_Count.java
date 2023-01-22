package SetasAndMaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Demo_Sort_By_List_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ученик -> брой на оценки
        Map<String, List<Double>> studentsGrade = new HashMap<>();

        //Първи случай -> descending order на брой оценки
        //първи запис: ученик с най-голям брой оценки
        //Пешо: {5.4, 3.5, 3.6}
        //Иван: {5.5, 4.8, 3.4, 3.5, 2.4}
        //Петя: {4.6, 3.4}
        //след сортировка: Иван -> Пешо -> Петя
        studentsGrade.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size());


        // Втори случай -> ascending order спрямо бройна оценките
        // първи запис: ученик с най-малък брой оценки
        //  Пешо: {5.4, 3.5, 3.6}
        //  Иван: {5.5, 4.8, 3.4, 3.5, 2.4}
        //  Петя: {4.6, 3.4}
        //  след сортировка: Петя -> Пешо -> Иван
                studentsGrade.entrySet().stream()
                        .sorted((s1, s2) -> s1.getValue().size() - s2.getValue().size());

        //sorted -> размества записи на базата на цяло число, което се получава при сравнение
        //sorted -> > 0 -> разменя записите
        //sorted -> <= 0 -> не разменя записите

        //СТЪПКИ НА СОРТИРОВКАТА
        //  Пешо: {5.4, 3.5, 3.6}
        //  Иван: {5.5, 4.8, 3.4, 3.5, 2.4}
        //  Петя: {4.6, 3.4}

        //1. s1 = Пешо(key): {5.4, 3.5, 3.6}(value)      s2 = Иван(key): {5.5, 4.8, 3.4, 3.5, 2.4}(value)
        //Пешо -> Иван -> Петя

        //2. s1 = Иван(key): {5.5, 4.8, 3.4, 3.5, 2.4}(value)      s2 = Петя(key): {4.6, 3.4}(value)
        //Пешо -> Петя -> Иван

        //3. s1 = Пешо(key): {5.4, 3.5, 3.6}(value)      s2 = Петя(key): {4.6, 3.4}(value)
        //Петя -> Пешо -> Иван

    }
}
