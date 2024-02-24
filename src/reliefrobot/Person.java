package reliefrobot;
import java.util.List;
import java.util.Random;

public class Person {
    /*
     * constructor for the entirely random person -> since Java doesn't have concept of
     * optional parameters for constructor like Python does -> can overload and have multiple constructors
     */

    // we can change these attributes to fit our scenario

    String age; // humans can be a 'baby', 'child', or 'adult'
    String gender; //'male', 'female', 'non-binary'
    String diseaseSeverity; // can have a disease severity: 'mild', 'moderate', 'severe'
    
    // Adult attributes --> if not adult, resort to "" or false
    String profession; // adults are assigned a profession: 'doctor', 'CEO', 'criminal', 'homeless', 'unemployed', 'unknown'
    String fitnessLevel; // adults are classified as 'average', 'athletic', or 'overweight'
    boolean substanceUse; // can have alcohol or drug use. True if using
    String familyStatus; // can have a family status: 'single', 'married', 'has children'

    Random rand;

    // FOR ORDERING OF PERSON
    static List<String> AGE_ORDER = List.of("elderly", "baby", "child", "adult");
    static List<String> PROF_ORDER = List.of("criminal","homeless", "unemployed", "unknown", "CEO", "doctor");
    static List<String> GENDER_ORDER = List.of("non-binary", "male", "female");
    static List<String> FITNESS_LEVELS_ORDER = List.of("overweight",  "average", "athletic");
    static List<String> DISEASE_SEVERITY_ORDER = List.of("mild", "moderate", "severe");
    static List<Boolean> SUBSTANCE_USE_ORDER = List.of(true, false);
    static List<String> FAMILY_STATUS_ORDER = List.of("single", "married", "has children");

    public Person(String age, String profession, 
    String gender, String fitnessLevel, String diseaseSeverity, boolean substanceUse, String familyStatus) {
        this.age = age;
        this.profession = profession;
        this.gender = gender;
        this.fitnessLevel = fitnessLevel;
        this.diseaseSeverity = diseaseSeverity;
        this.substanceUse = substanceUse;
        this.familyStatus = familyStatus;
    }

    public String toString() {
        String output = "";

        output += "[" + diseaseSeverity + " disease; " + gender + "; " + age + "]";
        if (age.equals("adult")) {
            output += "; job: " + profession; 
            output += "; fitness level: " + fitnessLevel;
            output += "; substance use: " + substanceUse;
            output += "; family status: " + familyStatus; 
        }

        return output;
    }

    // FOR RANDOM GENERATION OF PERSON
    static String[] AGE_TYPES = {"baby", "child", "adult", "adult", "adult", "elderly"};
    static String[] PROF_TYPES = {"doctor", "CEO", "criminal", "homeless", "unemployed", "unknown", "unknown", "unknown"};
    static String[] GENDER_TYPES = {"male", "female", "non-binary"};
    static String[] FITNESS_LEVELS = {"overweight", "athletic", "average", "average"};
    static String[] DISEASE_SEVERITY = {"mild", "moderate", "severe"};
    static boolean[] SUBSTANCE_USE = {true, false, false, false};
    static String[] FAMILY_STATUS = {"single", "married", "has children"};

    /*
     * function to create a totally random person
     */
    public static Person createRandomPerson(int withSeed) {
        Random rand = new Random(withSeed);

        String ageRand = AGE_TYPES[rand.nextInt(AGE_TYPES.length)];; 
        String genderRand = GENDER_TYPES[rand.nextInt(GENDER_TYPES.length)];; 
        String severityRand = DISEASE_SEVERITY[rand.nextInt(DISEASE_SEVERITY.length)]; 
        
        String professionRand = ""; 
        String fitnessRand = ""; 
        Boolean substanceRand = false; 
        String familyRand = "";

        if (ageRand.equals("adult")) {
            fitnessRand = FITNESS_LEVELS[rand.nextInt(FITNESS_LEVELS.length)];
            professionRand = PROF_TYPES[rand.nextInt(PROF_TYPES.length)];
            substanceRand = SUBSTANCE_USE[rand.nextInt(SUBSTANCE_USE.length)];
            familyRand = FAMILY_STATUS[rand.nextInt(FAMILY_STATUS.length)];
        }

        return new Person(ageRand, professionRand, genderRand, fitnessRand, severityRand, substanceRand, familyRand); 
    }

    // getters to convert string to order of string in ordered list above

    public static int getIntFromAge(String age) {
        return AGE_ORDER.indexOf(age) + 1;
    }

    public static int getIntFromProfession(String profession) {
        return PROF_ORDER.indexOf(profession) + 1;
    }

