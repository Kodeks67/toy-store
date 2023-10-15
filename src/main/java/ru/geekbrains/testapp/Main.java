package ru.geekbrains.testapp;

import ru.geekbrains.testapp.dto.ToyDto;
import ru.geekbrains.testapp.service.ToyStoreService;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any key to draw a toy!");
        scanner.nextLine();

        ToyStoreService toyStoreService = new ToyStoreService();
        toyStoreService.addToy(1, "Хрюша", 10, 10.0);
        toyStoreService.addToy(2, "Степаша", 15, 15.0);
        toyStoreService.addToy(3, "Слоник", 20, 20.0);

        toyStoreService.updateWeight(1, new Random().nextDouble());

        ToyDto selectedToy = toyStoreService.drawToy();
        if (selectedToy != null) {
            System.out.println("Congratulations! You won a " + selectedToy.getName());
            toyStoreService.saveToFile(selectedToy, "winners.txt");
        } else {
            System.out.println("Sorry, no toys available for the draw.");
        }
    }
}