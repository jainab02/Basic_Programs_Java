public class SelectionSort {
    /**
     * @param arr
     */
    public  void selectionSort(int arr[]){
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int key = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[key]){  
                    key = j;//searching for lowest index  
                }  
            }  
            //swap with smallest one
            int smallerNumber = arr[key];   
            arr[key] = arr[i];  
            arr[i] = smallerNumber;  
        } 
         //printing array
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i] + "\n") ;
    }

    }
    
}
