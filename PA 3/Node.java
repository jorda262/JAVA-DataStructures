package edu.century.pa3;

public class Node {
	private Token data;
	private Node link;

	//Node Constructor
	public Node(Token item, Node initialLink) {
		data = item;
		link = initialLink;
	}

	//Getter method for data
	public Token getData() {
		return data;
	}

	//Getter method for link
	public Node getLink() {
		return link;
	}

	//List copy method
	public static Node listCopy(Node source) {
		Node copyHead;
		Node copyTail;

		if (source == null)
			return null;

		copyHead = new Node(source.data, null);
		copyTail = copyHead;

		while (source.link != null) {
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}

		return copyHead;
	}

	//List Length method
	public static int listLength(Node head) {
		Node cursor;
		int answer;

		answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer++;

		return answer;
	}

	//Setter method for link
	public void setLink(Node newLink) {
		link = newLink;
	}

	//Method for removing the Node after
	public void removeNodeAfter() {
		link = link.link;
	}

	//Method for adding a Node after
	public void addNodeAfter(Token item) {
		link = new Node(item, link);
	}
}
