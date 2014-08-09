package mingming.alg.sorting;



public class Sorting {

	public static void insertSort(int[] data)
	{
		int length = data.length;
		
		for(int j = 1; j < length; j++)
		{
			int key = data[j];
			int i = j-1;
			while(i >= 0 && data[i] > key)
			{
				data[i+1] = data[i];
				i--;
			}
			data[i+1] = key;
		}
	}
	
	
	public static void mergeSort(int[] data)
	{
		mergeSort(data, 0, data.length-1);
	}
	
	public static void mergeSort(int[] data, int p, int q)
	{
		if(p < q)
		{
			int r = (p+q)/2;			
			mergeSort(data, p, r);
			mergeSort(data, r+1, q);
			merge(data, p, r, q);
		}
	}
	
	private static void merge(int[] data, int p,  int r, int q)
	{
		int[] front = new int[r-p+1];
		int[] end = new int[q-r];
		
		for(int i = p; i <= r; i++)
		{
			front[i-p] = data[i];
		}
		
		for(int i = r+1; i <= q; i++)
			end[i-r-1] = data[i];
		
		int i = p;
		int j = 0;
		int k = 0;
		
		while(i <= q)
		{
			if(j >= r-p+1)
			{
				while(k < q-r)
				{
					data[i] = end[k];
					i++;
					k++;
				}
				return;
			}
			
			if(k >= q-r)
			{
				while(j < r-p+1)
				{
					data[i] = front[j];
					i++;
					j++;
				}
				return;
			}
			
			if(front[j] < end[k])
			{
				data[i] = front[j];
				j++;
			}
			else 
			{
				data[i] = end[k];
				k++;
			}
			
			i++;
		}
		
	}
	
	
	
	public static void print(int[] data)
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < data.length-1; i++)
			sb.append(data[i] + " , ");
		
		sb.append(data[data.length-1]);
		
		System.out.println("data is: " + sb.toString());
		
	}
	

	public static void main(String[] args)
	{
		int[] data = {7, 2 , 4, 10, 6, 9, 1, 3, 8, 5};
		System.out.println("original data:");
		print(data);
		
		Sorting.insertSort(data);
		System.out.println("after inserting sort:");
		print(data);
		
		System.out.println("original data:");
		int[] data2 = {17, 12 , 14, 10, 16, 19, 11, 13, 18, 15};
		print(data2);
		Sorting.mergeSort(data2);
		System.out.println("after merging sort:");
		print(data2);
		
	}
	
}
