package reliefrobot;

import java.util.*;

public class Engine {

  /*
   * uses heap to prioritize people based on scenario and comparator
   */
  public static Person[] prioritizePeople(Scenario scenario, Comparator<Person> comp) {
    PriorityQueue<Person> pQueue = new PriorityQueue<>(comp);
    // add all people to the priority queue
    for (Person p : scenario.people) {
      pQueue.add(p);
    }

    // convert pqueue to array
    Person[] result = new Person[scenario.people.length];
    for (int i = 0; i < scenario.people.length; i++) {
      result[i] = pQueue.poll();
    }
    return result;
  }

  /*
   * prioritize people based on severity of disease
   */
  public static final Comparator<Person> diseaseSeverityComp = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      int p1Disease = Person.getIntfromAttributes(Person.DISEASE_SEVERITY_ORDER, p1.diseaseSeverity);
      int p2Disease = Person.getIntfromAttributes(Person.DISEASE_SEVERITY_ORDER, p2.diseaseSeverity);

      // must do reverse order for a max heap
      return Integer.compare(p2Disease, p1Disease);
    }
  };

  /*
   * prioritize people based on severity of disease and age but weights severity 2
   * times more than age
   */
  public static final Comparator<Person> weightedSeverityAgeComp = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      int p1Score = Person.getIntfromAttributes(Person.DISEASE_SEVERITY_ORDER, p1.diseaseSeverity) * 2
          + Person.getIntfromAttributes(Person.AGE_ORDER, p1.age);
      int p2Score = Person.getIntfromAttributes(Person.DISEASE_SEVERITY_ORDER, p2.diseaseSeverity) * 2
          + Person.getIntfromAttributes(Person.AGE_ORDER, p2.age);

      return Integer.compare(p2Score, p1Score);
    }
  };

  /*
   * Students create their own "rule"" using multiple attributes
   */
  public static final Comparator<Person> newComparator = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {

      // TODO: Fill in the method using at least 4 attributes

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