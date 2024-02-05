package reliefrobot; 

public class Scenario {
    
}

/*
 * Original Code by Evan Peck

import random

from person import Person
from person import create_random_person

class Scenario:
  """ Packages all of the information needed to create an ethical scenario.
  Automatically construct a random scenario in which an autonomous robot must
  decide whether to save the people in location 1 vs. location 2

  Args:
      sameNum (bool, optional): if True, enforces that the number of
          people in location1 is the same as location2
  Attributes:
      loc1people (list): list of entities at location 1
      loc2people (list): list of entities at location 2
      youInLoc1 (bool): True if you are one of the people at location 1
      trespassing (bool): True if loc2people are currently trespassing
  """

  def __init__(self, loc1people=None, loc2people=None, youInLoc1=None, trespassing=None,
    sameNum=True):

    self.loc1people = loc1people
    self.loc2people = loc2people
    self.youInLoc1 = youInLoc1
    self.trespassing = trespassing
    self.sameNum = sameNum

  def __repr__(self):
    """ Method that helps python understand how to print a Scenario
    For example, you can now create a scenario in your code somewhere:
        scenario = Scenario()
    and then print that scenario:
        print(scenario)
    This will print a readable form of the scenario in your program
    """
    readable = 'People at Location 1: \n'
    for entity in self.loc1people:
      readable += '-' + str(entity) + '\n'

    readable += '\n'
    readable += 'People at Location 2: \n'
    for entity in self.loc2people:
      readable += '-' + str(entity) + '\n'
    if self.trespassing:
      readable += '- This group is trespassing\n'
    readable += '\n'

    return readable








# -------- END CLASS: Helper functions to randomly create scenarios ---------#


def create_random_scenario(loc1people=None, loc2people=None, 
  youInLoc1=None, trespassing=None, sameNum=True):
  # The minimum/maximum number of people at each location
  MIN_LOCATION1 = 1
  MAX_LOCATION1 = 1
  MIN_LOCATION2 = 1
  MAX_LOCATION2 = 1

  # The following variables are lists that represent the probabilities of
  # each feature happening. For example, in YOU_CHANCE, there is a 1 in 4
  # chance that that 'you' are in the vehicle. Similarly, in TRESPASSING_CHANCE,
  # there is a 2 in 3 chance that the loc2people are crossing the street
  # legally (the walk sign is on)
  YOU_CHANCE = [True, False, False, False]
  TRESPASSING_CHANCE = [True, True, False]

  # Create a random number of people in location 2
  numLoc2 = random.randint(MIN_LOCATION2, MAX_LOCATION2)

  # If sameNum is true, create the same number of people in location 1
  # Otherwise, create a random number of people in location 1
  if not sameNum:
    numLoc1 = random.randint(MIN_LOCATION1, MAX_LOCATION1)
  else:
    numLoc1 = numLoc2

  # DETERMINE THE PEOPLE IN LOCATION 1
  if loc1people is not None:
    loc1people = loc1people
  else:
    # Create randomly generated people for location 1
    loc1people = [create_random_person() for numPeople in range(numLoc1)]

    # If you are in location 1, replace one of the people there with you.
    if youInLoc1 is not None:
      youInLoc1 = youInLoc1
    else:
      youInLoc1 = random.choice(YOU_CHANCE)

    if youInLoc1 is True:
      # Feel free to change these attributes if you'd like.
      youPerson = Person("you")
      if numLoc1 > 0:
        loc1people[0] = youPerson
      else:
        loc1people += [youPerson]

  # DETERMINE THE PEOPLE IN LOCATION 2
  if loc2people is not None:
    loc2people = loc2people
  else:
    loc2people = [create_random_person() for numPeople in range(numLoc2)]

  # Determine if the people in location 2 are trespassing
  if trespassing is not None:
    trespassing = trespassing
  else:
    trespassing = random.choice(TRESPASSING_CHANCE)

  return Scenario(loc1people, loc2people, youInLoc1, trespassing, sameNum)

def set_seed(seed):
  random.seed(seed);
 */