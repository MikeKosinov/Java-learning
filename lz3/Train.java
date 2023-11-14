package lz3;

/*
* Створити класи, специфікації яких наведені нижче.
* Визначити конструктори і методи setТип(), getТип(), toString(). +
* Визначити додатково методи в класі, що створюють масив об'єктів.
* Задати критерій вибору даних і вивести ці дані на консоль.
* У кожному класі, що володіє інформацією, має бути оголошено кілька конструкторів. +
Train: Пункт призначення, Номер поїзда, Час відправлення,
* Число місць (загальних, купе, плацкарт, люкс). +

*  Створити масив об'єктів.
* Вивести:
* a) список поїздів, прямуючих до заданого пункту призначення;
* b) список поїздів, прямуючих до заданого пункту призначення, які відправляються після заданої години;
* c) список поїздів, які відправляються до заданого пункту призначення і мають загальні місця.*/

import java.util.ArrayList;
import java.util.List;

class Train {
    private String destination;
    private int trainNumber;
    private String departureTime;
    private int totalSeats;
    private int coupeSeats;
    private int reservedSeats;
    private int luxurySeats;

    // Конструктори
    public Train() {
    }

    public Train(String destination, int trainNumber, String departureTime, int totalSeats, int coupeSeats, int reservedSeats, int luxurySeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeats = reservedSeats;
        this.luxurySeats = luxurySeats;
    }

    // Геттери та сеттери

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getCoupeSeats() {
        return coupeSeats;
    }

    public void setCoupeSeats(int coupeSeats) {
        this.coupeSeats = coupeSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public int getLuxurySeats() {
        return luxurySeats;
    }

    public void setLuxurySeats(int luxurySeats) {
        this.luxurySeats = luxurySeats;
    }

    // Додаткові методи
    public static List<Train> createTrainArray() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train("Kyiv", 101, "08:00", 200, 50, 100, 10));
        trains.add(new Train("Lviv", 102, "10:30", 180, 40, 80, 15));
        trains.add(new Train("Odessa", 103, "12:45", 220, 60, 120, 20));
        return trains;
    }

    // a) Список поїздів, прямуючих до заданого пункту призначення
    public static List<Train> filterTrainsByDestination(List<Train> trains, String destination) {
        List<Train> filteredTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equals(destination)) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    // b) Список поїздів, прямуючих до заданого пункту призначення, які відправляються після заданої години
    public static List<Train> filterTrainsByDestinationAndTime(List<Train> trains, String destination, String departureTime) {
        List<Train> filteredTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equals(destination) && train.getDepartureTime().compareTo(departureTime) > 0) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    // c) Список поїздів, які відправляються до заданого пункту призначення і мають загальні місця
    public static List<Train> filterTrainsByDestinationAndSeats(List<Train> trains, String destination, int requiredSeats) {
        List<Train> filteredTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equals(destination) && train.getTotalSeats() >= requiredSeats) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", trainNumber=" + trainNumber +
                ", departureTime='" + departureTime + '\'' +
                ", totalSeats=" + totalSeats +
                ", coupeSeats=" + coupeSeats +
                ", reservedSeats=" + reservedSeats +
                ", luxurySeats=" + luxurySeats +
                '}';
    }

    public static void main(String[] args) {
        List<Train> trains = createTrainArray();

        // a) Вивести список поїздів до заданого пункту призначення
        String destinationToFilter = "Kyiv";
        List<Train> filteredTrainsByDestination = filterTrainsByDestination(trains, destinationToFilter);
        System.out.println("Trains to " + destinationToFilter + ": " + filteredTrainsByDestination);

        // b) Вивести список поїздів до заданого пункту призначення, які відправляються після заданої години
        String timeToFilter = "10:00";
        List<Train> filteredTrainsByDestinationAndTime = filterTrainsByDestinationAndTime(trains, destinationToFilter, timeToFilter);
        System.out.println("Trains to " + destinationToFilter + " after " + timeToFilter + ": " + filteredTrainsByDestinationAndTime);

        // c) Вивести список поїздів, які відправляються до заданого пункту призначення і мають загальні місця
        int requiredSeats = 150;
        List<Train> filteredTrainsByDestinationAndSeats = filterTrainsByDestinationAndSeats(trains, destinationToFilter, requiredSeats);
        System.out.println("Trains to " + destinationToFilter + " with at least " + requiredSeats + " total seats: " + filteredTrainsByDestinationAndSeats);
    }
}
