import java.util.Comparator;
import java.io.Serializable;
class PersonComparator implements Comparator<Person>, Serializable
{
  public int compare(Person o1, Person o2)
  {
    return o1.getName().compareTo(o2.getName());
  }
  public boolean equals(Object object)
  {
    return this == object;
  }
}
