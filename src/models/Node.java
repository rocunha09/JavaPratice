package models;

public class Node<T> {
	private T content;
	private Node next;
	
	public Node(T content) {
		super();
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	public Node getNext() {
		return next;
	}
	
	public void setNext (Node node) {
		this.next = node;
	}

	/*@Override
	public String toString() {
		return "Node [content=" + content + ", next=" + next + "]";
	}*/
	
}
