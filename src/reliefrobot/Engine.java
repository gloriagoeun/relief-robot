package reliefrobot; 
import java.util.*;

public class Engine {

  // uses heap to prioritize people based on severity of disease
  public static Person[] ruleset1(Scenario scenario, Comparator<Person> comp) {
    PriorityQueue<Person> pQueue = new PriorityQueue<Person>(comp);
    for (Person person : scenario.people) {
      pQueue.add(person);
    }

    // convert pqueue to array
    Person[] result = new Person[scenario.people.length];
    for (int i = 0; i < scenario.people.length; i++) {
      result[i] = pQueue.poll();
    }
    return result; 
  }

  // prioritize people based on severity of disease, must do reverse order to get the correct order
  public static Comparator<Person> diseaseSevComp = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      int p1Disease = Person.getIntFromDiseaseSeverity(p1.diseaseSeverity);
      int p2Disease = Person.getIntFromDiseaseSeverity(p2.diseaseSeverity);
      return p2Disease - p1Disease;
    }
  };

  public static Comparator<Person> exampleWeightedComp = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      int p1Disease = Person.getIntFromDiseaseSeverity(p1.diseaseSeverity);
      int p2Disease = Person.getIntFromDiseaseSeverity(p2.diseaseSeverity);
      int p1age = Person.getIntFromAge(p1.age);
      int p2age = Person.getIntFromAge(p2.age);

      return (p2Disease * 2 + p2age) - (p1Disease * 2 + p1age);
    }
  };

  public static Comparator<Person> newComparator = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      //TO BE UPDATED AFTER MAKE ALL PROPERTIES INTO INTs

      return 0; 
    }
  };
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