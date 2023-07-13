import models.List;

public class Main {

	public static void main(String[] args) {

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
	}

}
