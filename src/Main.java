import models.List;
import models.Node;
import java.util.LinkedList;

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
		
				
		
	}
}
