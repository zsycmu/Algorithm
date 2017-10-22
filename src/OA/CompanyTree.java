package OA;

import java.util.ArrayList;
import java.util.List;


class Employee {
	int id;
	String name;
	List<Employee> reports;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		reports = new ArrayList<Employee>();
	}

}
public class CompanyTree {
	public static Employee findCommonManager(Employee ceo, Employee a, Employee b) {
		if (ceo == null || a == null || b == null || a == ceo || b == ceo) {
			return null;
		}
		
		List<Employee> aReportToList = getReportToList(ceo, a);
		List<Employee> bReportToList = getReportToList(ceo, b);
		
		if (aReportToList == null || aReportToList.size() == 0 || bReportToList == null || bReportToList.size() == 0) {
			return null;
		}
		
		int index = 0;
		Employee commonManager = null;
		
		while (index < aReportToList.size() && index < bReportToList.size()) {
			if (aReportToList.get(index) != bReportToList.get(index)) {
				break;
			}
			commonManager = aReportToList.get(index);
			index++;
		}
		
		if (commonManager != null && commonManager.id == ceo.id) {
			return null;
		}
		
		return commonManager;
	}
	
	private static List<Employee> getReportToList(Employee ceo, Employee worker) {
		List<Employee> list = new ArrayList<Employee>();

		if (ceo == null || worker == null) {
			return list;
		}
		
		helper(list, new ArrayList<Employee>(), ceo, worker);
		return list;

		}
	
	public static void helper(List<Employee> result, List<Employee> tempList, Employee ceo, Employee worker) {
		if (ceo.id == worker.id) {
			tempList.add(ceo);
			
			for (int i = 0; i < tempList.size(); i++) {
				result.add(tempList.get(i));
			}
			
			return;
		}

		List<Employee> reports = ceo.reports;
		
		for (int i = 0; i < reports.size(); i++) {
			tempList.add(ceo);
			helper(result, tempList, reports.get(i), worker);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
			Employee a = new Employee(1, "a");
			Employee b = new Employee(2, "b");	
			Employee c = new Employee(3, "c");
			Employee d = new Employee(4, "d");	
			Employee e = new Employee(5, "e");	
			Employee f = new Employee(6, "f");	
			Employee g = new Employee(7, "g");	
			Employee h = new Employee(8, "h");
			Employee i = new Employee(9, "i");	
			Employee j = new Employee(10, "j");	
			Employee k = new Employee(11, "k");	
			Employee l = new Employee(12, "l");	
			
			a.reports.add(b);	
			a.reports.add(c);	
			b.reports.add(d);	
			d.reports.add(f);	
			b.reports.add(e);		
			a.reports.add(g);		
			e.reports.add(h);	
			h.reports.add(i);
		
			Employee result = findCommonManager(a, f, h);	
			System.out.println(result.name);
		}
}
