package transplantmanager;

import java.util.*;

public class Engine {

  /*
   * uses heap to prioritize people based on scenario and comparator
   */
  public static PriorityQueue<Person> prioritizePeople(Scenario scenario, Comparator<Person> comp) {
    PriorityQueue<Person> pQueue = new PriorityQueue<>(comp);
    Person[] people = scenario.getPeople();
    // add all people to the priority queue
    for (Person p : people) {
      pQueue.add(p);
    }

    return pQueue;
  }

  /*
   * prioritize people based on severity of disease
   */
  public static final Comparator<Person> diseaseSeverityComp = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      int p1Disease = Person.DISEASE_SEVERITY_ORDER.indexOf(p1.diseaseSeverity)+1;
      int p2Disease = Person.DISEASE_SEVERITY_ORDER.indexOf(p2.diseaseSeverity)+1;

      // must do reverse order for a max heap
      return Integer.compare(p2Disease, p1Disease);
    }
  };

  /*
   * prioritize people based on severity of disease and category but weighs severity 2
   * times more than category
   */
  public static final Comparator<Person> weightedSeverityCategoryComp = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
      int p1Score = (Person.DISEASE_SEVERITY_ORDER.indexOf(p1.diseaseSeverity)+1) * 2
          + Person.DISEASE_SEVERITY_ORDER.indexOf(p1.category)+1;
      int p2Score = (Person.DISEASE_SEVERITY_ORDER.indexOf(p2.diseaseSeverity)+1) * 2
          + Person.DISEASE_SEVERITY_ORDER.indexOf(p2.category)+1;

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