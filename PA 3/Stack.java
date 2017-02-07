package edu.century.pa3;

import java.util.EmptyStackException;

public class Stack implements Cloneable {
	private Node top;

	// Stack constructor
	public Stack() {
		top = null;
	}

	// Stack clone method
	public Stack clone() {
		Stack answer;

		try {
			answer = (Stack) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("This class does not implement Cloneable.");
		}

		answer.top = (Node) Node.listCopy(top);
		return answer;
	}

	// Method for testing if stack is empty or not
	public boolean isEmpty() {
		return (top == null);
	}

	// Peek method
	public Token peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}

	// Pop method
	public Token pop() {
		Token answer;

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		answer = top.getData();
		top = top.getLink();
		return answer;
	}

	// Push method
	public void push(Token array) {
		top = new Node(array, top);
	}

	// Size method
	public int size() {
		return Node.listLength(top);
	}
}
