import java.util.*;

class Prims{
	static int MAX = 100;
	static int INF = 999;

	void generateSpanningTree(int cost[][], int nodes){
		boolean visited[] = new boolean[nodes];
		for(int i=0; i<nodes; i++){
			visited[i] = false;
		}
		System.out.println("HERE");
		// visited[0] = true;
		int count = 0;
		while(count < nodes-1){
			int min = INF;
			int u = -1, v = -1;
			for(int i=0; i<nodes; i++){
				for(int j=0; j<nodes; j++){
					if(cost[i][j] == 0){
						cost[i][j] = INF;
					}
					if(cost[i][j] < min && !visited[i]){
						min = cost[i][j];
						v = i;
						u = j;
					}
				}
			}

			if(!visited[u] || !visited[v]){
				System.out.println( (v) +" ---- " + (u) +" \t"+ cost[v][u]);
				visited[u] = true;
				cost[u][v] = INF;
				cost[v][u] = INF;
			}
			count++;
		}
	}
}

class PrimsAlgo{

	public static void main(String arg[]){
		System.out.print("Enter number of nodes : ");
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		System.out.println("Enter cost-weight matrix :-");
		int matrix[][] = new int[nodes][nodes];
		for(int i=0; i<nodes; i++){
			for(int j=0; j<nodes; j++){
				matrix[i][j] = sc.nextInt();
			}
		}
		Prims p = new Prims();
		p.generateSpanningTree(matrix, nodes);
	}
}