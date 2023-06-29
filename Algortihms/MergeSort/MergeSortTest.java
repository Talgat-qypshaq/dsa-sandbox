import java.util.*;
public class MergeSortTest
{
  public static void main(String [] args)
  {
    int peopleAmount = 3;

    Person p1 = new Person("Timur", 10);
    Person p2 = new Person("Alma", 15);
    Person p3 = new Person("Zhuma", 20);

    Person[] people = new Person[peopleAmount];
    people[0] = p1;
    people[1] = p2;
    people[2] = p3;

    System.out.println("Before Sorting by Name:");
    for(int a = 0; a < people.length; a++)
    {
      System.out.println(people[a].toString());
    }

    MergeSortClass mergeSortClass = new MergeSortClass();
    mergeSortClass.mergesort(people);

    System.out.println("After Sorting by Name:");
    for(int a = 0; a < people.length; a++)
    {
      System.out.println(people[a].toString());
    }

  }
}
