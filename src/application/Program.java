package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int roomNumber = input.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(input.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(input.next());

        if(checkIn.after(checkOut)){
            System.out.println("ERROR RESERVATION!! A data de check-in deve ser anterior a data de check-out!!");
        }else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservatio: " + reservation);

            System.out.println();


            System.out.println("Enter date to update the reservation:");
            System.out.print("Room Number: ");
            roomNumber = input.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(input.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(input.next());

            Date now = new Date();

            if(checkIn.before(now) || checkOut.before(now))
                System.out.println("ERROR IN RESERVATION!! The dates of reservation must be future dates!!");
            else if(!checkOut.after(checkIn))
                System.out.println("ERROR RESERVATION!! A data de check-in deve ser anterior a data de check-out!!");
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservatio: " + reservation);
            }
        }

        input.close();
    }
}