    public static int getIntFromGender(String gender) {
        return GENDER_ORDER.indexOf(gender) + 1;
    }

    public static int getIntFromFitnessLevel(String fitnessLevel) {
        return FITNESS_LEVELS_ORDER.indexOf(fitnessLevel) + 1;
    }

    public static int getIntFromDiseaseSeverity(String diseaseSeverity) {
        return DISEASE_SEVERITY_ORDER.indexOf(diseaseSeverity) + 1;
    }

    public static int getIntFromSubstanceUse(boolean substanceUse) {
        return SUBSTANCE_USE_ORDER.indexOf(substanceUse) + 1;
    }

    public static int getIntFromFamilyStatus(String familyStatus) {
        return FAMILY_STATUS_ORDER.indexOf(familyStatus) + 1;
    }

}



/*
 * Original Python Code by Evan Peck 

import random

""" Packages all the info needed for a character.

Every scenario is composed of characters - many of which are people. Each
of those people can contain a variety of characteristics. The Person class
is used to represent the many pieces of information for people. 

Attributes:
    charType (string): 'human', 'you', 'cat', 'dog'
    age (string): humans can be a 'baby', 'child', or 'adult'
    profession (string): adults are assigned a profession: 'doctor', 'CEO',
        'criminal', 'homeless', 'unemployed', 'unknown'
    gender (string): 'male' or 'female' TODO: add more diverse options
    bodyType (string): adults are classified as 'average', 'athletic', or 'overweight'
    pregnant (bool): adult women may also be pregnant. True if pregant.
"""

class Person:
  def __init__(self, charType=None, age=None, profession=None,
        gender=None, bodyType=None, pregnant=None):
    ''' Create a character by randomly selecting their attributes

    All of the parameters in this method are OPTIONAL. This means that by
    default, a random character is made if no information is given. For
    example:
        character = Person()

    However, you can also create a custom character by filling in any
    number of those parameters. For example, the following code would
    create an adult woman with an average body type, but still allow
    the program to randomly select her profession:
        character = Person(charType="human", age="adult", gender="female",
                    bodyType="average")
    '''
    self.charType = charType
    self.profession = profession
    self.age = age
    self.gender = gender
    self.bodyType = bodyType
    self.pregnant = pregnant

  def __repr__(self):
    """ Method that helps python understand how to print a Person

    For example, you can now create a character in your code somewhere:
        character = Person()

    and then print that character to see what charecteristics it has:
        print(character)
    """
    if self.charType == "human":
        readable = '['
        if self.bodyType:
            readable += self.bodyType + ' '
        if self.age:
            readable += self.age
        if self.gender:
            readable += ' ' + self.gender + ']'
        if self.profession:
            readable += ' job:' + self.profession
        if self.pregnant:
            readable += ', pregnant'
    else:
        readable = self.charType
    return readable

# -------- END CLASS: Helper functions to randomly create characters ---------#

# The following variables not only contain the possibilities of different
# attributes of people/animals, but also the probability with which they
# appear. For example, charTypeS contains 'human' 4 times and 'animal'
# just 1 time. That means that 'human' is 4x more likely to appear.

# Choose between a human or animal
charTypeS = ["human", "human", "human", "animal", "human"]
# If it's an animal, choose between cat or dog
ANIMAL_TYPES = ["cat", "dog"]
# Possible ages of humans
AGE_TYPES = ["baby", "child", "adult", "adult", "adult", "elderly"]
# Possible professions of adults
PROF_TYPES = ["doctor", "CEO", "criminal", "homeless", "unemployed", "unknown", "unknown", "unknown"]
# Possible genders of humans
GENDER_TYPES = ["male", "female"]
# Select whether a female is pregnant (currently 25% chance)
PREGNANT_CHANCE = [True, False, False, False]
# Select the bodytype of each non-child.
BODYWEIGHT_CHANCE = ["overweight", "athletic", "average", "average"]


def create_random_person(charType=None, age=None, profession=None,
      gender=None, bodyType=None, pregnant=None):
  # set type of character (human or animal?)
  if charType == None:
    charType = random.choice(charTypeS) # you is also a char type

  # If it's an animal, choose which type
  if charType == "animal":
    charType = random.choice(ANIMAL_TYPES)
  # If it's a character, set the characteristics
  if charType == "human":
    age = random.choice(AGE_TYPES)
    gender = random.choice(GENDER_TYPES)

    # Set adult characteristics.
    if age == "adult":
      bodyType = random.choice(BODYWEIGHT_CHANCE)
      if gender == "female":
          pregnant = random.choice(PREGNANT_CHANCE)
      profession = random.choice(PROF_TYPES)

  return Person(charType, age, profession, gender, bodyType, pregnant)
 * 
 */