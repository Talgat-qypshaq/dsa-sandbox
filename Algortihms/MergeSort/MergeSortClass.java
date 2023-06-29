import java.util.*;

public class MergeSortClass
{
  public static <T extends Comparable<? super T>> void mergesort(T[] theArray)
  {
    T[] tempArray = (T[]) new Comparable<?>[theArray.length];
    //T[] tempArray = new T[theArray.length];
    mergesort(theArray, tempArray, 0, theArray.length-1);
  }

  public static <T extends Comparable<? super T>> void merge(T[] theArray, T[] tempArray, int first, int mid, int last)
  {
    int first1 = first;
    int last1 = mid;
    int first2 = mid + 1;
    int last2 = last;

    int index = first1;

    while((first1 <= last1) && (first2 <= last2))
    {
      if(theArray[first1].compareTo(theArray[first2])<0)
      {
        tempArray[index] = theArray[first1];
        first1++;
      }
      else
      {
        tempArray[index] = theArray[first2];
        first2++;
      }
      index++;
    }
    while(first1 <= last1)
    {
      tempArray[index] = theArray[first1];
      first1++;
      index++;
    }
    while(first2 <= last2)
    {
      tempArray[index] = theArray[first2];
      first2++;
      index++;
    }
    for(index = first; index <=last; ++index)
    {
      theArray[index] = tempArray[index];
    }
  }

  public static <T extends Comparable<? super T>> void mergesort(T[] theArray, T[]tempArray, int first, int last)
  {
    if(first < last)
    {
      int mid = (first + last)/2;
      mergesort(theArray, tempArray, first, mid);
      mergesort(theArray, tempArray, mid+1, last);
      merge(theArray, tempArray, first, mid, last);
    }
  }
}
