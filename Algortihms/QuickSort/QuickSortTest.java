import java.util.*;
public class QuickSortTest
{
  public static void main(String [] args)
  {
    int peopleAmount = 8;

    Person p1 = new Person("Zibakul", 76);
    Person p2 = new Person("Aizada", 46);
    Person p3 = new Person("Aibek", 44);
    Person p4 = new Person("Saule", 44);
    Person p5 = new Person("Talgat", 34);
    Person p6 = new Person("Leila", 30);
    Person p7 = new Person("Idris", 4);
    Person p8 = new Person("Kaussar", 1);


    Person[] people = new Person[peopleAmount];
    people[0] = p1;
    people[1] = p2;
    people[2] = p3;
    people[3] = p4;
    people[4] = p5;
    people[5] = p6;
    people[6] = p7;
    people[7] = p8;

    System.out.println("Before Sorting by Name:");
    for(int a = 0; a < peopleAmount; a++)
    {
      System.out.println(people[a].toString());
    }

    QuickSortClass quickSortClass = new QuickSortClass();
    quickSortClass.quickSort(people, 0, peopleAmount-1);

    System.out.println("After Sorting by Name:");
    for(int a = 0; a < peopleAmount; a++)
    {
      System.out.println(people[a].toString());
    }

  }
}
