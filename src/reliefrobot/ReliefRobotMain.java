package reliefrobot;

import java.util.Scanner;
import java.util.Random;

public class ReliefRobotMain {

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("THE RELIEF ROBOT");
        System.out.println("===========================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        Random rand = new Random(47);

        while (true) {
            Scenario scene = Scenario.createRandomScenario(5, rand);
            System.out.println(scene);
            System.out.println();
            Person[] result = Engine.ruleset1(scene, Engine.diseaseSevComp);
            // result = ruleset2(scene);
            // result = ruleset3(scene);
            // result = my_decision(scene);
            // result = group_decision(scene);
            System.out.println("Hit any key to continue: ");
            scanner.nextLine();
            System.out.println();
            System.out.println("The people will recieve implants in this order: ");
            // print the people in the order they will recieve implants with numbers
            for (int i = 0; i < result.length; i++) {
                System.out.println((i + 1) + ". " + result[i]);
            }
            System.out.println("Hit 'q' to quit or any key to continue: ");

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
