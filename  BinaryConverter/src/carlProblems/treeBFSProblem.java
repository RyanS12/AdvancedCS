package carlProblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class treeBFSProblem {
    private static LinkedList<Integer> link[];
    private static void addEdge(int a, int b) {
    	link[a].add(b);
    	link[b].add(a);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		
		link = new LinkedList[n+5];
		for (int i = 0; i < n+5; i++) {
            link[i] = new LinkedList(); 
		}
		for(int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			addEdge(a,b);
		}
		in.close();
		
		int result = 0;
		
		boolean visited[] = new boolean[n+5];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[x1] = true;
		queue.add(x1);
		queue.add(0);
		while(queue.size() != 0) {
			x1 = queue.poll();
			if(x1 == 0){
	              result++;
	              queue.add(0);
	              if(queue.peek() == null) 
	            	  break;
	              else continue;
	        }
            //System.out.print(x1 + " ");
            Iterator<Integer> i = link[x1].listIterator(); 
            while (i.hasNext()) {
                int node = i.next(); 
                if(node == y1) {
                	System.out.println(result+1);
                	return;
                }
                if (!visited[node]) { 
                    visited[node] = true; 
                    queue.add(node);
                }
            }
            
		}
		//System.out.println(result);
		
	}

}
