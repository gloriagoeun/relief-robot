package reliefrobot;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Random;

public class ReliefRobotMain {

  public static void main(String[] args) {
    System.out.println("===========================================");
    System.out.println("THE RELIEF ROBOT");
    System.out.println("===========================================\n");

    Scanner scanner = new Scanner(System.in);

    Random rand = new Random(47);
    int peopleCanSave = 3;

    while (true) {
      Scenario scene = Scenario.createRandomScenario(5, rand);
      System.out.println(scene);
      System.out.println("Select how you want to prioritize the people: ");
      System.out.println("1. Disease Severity");
      System.out.println("2. Weighted Disease Severity and Age");
      System.out.println("3. My own Comparator");
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
          comp = Engine.weightedSeverityAgeComp;
          break;
        case "3":
          comp = Engine.newComparator;
          break;
      }

      Person[] result = Engine.prioritizePeople(scene, comp);
      System.out.println("\nThe " + peopleCanSave + " people who will recieve implants in this order: ");

      // print the top x people in the order they will recieve implants with numbers
      for (int i = 0; i < peopleCanSave; i++) {
        System.out.println((i + 1) + ". " + result[i]);
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

/*
 * Original Python Code by Evan Peck

from scenario import (
  set_seed,
  Scenario,
  create_random_scenario
)

from engine import (
  ruleset1,
  ruleset2,
  ruleset3,
  my_decision,
  group_decision
)

def run_simulation():
  print("===========================================")
  print("THE ETHICAL ENGINE")
  print("===========================================")
  print()

  # If you want to continually test the same scenario
  # instead of one that is truly random, uncomment
  # the line below so that your program starts 
  # with the same set of people each time. 
  # set_seed(42)

  while True:
    scene = create_random_scenario()
    print(scene)
    print()
    result = ruleset1(scene)
    # result = ruleset2(scene)
    # result = ruleset3(scene)
    # result = my_decision(scene)
    # result = group_decision(scene)
    print()
    input('Hit any key to see decision: ')
    print('I choose to save the', result)
    print()

    # For breaking the loop
    response = input("Hit 'q' to quit or 'enter' to continue: ")
    if response == 'q':
      break

  print('Done')

run_simulation()

 */
