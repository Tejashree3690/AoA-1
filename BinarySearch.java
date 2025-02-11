import java.util.Scanner;
class BinarySearch
{
  int binarySearch(int array[], int element, int low, int high) 
  {
    while (low <= high) 
    {
      int mid = low + (high - low) / 2;
      if (array[mid] == element)
        return mid;
      if (element > array[mid])
        low = mid + 1;
      else
        high = mid - 1;
    }
    return -1;
  }

  public static void main(String args[]) 
  {
    Main obj = new Main();
    int[] array = { 11, 22, 33, 44, 55, 66, 77, 88};
    int n = array.length;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter element to be searched:");
    int element = input.nextInt();
    input.close();
    int result = obj.binarySearch(array, element, 0, n - 1);
    if (result == -1)
      System.out.println("Not found");
    else
      System.out.println("Element found at index " + result);
  }
}