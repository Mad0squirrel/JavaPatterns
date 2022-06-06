package Task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Human John = new Human
                (42, "John", "Taylor", LocalDate.of(1979, 11, 04), 56);
        Human Bill = new Human
                (16, "Bill", "Harrington", LocalDate.of(2005, 07, 01), 50);
        Human Ann = new Human
                (31, "Ann", "Brown", LocalDate.of(1990, 06, 14), 53);
        Human Alex = new Human
                (27, "Alex", "Freeman", LocalDate.of(1997, 03, 17), 58);
        Human Helen = new Human
                (19, "Helen", "Smith", LocalDate.of(2003, 02, 10), 56);
        Human Kevin = new Human
                (34, "Kevin", "Freeman", LocalDate.of(1987, 06, 28), 106);
        Human Harry = new Human
                (54, "Harry", "Potter", LocalDate.of(1967, 11, 22), 113);

        List<Human> input = new ArrayList<>();
        input.add(John);
        input.add(Bill);
        input.add(Ann);
        input.add(Alex);
        input.add(Helen);
        input.add(Kevin);
        input.add(Harry);

        Stream<Human> stream = input.stream();
        stream.limit(5).filter(p -> p.getWeight() < 60)
                .sorted(Comparator.comparing(Human::getBirthDate))
                .forEach(System.out::println);
    }
}
