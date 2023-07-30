package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Models.Entities.Department;
import Models.Entities.HourContract;
import Models.Entities.Worker;
import Models.Enums.WorkerLevel;

public class App {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter Department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter Woker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName,
									WorkerLevel.valueOf(workerLevel),
									baseSalary,
									new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int workerContracts = sc.nextInt();
		
		for (int i = 1; i <= workerContracts; i++) {
			sc.nextLine();
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dt =  sdf.parse(sc.next());
			
			System.out.print("Value Per Hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours):");
			int duration = sc.nextInt();
			
			worker.addContract(new HourContract(dt, valuePerHour, duration));
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income: (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for: " + monthAndYear +  ": " + worker.income(month, year));

		sc.close();
	}

}
