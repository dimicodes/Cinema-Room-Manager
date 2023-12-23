# Cinema-Room-Manager

## Description
The Cinema Room Manager is a Java console application that simulates the management of a cinema room. It allows users to view the seating arrangement, purchase tickets, and view statistics about the cinema's current status. This project provides a hands-on experience with arrays, loops, and conditional statements in Java.

## Features
- **View Seats**: Displays the current seating arrangement in the cinema with an indication of available and booked seats.
- **Buy Tickets**: Users can choose a specific seat and purchase a ticket for it. The application checks for seat availability and provides the ticket price.
- **View Statistics**: Displays statistics like the total number of purchased tickets, percentage of booked seats, current income, and total potential income.

## How to Run
1. Make sure Java is installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the directory containing the `Cinema.java` file.
4. Compile the program using `javac Cinema.java`.
5. Run the program with `java Cinema`.

## Implementation Details
- The cinema seating is represented as a 2D array of characters, where 'S' indicates an available seat and 'B' indicates a booked seat.
- Ticket prices are determined based on the seat's location: front half or back half of the cinema.
- For a cinema room with more than 60 seats, pricing varies between the front and back half of the cinema.

## Preview

![image](https://github.com/dimicodes/Cinema-Room-Manager/assets/45632694/07df2d19-4e9b-42d7-b35e-a8505ae92b81)

![image](https://github.com/dimicodes/Cinema-Room-Manager/assets/45632694/2a27c841-f356-4bf5-94b2-82c6d1d36b76)
