package main;

import java.util.ArrayList;
import java.util.List;

public class Module {

  public int mass;

  public Module(int mass) {
    this.mass = mass;
  }

  public int calculateFuelRequired(int mass) {
    return (mass / 3) - 2;
  }

  public int calculateAllFuel() {
    List<Integer> allFuel = new ArrayList<Integer>();
    int fuel = calculateFuelRequired(this.mass);
    allFuel.add(fuel);

    while (fuel > 0) {
      int newFuel = calculateFuelRequired(fuel);
      if (newFuel > 0) {
        allFuel.add(newFuel);
      }
      fuel = newFuel;
    }

    return allFuel.parallelStream().mapToInt(Integer::intValue).sum();
  }

}
