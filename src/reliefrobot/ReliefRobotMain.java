package reliefrobot; 

public class ReliefRobotMain {
    
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
