package reliefrobot; 
import java.util.*;

public class Engine {

  // uses heap to prioritize people based on severity of disease
  PriorityQueue<Integer> pQueue = new PriorityQueue<>();
  public static Person[] ruleset1(Scenario scenario) {
    // for (Person person : scenario.people) {
    //   pQueue.add(person);
    // }
    return scenario.people; 
  }
    
}

/*
 * Original Code by Evan Peck

from scenario import Scenario

"""
The following set of exercises was developed by Vinesh Kanna (MimirHQ) based on an activity by Evan Peck (Bucknell University). It was modifed by Evan Peck to match a disaster-relief scenario.
"""

def ruleset1(scenario):
  """
  Decides whether your robot will save the people location 1 or location 2
  - Save the person in location 1, if and ONLY if they are pregnant.

  Note: in this activity, there will only be one person in each location
  @param scenario: details about the scenario
  @return: "loc1people" or "loc2people" depending on who you want to save
  """
  loc1person = scenario.loc1people[0]
  
  loc2person = scenario.loc2people[0]
  # TODO: Fill in the method
  return "loc1people"


def ruleset2(scenario):
  """
  Decides whether your robot will save the people location 1 or location 2
  - Save the person in location 2, if they are NOT trespassing or if they are a child.

  Note: in this activity, there will only be one person in each location
  @param scenario: details about the scenario
  @return: "loc1people" or "loc2people" depending on who you want to save
  """
  loc1person = scenario.loc1people[0]
  loc2person = scenario.loc2people[0]
  # TODO: Fill in the method
  return "loc1people"


def ruleset3(scenario):
  """
  Decides whether your robot will save the people location 1 or location 2
  - The first priority is to save the person who is a baby.
  - The second priority is to save athletic people.
  - The third priority is to save people who are either a doctor or a CEO.
  - The fourth priority is to save females.
  - The fifth priority is to save the loc1person.

  Note: in this activity, there will only be one person in each location
  @param scenario: details about the scenario
  @return: "loc1people" or "loc2people" depending on who you want to save
  """
  loc1person = scenario.loc1people[0]
  loc2person = scenario.loc2people[0]
  # TODO: Fill in the method
  return "loc1people"


def my_decision(scenario):
  """
  Decides whether your robot will save the people location 1 or location 2
  - Your own decision algorithm.

  Note: in this activity, there will only be one person in each location
  @param scenario: details about the scenario
  @return: "loc1people" or "loc2people" depending on who you want to save
  """
  loc1person = scenario.loc1people[0]
  loc2person = scenario.loc2people[0]
  # TODO: Fill in the method
  return "loc1people"

def group_decision(scenario):
  """
  Decides whether your robot will save the GROUP of people at location 1 or location 2
  - Your own decision algorithm.

  Note: in this activity, there will be 1 to 4 people in each location
  @param scenario: details about the scenario
  @return: "loc1people" or "loc2people" depending on who you want to save
  """
  loc1people = scenario.loc1people
  loc2people = scenario.loc2people
  # TODO: Fill in the method
  return "loc1people"
 */