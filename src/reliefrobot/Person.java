package reliefrobot; 
import java.util.Random;

public class Person {
    /*
     * constructor for the entirely random person -> since Java doesn't have concept of
     * optional parameters for constructor like Python does -> can overload and have multiple constructors
     */

    // we can change these attributes to fit our scenario

    String charType; // options: 'human', 'you', 'cat', 'dog'
    String age; // humans can be a 'baby', 'child', or 'adult'
    String gender; //'male', 'female', 'non-binary'
    
    // Adult attributes --> if not adult, resort to "" (?)
    String profession; // adults are assigned a profession: 'doctor', 'CEO', 'criminal', 'homeless', 'unemployed', 'unknown'
    String bodyType; // adults are classified as 'average', 'athletic', or 'overweight'
    Boolean pregnant; // adult women may also be pregnant. True if pregant


    public Person(String charType, String age, String profession, 
    String gender, String bodyType, Boolean pregnant) {
        this.charType = charType; 
        this.age = age;
        this.profession = profession;
        this.gender = gender;
        this.bodyType = bodyType;
        this.pregnant = pregnant;
    }

    public String toString() {
        String output = "";

        if (charType.equals("human")){
            output += "[" + bodyType + " " + age + " " + gender + "]";
            output += " job: " + profession; 

            if (pregnant) {
                output += ", pregnant";
            }

        } else {
            output += charType;
        }

        return output;
    }

    // FOR RANDOM GENERATION 
    String[] CHARTYPES = {"human", "human", "human", "animal", "human"};
    String[] ANIMAL_TYPES = {"cat", "dog"};
    String[] AGE_TYPES = {"baby", "child", "adult", "adult", "adult", "elderly"};
    String[] PROF_TYPES = {"doctor", "CEO", "criminal", "homeless", "unemployed", "unknown", "unknown", "unknown"};
    String[] GENDER_TYPES = {"male", "female"};
    Boolean[] PREGNANT_CHANCE = {true, false, false, false};
    String[] BODYWEIGHT_CHANCE = {"overweight", "athletic", "average", "average"};

    /*
     * function to create a totally random person
     */
    public Person create_random_person() {
        Random rand = new Random();
        String charType_rand = CHARTYPES[rand.nextInt(CHARTYPES.length)];
        String age_rand = ""; String profession_rand = ""; String gender_rand = ""; 
        String bodyType_rand = ""; Boolean pregnant_rand = false; 
        
        if (charType_rand.equals("animal")) {
            charType_rand = ANIMAL_TYPES[rand.nextInt(ANIMAL_TYPES.length)];
        } 
        // if "human"
        else {
            age_rand = AGE_TYPES[rand.nextInt(AGE_TYPES.length)];
            gender_rand = GENDER_TYPES[rand.nextInt(GENDER_TYPES.length)];

            if (age_rand.equals("adult")) {
                bodyType_rand = BODYWEIGHT_CHANCE[rand.nextInt(BODYWEIGHT_CHANCE.length)];
                profession_rand = PROF_TYPES[rand.nextInt(PROF_TYPES.length)];

                if (gender_rand.equals("female")) {
                    pregnant_rand = PREGNANT_CHANCE[rand.nextInt(PREGNANT_CHANCE.length)];
                }
            }
        }

        return new Person(charType_rand, age_rand, profession_rand, gender_rand, bodyType_rand, pregnant_rand); 
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