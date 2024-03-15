package transplantmanager;

import java.util.Random;

/**
 * Class that creates scenarios based on a list of transplant candidates
 */
public class Scenario {

  private Person[] people;

  public Scenario(Person[] people) {
    this.people = people;
  }

  public Person[] getPeople(){
    return people;
  }
 
  /*
   * Method to print a Scenario
   */
  public String toString() {
    StringBuilder output = new StringBuilder("Transplant candidates waiting to receive a liver transplant: \n");
    for (int i=0; i<people.length; i++) {
      output.append((i+1) + ": " + people[i].toString() + "\n");
    }
    return output.toString();
  }

  /*
   * Method to create a random scenario by generating random people
   * 
   * @param numPeople: number of people in the scenario
   * 
   * @return a random scenario
   */
  public static Scenario createRandomScenario(int numPeople) {
    Person[] randomPeople = new Person[numPeople];
    Random rand = new Random();
    for (int i = 0; i < numPeople; i++) {
      Person person = Person.createRandomPerson(rand);
      randomPeople[i] = person;
    }
    return new Scenario(randomPeople);
  }
}