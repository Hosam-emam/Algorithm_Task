import java.util.Scanner;

public class Main {

    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static int Dominator(int[] arr,int size){
        int[] index = arr.clone();
        sort(index,0,size-1);
        int cnt = 1;
        int domin = -5;
        for(int i =0; i < size-1; i++){
            if(index[i] == index[i+1]){
                cnt++;
                if(cnt > size/2){
                    domin = index[i];
                    break;
                }
            }else{
                cnt = 1;
            }
        }
        if(domin == -5){
            return -1;
        }
        for(int j = 0; j < size; j++){
            if(arr[j] == domin){
                System.out.print(j + " ");
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = Integer.parseInt(sc.nextLine());
        int arr[]= new int[size];

        System.out.println("Enter the elements.");
        for(int i = 0; i < size; i++){
            arr[i] =sc.nextInt();
        }
        if(Dominator(arr,size) == -1){
            System.out.println(-1);
        }

    }
}