#include <stdio.h>
#include <limits.h>

#define MAX_VERTICES 100  // Maximum number of vertices

// Function to find the vertex with the minimum distance value
int minDistance(int dist[], int sptSet[], int numVertices) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < numVertices; v++) {
        if (sptSet[v] == 0 && dist[v] < min) {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}

// Function to print the distance array
void printSolution(int dist[], int numVertices) {
    printf("Vertex\tDistance from Source\n");
    for (int i = 0; i < numVertices; i++) {
        printf("%d\t%d\n", i, dist[i]);
    }
}

// Function to implement Dijkstra's algorithm
void dijkstra(int graph[MAX_VERTICES][MAX_VERTICES], int source, int numVertices) {
    int dist[MAX_VERTICES];  // Output array for shortest distances
    int sptSet[MAX_VERTICES]; // Shortest Path Tree Set

    // Initialize distances and sptSet
    for (int i = 0; i < numVertices; i++) {
        dist[i] = INT_MAX;  // Initialize all distances as infinite
        sptSet[i] = 0;      // Initialize all vertices as not included in SPT
    }

    // Distance from source to itself is always 0
    dist[source] = 0;

    // Find the shortest path for all vertices
    for (int count = 0; count < numVertices - 1; count++) {
        // Pick the minimum distance vertex from the set of vertices not yet processed
        int u = minDistance(dist, sptSet, numVertices);
        sptSet[u] = 1;  // Mark the picked vertex as processed

        // Update dist value of the adjacent vertices of the picked vertex
        for (int v = 0; v < numVertices; v++) {
            // Update dist[v] if and only if the current distance is not in SPT,
            // and there is an edge from u to v, and the total weight of the path
            // from source to v through u is smaller than the current distance of v
            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }

    // Print the constructed distance array
    printSolution(dist, numVertices);
}

int main() {
    int numVertices;
    int graph[MAX_VERTICES][MAX_VERTICES];

    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    // Initialize the graph with 0s
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            graph[i][j] = 0;
        }
    }

    // Input the graph edges and weights
    printf("Enter the adjacency matrix (enter 0 if there is no edge):\n");
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            scanf("%d", &graph[i][j]);
        }
    }

    int source;
    printf("Enter the source vertex (0 to %d): ", numVertices - 1);
    scanf("%d", &source);

    dijkstra(graph, source, numVertices);

    return 0;
}
