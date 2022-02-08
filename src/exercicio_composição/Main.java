package exercicio_composição;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");

		System.out.print("Enter department's name: ");
		String name = sc.nextLine();
		Department dep = new Department(name);

		System.out.println("\nEnter worker data: ");
		System.out.print("Name: ");
		String nameOfWorker = sc.nextLine();
		System.out.print("Level: ");
		String l = sc.nextLine();
		WorkerLevel level = WorkerLevel.valueOf(l);
		System.out.print("Base salary: $");
		double salary = sc.nextDouble();
		Worker worker = new Worker(nameOfWorker, level, salary, dep);

		System.out.print("\nHow many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter contract #" + (i + 1) + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: $");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContracts(contract);
		}

		System.out.print("\nEnter month and year calculate income (MM/YYYY): ");
		Date dateIncome = sdf2.parse(sc.next());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateIncome);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(
				worker + "Income for 0" + month + year + ": $" + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}

}
