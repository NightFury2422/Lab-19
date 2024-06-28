import java.lang.Comparable;

/**
 *
 * @author dhruv
 */
public class Main<T extends Comparable<T>> {
    T[] data;

    public Main(T[] d) {
        data = d;
    }

    public T[] mergeSort() {
        mergeSort(0, data.length - 1);

        return data;
    }
    
    public void mergeSort(int start, int end) {
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }
    
    public void merge(int start, int mid, int end) {    
        T[] left = (T[]) new Comparable[mid-start+1];
        for(int i = 0; i < left.length; i++){
            left[i] = data[start + i];
        }

        T[] right = (T[]) new Comparable[end - mid];
        for(int i = 0; i < right.length; i++){
            right[i] = data[mid+1+i];
        }

        int i = 0, j = 0, k = start;

        while(i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) <= 0){
                data[k++] = left[i++];
            }
            else{
                data[k++] = right[j++];
            }
        }

        while(i < left.length){
            data[k++] = left[i++];
        }

        while(j < right.length){
            data[k++] = right[j++];
        }
    }
    
    public T[] quickSort() {
        quickSort(0, data.length - 1);

        return data;
    }
    
    public void quickSort(int start, int end) {
        // actually perform quickSort
        if(end - start > 1){

            int pivot = partition(start, end);
            quickSort(start, pivot -1);
            quickSort(pivot + 1, end);
        }
        else{
            return;
        }
    }
    
    public int partition(int start, int end) {
        // perform the partitioning algorithm and return the pivot
        int l = start;
        int r = end;

        int mid = (start + end) / 2;
        T pivot = data[mid];

        while(true){
            while(data[l].compareTo(pivot) < 0){
                l++;
            }
            while(data[r].compareTo(pivot) > 0){
                r--;
            }
            if(l >= r){
                return r;
            }
            T temp = data[l];
            data[l] = data[r];
            data[r] = temp;
        }
        
    }
}
