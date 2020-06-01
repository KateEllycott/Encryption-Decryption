import java.util.Arrays;
import java.util.Scanner;

class SelectionContext {

    private PersonSelectionAlgorithm algorithm;

    public void setAlgorithm(PersonSelectionAlgorithm algorithm) {
       this.algorithm = algorithm;
    }

    public Person[] selectPersons(Person[] persons) {
       return algorithm.select(persons);
    }
}

interface PersonSelectionAlgorithm {

    Person[] select(Person[] persons);
}

class TakePersonsWithStepAlgorithm implements PersonSelectionAlgorithm {

    private final int step;

    public TakePersonsWithStepAlgorithm(int step) {
        this.step = step;
    }

    @Override
    public Person[] select(Person[] persons) {
        Person[] selected = null;

        if(step == 1) {
            return persons;
        }
        else {
            int steps = (persons.length % step == 0) ? persons.length / step : (persons.length / step) + 1;
            selected = new Person[steps];
            int personIndex = 0;
            for(int i = 0; i < selected.length; i++) {
                selected[i] = persons[personIndex];
                personIndex += step;
            }
        }

        return selected;
    }
}


class TakeLastPersonsAlgorithm implements PersonSelectionAlgorithm {

    private final int  count;

    public TakeLastPersonsAlgorithm(int count) {
        this.count = count;
    }

    @Override
    public Person[] select(Person[] persons) {

        Person[] selected = null;

        if(count == 1) {
            selected = Arrays.copyOfRange(persons, persons.length - 1, persons.length);
        }
        else {
            int startIndex = persons.length - count;
            selected = Arrays.copyOfRange(persons, startIndex, persons.length);
        }
        return selected;
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int count = Integer.parseInt(scanner.nextLine());
        final Person[] persons = new Person[count];

        for (int i = 0; i < count; i++) {
            persons[i] = new Person(scanner.nextLine());
        }

        final String[] configs = scanner.nextLine().split("\\s+");

        final PersonSelectionAlgorithm alg = create(configs[0], Integer.parseInt(configs[1]));
        SelectionContext ctx = new SelectionContext();
        ctx.setAlgorithm(alg);

        final Person[] selected = ctx.selectPersons(persons);
        for (Person p : selected) {
            System.out.println(p.name);
        }
    }

    public static PersonSelectionAlgorithm create(String algType, int param) {
        switch (algType) {
            case "STEP": {
                return new TakePersonsWithStepAlgorithm(param);
            }
            case "LAST": {
                return new TakeLastPersonsAlgorithm(param);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}