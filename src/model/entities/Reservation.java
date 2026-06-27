package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;


    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //Constructor
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        updateDates(checkIn, checkOut);
    }

    //Getters and Setters
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //Others Methods

    public long calcDuration(){
        long diff = getCheckOut().getTime() - getCheckIn().getTime(); // Retorna a diferença de tempo em millisegundos  do checkin e checkout
        return  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte os millisegundos do diff em dias
    }

    public String updateDates(Date checkIn, Date checkOut){
        Date now = new Date();

        if(checkIn.before(now) || checkOut.before(now))
            return  "The dates of reservation must be future dates!!";
        if(!checkOut.after(checkIn))
            return "A data de check-in deve ser anterior a data de check-out!!";

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + ", Check In: " + sdf.format(getCheckIn()) + ", Check Out: " + sdf.format(getCheckOut()) + ", " + calcDuration() + " nights";
    }
}
