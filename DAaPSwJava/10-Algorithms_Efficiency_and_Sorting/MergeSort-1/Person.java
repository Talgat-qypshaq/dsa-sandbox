import java.util.Comparator;
import java.io.Serializable;
public class Person implements Serializable, Comparable<Person>
{
  String name;
  int age;

  Person(String theName, int theAge)
  {
    name = theName;
    age = theAge;
  }

  public String getName()
  {
    return name;
  }

  public int getAge()
  {
    return age;
  }

  public String toString()
  {
    System.out.println("name:"+getName()+"; age:"+getAge());
    return "";
  }

  public int compareTo(Person other)
  {
    //return this.age - other.age;
    return this.getName().compareTo(other.getName());
  }
}
