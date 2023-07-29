package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//criado uma formatação como estática para que sempre que um novo objeto for
	//criado ter apenas este formato e não um novo sendo instanciado
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{
		if (!checkOut.after(checkIn))
			 throw new  DomainException("error reservation: check-ou date must be after check-in date...");
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void updateDates(Date in, Date out) {
		this.checkIn = in;
		this.checkOut = out;
	}
	
	public void updateDatesWithExcept(Date in, Date out) throws DomainException{
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			 throw new DomainException("Error in reservation: reservation dates for update must be future dates...");
		if (!checkOut.after(checkIn))
			 throw new  DomainException("error reservation: check-ou date must be after check-in date...");
				
		this.checkIn = in;
		this.checkOut = out;
	}
	
	public String updateDatesWithValidation(Date in, Date out) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			return "Error in reservation: reservation dates for update must be future dates...";
		if (!checkOut.after(checkIn))
			return "error reservation: check-ou date must be after check-in date...";
				
		this.checkIn = in;
		this.checkOut = out;
		
		return null;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		String str = "Room: ";
		str += this.roomNumber;
		str += ", check-In: ";
		str += sdf.format(this.checkIn);
		str += ", check-Out: ";
		str += sdf.format(this.checkOut);
		str += ", Duration: ";
		str += this.duration();
		str += " nights.";
		
		return str;
	}
	
	
	
}
