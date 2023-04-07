import java.util.Comparator;


public class NameCompare implements Comparator<Person>{

    public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }

    
}
