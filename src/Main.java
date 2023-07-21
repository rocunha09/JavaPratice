import models.List;
import models.MyStack;
import models.DoublyLinkedList;
import models.Node;
import models.MyQueue;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {
	
	public static void useList()
	{
		List<String> lst = new List<>();
		
		lst.add("1");
		lst.add("2");
		lst.add("3");
		lst.add("4");
		
		System.out.println(lst.get(0));
		System.out.println(lst.get(2));
		System.out.println(lst.toString());
		System.out.println("--------------------------");
		System.out.println(lst.isEmpty());
		System.out.println(lst.size());
		System.out.println("--------------------------");
		lst.removeById(2);
		System.out.println(lst.size());
		System.out.println(lst.toString());
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		//https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		LinkedList<String> java_lst = new LinkedList<>();
		
		java_lst.add("1");
		java_lst.add("2");
		java_lst.add("3");
		java_lst.add("4");
		
		System.out.println(java_lst.get(0));
		System.out.println(java_lst.get(2));
		System.out.println(java_lst.toString());
		System.out.println("--------------------------");
		System.out.println(java_lst.isEmpty());
		System.out.println(java_lst.size());
		System.out.println("--------------------------");
		java_lst.remove(2);
		System.out.println(java_lst.size());
		System.out.println(java_lst.toString());
		
	}

	public static void useDoublyList()
	{
		DoublyLinkedList<String> dLst  = new DoublyLinkedList<>();
		
		dLst.add("1");
		dLst.add("2");
		dLst.add("3");
		dLst.add("4");
		dLst.add("5");
		
		System.out.println(dLst.get(0));
		System.out.println(dLst.get(2));
		System.out.println(dLst.toString());
		System.out.println("--------------------------");
		System.out.println(dLst.isEmpty());
		System.out.println(dLst.size());
		System.out.println("--------------------------");
		dLst.removeById(2);
		System.out.println(dLst.size());
		System.out.println(dLst.toString());
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		//https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		
		//segundo a documentação o java não possui implementação padrão para lista duplamente ligada
		//depois vou pesquisar e ver o que há disponível.
		
	}

	public static void useStack() {
		MyStack<String> stk = new MyStack<>();
	
		stk.push("e");
		stk.push("d");
		stk.push("c");
		stk.push("b");
		stk.push("a");
		
		System.out.println(stk.peek());
		System.out.println(stk.toString());
		System.out.println("--------------------------");
		System.out.println(stk.isEmpty());
		System.out.println(stk.size());
		System.out.println("--------------------------");
		stk.pop();
		System.out.println(stk.isEmpty());
		System.out.println(stk.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(stk.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
		
		
		
		
		//Stack está em java.util.stack
		//https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
		Stack<String> Stk = new Stack<>();
		
		Stk.push("e");
		Stk.push("d");
		Stk.push("c");
		Stk.push("b");
		Stk.push("a");
		
		System.out.println(Stk.peek());
		System.out.println(Stk.toString());
		System.out.println("--------------------------");
		System.out.println(Stk.isEmpty());
		System.out.println(Stk.size());
		System.out.println("--------------------------");
		Stk.pop();
		System.out.println(Stk.isEmpty());
		System.out.println(Stk.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(Stk.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
		
	}
	
	public static void useQueue() {
		MyQueue<String> que = new MyQueue<>();
		
		que.enqueue("a");
		que.enqueue("b");
		que.enqueue("c");
		que.enqueue("d");
		que.enqueue("e");
		
		System.out.println(que.get());
		System.out.println(que.toString());
		System.out.println("--------------------------");
		System.out.println(que.isEmpty());
		System.out.println(que.size());
		System.out.println("--------------------------");
		que.dequeue();
		System.out.println(que.isEmpty());
		System.out.println(que.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(que.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
		
		
		Queue<String> Que = new LinkedList<>();
		
		Que.add("a");
		Que.add("b");
		Que.add("c");
		Que.add("d");
		Que.add("e");
		
		System.out.println(Que.peek()); //peek retorna sem remover
		System.out.println(Que.toString());
		System.out.println("--------------------------");
		System.out.println(Que.isEmpty());
		System.out.println(Que.size());
		System.out.println("--------------------------");
		Que.poll(); //retorna removendo
		System.out.println(Que.isEmpty());
		System.out.println(Que.size());
		
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println(Que.toString());
		System.out.println("");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("");
	}
	
	
	/**
	 * todas as estruturas de dados fazem reuso da classe Node por praticidade 
	 * de forma a não precisar criar várias models para testar.
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * usando lista encadeada criada manualmente e usando lista encadeada do pacote java.utils
		 */
		//useList();
		
		//falta fazer reapontamento do prev
		//useDoublyList();
		
		//criando e usando uma MyStack
		//useStack();
		
		//Criando e usando uma MyQueue
		//useQueue();
		
	}
}
