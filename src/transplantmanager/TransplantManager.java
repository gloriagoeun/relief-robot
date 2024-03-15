package transplantmanager;

import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TransplantManager {

  public static void main(String[] args) {
    System.out.println("===========================================");
    System.out.println("Transplant Manager");
    System.out.println("===========================================\n");

    Scanner scanner = new Scanner(System.in);

    int availableTransplants = 3;

    while (true) {
      Scenario scene = Scenario.createRandomScenario(5);
      System.out.println(scene);
      System.out.println("Select how you want to prioritize transplant recipients: ");
      System.out.println("1. By Disease Severity");
      System.out.println("2. By Disease Severity and Candidate Category");
      System.out.println("3. Using my own Comparator");
      String input = scanner.nextLine();

      // validate input
      while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
        System.out.println("Invalid input. Please enter 1, 2, or 3: ");
        input = scanner.nextLine();
      }

      // use comparator based on user input
      Comparator<Person> comp = null;
      switch (input) {
        case "1":
          comp = Engine.diseaseSeverityComp;
          break;
        case "2":
          comp = Engine.weightedSeverityCategoryComp;
          break;
        case "3":
          comp = Engine.newComparator;
          break;
      }

      PriorityQueue<Person> result = Engine.prioritizePeople(scene, comp);
      System.out.println("\nThe " + availableTransplants + " people who will receive transplants in this order: ");

      // print the top x people in the order they will receive transplants with numbers
      for (int i = 0; i < availableTransplants; i++) {
        System.out.println((i + 1) + ". " + result.poll());
      }
      System.out.println("\nHit 'q' to quit or any key to continue to new scenario: ");

      // For breaking the loop ask for user input
      String response = scanner.nextLine();
      if (response.equals("q")) {
        break;
      }
    }

    System.out.println("Done");
    scanner.close();
   }
}
