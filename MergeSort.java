public class MergeSort {
    private char[] A;
    private char[] helper;

    private int len;

    public String sort(String s) {
        this.A = s.toCharArray();
        len = s.length();
        this.helper = new char[len];
        mergesort(0, len - 1);
        return String.valueOf(A);
    }

    private void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        int i=low;
        int j=middle+1;
        for(int k=low;k<=high;k++){
          helper[k]=A[k];
        }

        for(int k=low;k<=high;k++){
          if(i>middle){
            A[k]=helper[j];
            j++;
          }
          else if(j>high){
            A[k]=helper[i];
            i++;
          }
          else if(helper[j]<helper[i]){
            A[k]=helper[j];
            j++;
          }
          else{
            A[k]=helper[i];
            i++;
          }
        }
    }
}
