package ru.geekbrains.testapp.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ru.geekbrains.testapp.dto.ToyDto;

public class ToyStoreService {

        private List<ToyDto> toys;

        public ToyStoreService() {
            toys = new ArrayList<>();
        }

        public void addToy(int id, String name, int quantity, double weight) {
            ToyDto toy = new ToyDto(id, name, quantity, weight);
            toys.add(toy);
        }

        public void updateWeight(int toyId, double weight) {
            for (ToyDto toy : toys) {
                if (toy.getId() == toyId) {
                    toy.setWeight(weight);
                    break;
                }
            }
        }

        public ToyDto drawToy() {
            double totalWeight = toys.stream().mapToDouble(ToyDto::getWeight).sum();
            double randomValue = Math.random() * totalWeight;

            double cumulativeWeight = 0;
            for (ToyDto toy : toys) {
                cumulativeWeight += toy.getWeight();
                if (randomValue <= cumulativeWeight) {
                    ToyDto selectedToy = new ToyDto(toy.getId(), toy.getName(), 1, toy.getWeight());
                    toy.reduceQuantity();
                    return selectedToy;
                }
            }
            return null;
        }

        public void saveToFile(ToyDto toy, String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write("Toy ID: " + toy.getId() + ", Name: " + toy.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}