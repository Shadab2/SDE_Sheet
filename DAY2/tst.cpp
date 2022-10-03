#include <bits/stdc++.h>
using namespace std;

void solverAndHelper(vector<int> graph[], int u, bool visited[],
			int disconnection[], int l[], int& timeVisited, int par,
			bool isArticulate[]){
    int x = 0;
	int orphans = 0;
	visited[u] = true;
	disconnection[u] = l[u] = ++timeVisited;
    int y = 0;
	for (auto v : graph[u]) {
		if (!visited[v]) {
			orphans++;
			solverAndHelper(graph, v, visited, disconnection, l, timeVisited, u, isArticulate);
			l[u] = min(l[u], l[v]);
			if (par != -1 && l[v] >= disconnection[u])
				isArticulate[u] = true;
		}
		else if (v != par)
			l[u] = min(l[u], disconnection[v]);
	}
	if (par == -1 && orphans > 1)
		isArticulate[u] = true;
}

int Articulate(vector<int> graph[], int V)
{
	int disconnection[V] = { 0 };
	int l[V];
	bool visited[V] = { false };
	bool isArticulate[V] = { false };
	int timeVisited = 0, par = -1;
	for (int u = 0; u < V; u++)
		if (!visited[u])
			solverAndHelper(graph, u, visited, disconnection, l,
				timeVisited, par, isArticulate);

	int count = 0;
	for (int u = 0; u < V; u++)
		if (isArticulate[u] ) count++;
	return count;
}
void addEdge(vector<int> graph[], int u, int v)
{
	graph[u].push_back(v);
	graph[v].push_back(u);
}

int main()
{
	int n,m;
	cin>>n>>m;
	vector<int> g[n];
	int a,b;
	for(int i = 0;i<m;i++){
	    cin>>a>>b;
	    addEdge(g,a-1,b-1);
	}
	cout<<Articulate(g, n)<<endl;
	
	return 0;
}
