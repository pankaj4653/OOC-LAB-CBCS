import java.util.*;

class HamiltonianPaths{
	public void findAllPaths(int cost[][], int visited[], int currentNode, int pos){
		if(pos == visited.length){
			if(cost[currentNode][0] == 1){
				for(int i=0; i<visited.length; i++){
					System.out.print(visited[i] + "\t");
				}
				System.out.println("1");
			}
			return;
		}
		for(int i=0; i<visited.length; i++){
			if(cost[currentNode][i] == 1 && isVisited(visited, i+1) ){
				visited[pos] = i+1;
				findAllPaths(cost, visited, i, pos+1);
				visited[pos] = 0;
			}
		}
	}

	private boolean isVisited(int visited[], int val){
		for(int i=0; i<visited.length; i++){
			if(visited[i] == val) return false;
		}
		return true;
	}
}

class Hamiltonian{
	public static void main(String arg[]){
		System.out.print("Enter number of nodes:\t");
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		System.out.println("Enter the adjacency matrix :-");
		int matrix[][] = new int[nodes][nodes];
		for(int i=0; i<nodes; i++){
			for(int j=0; j<nodes; j++){
				matrix[i][j] = sc.nextInt();
			}
		}
		int visited[] = new int[nodes];
		for(int i=0; i<nodes; i++)
			visited[i] = 0;

		visited[0] = 1;
		HamiltonianPaths hp = new HamiltonianPaths();
		hp.findAllPaths(matrix, visited, 0, 1);
	}
}