package edu.century.pa6;

public class LabeledGraph extends Graph {
	//Private instance variables
	private String [][] edgeArray;
	//Constructor
	public LabeledGraph(int n) {
		super(n);
		edgeArray = new String[n][n];
	}

	//Getter method for edgeLabel
	public String getEdgeLabel(int i, int j)
	{
		return edgeArray[i][j];
	}

	//Overridden method from Graph class. Additional parameter String edgeLabel
	public void addEdge(int source, int target, String edgeLabel)
	{
	      super.addEdge(source, target);
	      edgeArray[source][target] = edgeLabel;
	}

	//Method for creating a label for each edge and printing it out
	public void setEdgeLabel(int i, int j) {
		if (this.isEdge(i, j) == true) {
			System.out.println("Edge: Vertex " + i + " to vertex " + j + ". Name of edge: " + this.getEdgeLabel(i,j));
		}
	}

	//Method for printing out the vertices of the graph
	public  void printVertices(int numberOfVertices) {
		System.out.println("Printing out the vertices of the graph");
		System.out.println("======================================");
		for (int i = 0; i < numberOfVertices; i++) {
			System.out.println("Vertex: " + i);
		}

	}

	//Method for printing out the edges of the graph by calling setEdgeLabel
	public  void printEdges(int numberOfVertices) {
		System.out.println("\nPrinting out the edges of the graph in correct direction");
		System.out.println("========================================================");
		for (int i = 0; i < numberOfVertices; i++) {
			for (int j = 0; j < numberOfVertices; j++) {
				setEdgeLabel(i, j);
			}
		}
	}

	//Main method
	public static void main(String[] args) {
		int numberOfVertices = 5;
		//Create instance of Graph class
		LabeledGraph graph = new LabeledGraph(numberOfVertices);
		//Adding vertices to Graph
		graph.setLabel(0, "Zero");
		graph.setLabel(1, "One");
		graph.setLabel(2, "Two");
		graph.setLabel(3, "Three");
		graph.setLabel(4, "Four");

		//Adding edges to the Graph
		graph.addEdge(0, 1, "0to1");
		graph.addEdge(1, 2, "1to2");
		graph.addEdge(1, 4, "1to4");
		graph.addEdge(2, 3, "2to3");
		graph.addEdge(3, 4, "3to4");
		graph.addEdge(4, 2, "4to2");

		//Static method calls for printing out basic Graph structure
		graph.printVertices(numberOfVertices);
		graph.printEdges(numberOfVertices);
	}

}
