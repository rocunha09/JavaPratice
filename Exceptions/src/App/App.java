package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
	
	public static void testando_excepts() {
		Scanner sc = new Scanner(System.in);
		
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			
			System.out.println(vect[position]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println(e.getCause());
			System.out.println();
			System.out.println(e.getLocalizedMessage());
			System.out.println();
			e.printStackTrace();
		}
		catch (InputMismatchException e) {
			System.out.println();
			System.out.println("input error");
		}
		finally {
			System.out.println();
			System.out.println("fim do teste, esta parte sempre será executada");
		}
		sc.close();
	}
	
	public static void lendoArquivo()
	{
		String truePath = "R://lorem-ipsun.txt";
		String falsePath = "R://lorem-ipsum.txt";
		
		File file = new File(falsePath);
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine())	{
				System.out.println(sc.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("erro ao abrir o arquivo... " + e.getMessage());
		} finally {
			if (sc != null)
				sc.close();
		}
	}
	
	public static void except_personalizada_solut_1() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Room Number: ");
		int num = sc.nextInt();
		
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		
		if (!checkOut.after(checkIn)) {
			System.out.println("error reservation: check-ou date must be after check-in date...");
		} else {
			Reservation reservation = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: reservation dates for update must be future dates...");
			} else {
				if (!checkOut.after(checkIn)) {
					System.out.println("error reservation: check-ou date must be after check-in date...");
				} else {
					reservation.updateDates(checkIn, checkOut);
					System.out.println("Reservation: " + reservation);
				}
			}
		}
		sc.close();
	}

	public static void except_personalizada_solut_2() throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Room Number: ");
		int num = sc.nextInt();
		
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		
		if (!checkOut.after(checkIn)) {
			System.out.println("error reservation: check-ou date must be after check-in date...");
		} else {
			Reservation reservation = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
					
			//nova forma de realizar a validação do update de reserva:
			String result = reservation.updateDatesWithValidation(checkIn, checkOut);
			if (result != null)
				System.out.println("error in reservation: " + result);
			else
				System.out.println("Reservation: " + reservation);				
		}
		sc.close();
	}
	
	public static void except_personalizada_solut_3() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			System.out.print("Room Number: ");
			int num = sc.nextInt();
			
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation reservation = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
					
			reservation.updateDatesWithExcept(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
		} catch (ParseException e) {
			System.out.println("Invalid date format...");
		} catch (DomainException e) {
			System.out.println("Error in reservation... " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unespected error...");
		}finally {			
			sc.close();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		
		//testando_excepts();
		
		//lendoArquivo();
		
		//como não tratei exception o compilador coloca na assinatura do método e de todos que o chama
		//o lançamento da exception
		//pior jeito de fazer
		//except_personalizada_solut_1();
		
		//outra forma de fazer, neste caso retornando a string
		//except_personalizada_solut_2();
		
		//terceira forma de realizar, neste caso considerada a solução boa
		//aqui foi criada uma classe de exception personalizada
		except_personalizada_solut_3();
		
	}

}
