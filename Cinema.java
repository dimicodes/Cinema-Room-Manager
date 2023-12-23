package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();

        System.out.println("\nEnter the number of seats in each row:");
        int numSeats = scanner.nextInt();

        char[][] cinemaSeatsArray = new char[numRows][numSeats];

        userOptions(numRows, numSeats, cinemaSeatsArray);
    }

    static int calculateIncome(int rows, int seats) {
        int income = 0;
        int normalTicketPrice = 10;
        int backTicketPrice = 8;
        if ((rows * seats) > 60) {
            int frontRows = (int) Math.floor((double) rows / 2);
            income = (frontRows * seats * normalTicketPrice) + ((rows - frontRows) * seats * backTicketPrice);
        } else {
            income = rows * seats * normalTicketPrice;
        }
        return income;
    }

    static int ticketPrice(int rows, int seats, int chosenRow) {
        int ticketPrice = 10;
        if ((rows * seats) > 60) {
            int frontRows = (int) Math.floor((double) rows / 2);
            int backRows = rows - frontRows;
            if (chosenRow > frontRows) {
                ticketPrice = 8;
            }
        }
        return ticketPrice;
    }

    static void printCinema(int rows, int seats, char[][] cinemaSeatsArray) {
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++)
                if (cinemaSeatsArray[i][j] == 'B') {
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            System.out.println();
        }
    }

    static void userOptions(int numRows, int numSeats, char[][] cinemaSeatsArray) {
        int chosenRow = 0;
        int chosenSeat = 0;
        boolean seatFull = true;
        boolean wrongInput = true;

        boolean userActive = true;
        while (userActive) {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n");

            Scanner scanner = new Scanner(System.in);
            int userSelection = scanner.nextInt();

            if (userSelection == 1) {
                printCinema(numRows, numSeats, cinemaSeatsArray);
            } else if (userSelection == 2) {
                do {
                    System.out.println("\nEnter a row number:");
                    chosenRow = scanner.nextInt();

                    System.out.println("Enter a seat number in that row:");
                    chosenSeat = scanner.nextInt();

                    if ((chosenRow > numRows) || chosenRow < 1 || (chosenSeat > numSeats) || chosenSeat < 1) {
                        System.out.println("Wrong input!");
                        wrongInput = true;
                    } else {
                        wrongInput = false;
                    }

                    if (!wrongInput) {
                        if (cinemaSeatsArray[chosenRow - 1][chosenSeat - 1] == 'B') {
                            System.out.println("That ticket has already been purchased!");
                            seatFull = true;
                        } else {
                            seatFull = false;
                            cinemaSeatsArray[chosenRow - 1][chosenSeat - 1] = 'B';
                        }
                    }
                } while (wrongInput || seatFull);

                System.out.println("Ticket price: $" + ticketPrice(numRows, numSeats, chosenRow));

            }
              else if (userSelection == 3) {
                calculateStatistics(numRows, numSeats, cinemaSeatsArray);
            } else if (userSelection == 0) {
                userActive = false;
            }
        }
    }

    static void calculateStatistics(int numRows, int numSeats, char[][] cinemaSeatsArray) {
        int totalSeats = 0;
        int purchasedTicketsFront = 0;
        int purchasedTicketsBack = 0;
        int purchasedTickets = 0;
        float percentage = 0;
        int currentIncome = 0;
        int totalIncome = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSeats; j++) {
                totalSeats += 1;
                if ((cinemaSeatsArray[i][j] == 'B') && (i + 1 <= (int) Math.floor((double) numRows / 2))) {
                    purchasedTicketsFront += 1;
                    purchasedTickets += 1;
                } else if ((cinemaSeatsArray[i][j] == 'B') && (i + 1> (int) Math.floor((double) numRows / 2))){
                    purchasedTicketsBack += 1;
                    purchasedTickets += 1;
                }
            }
        }

        percentage = (float) purchasedTickets / totalSeats * 100;
        currentIncome = ((purchasedTicketsFront * 10) + (purchasedTicketsBack * 8));
        totalIncome = calculateIncome(numRows, numSeats);

        System.out.println("\nNumber of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}
