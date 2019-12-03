package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FuelCounterUpper {

  public static void runTests() {
    ArrayList<Module> modules = new ArrayList<Module>();
    Module module1 = new Module(12);
    Module module2 = new Module(14);
    Module module3 = new Module(1969);
    Module module4 = new Module(100756);

    modules.add(module1);
    modules.add(module2);
    modules.add(module3);
    modules.add(module4);

    for (Module module : modules) {
      int fuel = module.calculateFuelRequired(module.mass);
      System.out.println("Mass fuel is " + fuel);

      int allFuel = module.calculateAllFuel();
      System.out.println("All fuel is " + allFuel);
    }

  }

  public static int getSingleFuelForInput() throws FileNotFoundException {
    File file = new File(FuelCounterUpper.class.getResource("/main/input.txt").getFile());
    Scanner sc = new Scanner(file);
    ArrayList<Integer> results = new ArrayList<Integer>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      Module module = new Module(Integer.parseInt(line));
      results.add(module.calculateFuelRequired(module.mass));
    }
    sc.close();
    return results.stream().mapToInt(Integer::intValue).sum();
  }

  public static int getAllFuelForInput() throws FileNotFoundException {
    File file = new File(FuelCounterUpper.class.getResource("/main/input.txt").getFile());
    Scanner sc = new Scanner(file);
    ArrayList<Integer> results = new ArrayList<Integer>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      Module module = new Module(Integer.parseInt(line));
      results.add(module.calculateAllFuel());
    }
    sc.close();
    return results.stream().mapToInt(Integer::intValue).sum();
  }

  public static void main(String[] args) throws FileNotFoundException {
    runTests();
    System.out.println("*************");
    System.out.println(getAllFuelForInput());
  }

}
