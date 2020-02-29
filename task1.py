class Sort:

	def __init__(self,arr,flag):
		self.list_ = arr
		self.length = len(arr)
		if flag=="merge":
			self.mergeSort_(self.list_)
		elif flag=="insert":
			self.insertionSort()

	def insertionSort(self):
		for i in range(1, self.length): 
			key = self.list_[i]  
			j = i-1
			while j >=0 and key < self.list_[j] : 
				self.list_[j+1] = self.list_[j] 
				j -= 1
			self.list_[j+1] = key		

	def mergeSort_(self,arr):
		if len(arr) >1: 
			mid = len(arr)//2
			left = arr[:mid]
			right = arr[mid:]

			self.mergeSort_(left)
			self.mergeSort_(right)
	  
			i = j = k = 0

			while i < len(left) and j < len(right): 
				if left[i] < right[j]: 
					arr[k] = left[i] 
					i+=1
				else: 
					arr[k] = right[j] 
					j+=1
				k+=1
	          
			while i < len(left): 
				arr[k] = left[i] 
				i+=1
				k+=1

			while j < len(right): 
				arr[k] = right[j] 
				j+=1
				k+=1

	def printlist(self):
		print(*self.list_)

_sort = Sort([13,17,8,19,2,5],"insert")
_sort.printlist()

_sort = Sort([12,7,3,5,17,15],"merge")
_sort.printlist()