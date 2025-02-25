class QuickSortE
{
    int partition(int arr[], int low, int high) 
    {
        int pivot = arr[low];
        int k = high;
        for (int i = high; i > low; i--)
        {
            if (arr[i] > pivot)
                swap(arr, i, k--);
        }
        swap(arr, low, k);
        return k;
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void quickSort(int arr[], int low, int high) 
    {
        if (low < high) 
        {

            int idx = partition(arr, low, high);
            quickSort(arr, low, idx - 1);
            quickSort(arr, idx + 1, high);
        }
    }

    void printArray(int arr[], int size) 
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) 
    {
        int arr[] = { 44, 22, 33, 77, 11, 55, 66};
        int n = arr.length;
        QuickSortE ob = new QuickSortE();
        ob.quickSort(arr, 0, n - 1);
        System.out.println("Sorted array");
        ob.printArray(arr, n);
    }
}