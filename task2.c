#include<stdio.h>
#include<string.h> 
 
void insertionSort(int arr[], int n){ 
    int i, key, j; 
    for (i = 1; i < n; i++){ 
        key = arr[i]; 
        j = i - 1; 
 
        while (j >= 0 && arr[j] > key){ 
            arr[j + 1] = arr[j]; 
            j = j - 1; 
        } 
        arr[j + 1] = key; 
    } 
} 

void merge(int arr[], int l, int m, int r){ 
	int i, j, k; 
	int n1 = m - l + 1; 
	int n2 = r - m; 

	int L[n1], R[n2]; 

	for (i = 0; i < n1; i++){ 
		L[i] = arr[l + i]; 
	}
	for (j = 0; j < n2; j++){ 
		R[j] = arr[m + 1+ j];
	} 

	i = 0;  
	j = 0;  
	k = l;  
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

void mergeSort(int arr[], int l, int r){ 
	if (l < r){ 
		int m = l+(r-l)/2; 

		mergeSort(arr, l, m); 
		mergeSort(arr, m+1, r); 
		
		merge(arr, l, m, r); 
	} 
} 

void printArray(int A[], int size){  
	for (int i=0; i < size; i++){ 
		printf("%d ", A[i]); 
	}
	printf("\n"); 
}

void Sort(int arr[],char flag[]){
    int size=0,i=0;
    while(arr[i]!=NULL){
        size++;
        i++;
    }

	if(!strcmp(flag, "insert")){
		insertionSort(arr, size);
	}
	else if(!strcmp(flag, "merge")){
		mergeSort(arr, 0, size - 1);
	}
	printArray(arr,size);
}

int main(){
    int arr1[10] = {13,17,8,19,2,5};
	Sort(arr1,"insert");

	int arr2[10] = {12,7,3,5,17,15};
	Sort(arr2,"merge");
} 