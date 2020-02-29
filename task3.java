class Task3 { 
	void merge(int arr[], int l, int m, int r){ 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		for (int i=0; i<n1; ++i){ 
			L[i] = arr[l + i];
		} 
		for (int j=0; j<n2; ++j){ 
			R[j] = arr[m + 1+ j];
		} 

		int i = 0, j = 0; 

		int k = l; 
		while (i < n1 && j < n2){ 
			if (L[i] <= R[j]){ 
				arr[k] = L[i]; 
				i++; 
			}else{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		while (i < n1){ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		while (j < n2){ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	void mergesort(int arr[], int l, int r){ 
		if (l < r){ 
			int m = (l+r)/2; 

			mergesort(arr, l, m); 
			mergesort(arr , m+1, r); 

			merge(arr, l, m, r); 
		} 
	} 

	void insertionsort(int arr[]){ 
        int n = arr.length; 
        for (int i = 1; i < n; ++i){ 
            int key = arr[i]; 
            int j = i - 1; 
 
            while (j >= 0 && arr[j] > key){ 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 

	static void printArray(int arr[]){ 
		int n = arr.length; 
		for (int i=0; i<n; ++i){ 
			System.out.print(arr[i] + " ");
		} 
		System.out.println(); 
	} 

	void sort(int arr[],String flag){

		if(flag.equals("insert")){
			mergesort(arr, 0, arr.length-1);	
		}else if(flag.equals("merge")){
			insertionsort(arr);
		}
		
		printArray(arr);
	}

	public static void main(String args[]){ 
		int arr1[] = {13,17,8,19,2,5}; 
		int arr2[] = {12,7,3,5,17,15};

		Task3 ob1 = new Task3();
		Task3 ob2 = new Task3(); 
		
		ob1.sort(arr1,"insert"); 
		ob2.sort(arr2,"merge");    
	} 
} 