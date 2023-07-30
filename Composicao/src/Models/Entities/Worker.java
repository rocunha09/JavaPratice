package Models.Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Models.Enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalaty;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {}

	public Worker(String name, WorkerLevel level, Double baseSalaty, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalaty = baseSalaty;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalaty() {
		return baseSalaty;
	}

	public void setBaseSalaty(Double baseSalaty) {
		this.baseSalaty = baseSalaty;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int month, int year) {
		double sum = this.baseSalaty;
		Calendar cal = Calendar.getInstance();
		
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_month = 1 + cal.get(Calendar.MONTH);
			int c_year = cal.get(Calendar.YEAR);
			
			if (c_month == month && c_year == year) {
				sum += c.totalValue();
			}
		}
		
		return sum;
	}
}
