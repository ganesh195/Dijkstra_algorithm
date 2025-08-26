import java.util.*;


class Dijkstra {
    
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            
            if(visited[u]) continue;
            visited[u] = true;
            
            for(int v =0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDist = dist[u] + graph[u][v];
                    if(newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 0, 30, 100},
            {10,0,50,0,0},
            {0,50,0,20,10},
            {30,0,20,0,60},
            {100,0,10,60,0},
        };
        
        int graph[V][V] = {
            {0,4,0,0,0,0,0,8,0},
            {4,0,8,0,0,0,0,11,0},
            {0,8,0,7,0,4,0,0,2},
            {0,0,7,0,9,14,0,0,0},
            {0,0,0,9,0,10,0,0,0},
            {0,0,4,14,10,0,2,0,0},
            {0,4,0,0,0,0,0,8,0},
            {0,4,0,0,0,0,0,8,0},
            {0,4,0,0,0,0,0,8,0} };
    
        int source = 0;
        int[] distance = dijkstra(graph, source);
        
        System.out.println("Shortest distance from source vertex " + source + ":");
        for(int i = 0; i<distance.length; i++) {
            System.out.println("To vertex " + i + ": " + distance[i]);
        }
    }
}
