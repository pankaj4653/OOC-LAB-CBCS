import java.util.*;

class Subset{
	public void sumSubset(int a[], int v[], int sum, int current){
		if(current == a.length || sum-a[current] < 0){
			return;
		}
		if(sum - a[current] == 0){
			v[current] = 1; 
			for(int i=0; i<v.length; i++){
				if(v[i] == 1)
					System.out.print(a[i]+"\t");
			}
			v[current] = 0;
			System.out.println("");
		}else{
			sumSubset(a, v, sum, current+1);
			v[current] = 1;
			sumSubset(a, v, sum-a[current] , current+1);
			v[current] = 0;
		}		
	}
}

class SubsetSum{
	public static void main(String[] arg){
		System.out.print("\nEnter number of elements: \t");
		Scanner sc = new Scanner(System.in);
		int elements = sc.nextInt();
		System.out.println("Enter "+elements+" elements :- ");
		int elem[] = new int[elements];
		int visited[] = new int[elements];
		for(int i=0; i<elements; i++){
			elem[i] = sc.nextInt();
			visited[i] = 0;
		}
		System.out.println("Enter Sum : \t");
		int sum = sc.nextInt();
		Subset s = new Subset();
		s.sumSubset(elem, visited, sum, 0);
	}
}