public class SelectionSort {
    
    public static void selectionSort(int[] arr) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) 
            {
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }
            
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 5, 2, 1, 4, 3 };
        System.out.println("Before Selection sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        selectionSort(arr);
        System.out.println("After Selection sort:");
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
    }
}