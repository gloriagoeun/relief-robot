package transplantmanager;

import java.util.List;
import java.util.Random;

/**
 * Class that represents a transplant candidate. 
 */
public class Person {

    String category; // a person can be a "baby", "child", "adult", "elderly"
    String gender; // one of "male", "female", "non-binary"
    String diseaseSeverity; // one of "mild", "moderate", "severe"

    // Adult attributes --> if not adult, resort to null for all other attributes
    String profession; // one of "doctor", "CEO", "criminal", "unemployed", "unknown"
    String fitnessLevel; // one of "average", "athletic", or "overweight"
    String substanceUse; // one of "alcohol", "drugs", "both", "none"
    String familyStatus; // one of "single", "married", "has children"

    // immutable lists of the specified elements per attribute
    static final List<String> CATEGORY_ORDER = List.of("elderly", "baby", "child", "adult");
    static final List<String> GENDER_ORDER = List.of("non-binary", "male", "female");
    static final List<String> DISEASE_SEVERITY_ORDER = List.of("mild", "moderate", "severe");
    static final List<String> PROFESSION_ORDER = List.of("criminal", "homeless", "unemployed", "unknown", "CEO", "doctor");
    static final List<String> FITNESS_LEVELS_ORDER = List.of("overweight", "average", "athletic");
    static final List<String> SUBSTANCE_USE_ORDER = List.of("alcohol", "drugs", "both", "none");
    static final List<String> FAMILY_STATUS_ORDER = List.of("single", "married", "has children");

    public Person(String category, String gender, String diseaseSeverity){
        this(category, gender, diseaseSeverity, null, null, null, null);
    }

    public Person(String category, String gender,String diseaseSeverity, String profession, String fitnessLevel, String substanceUse, String familyStatus) {
        this.category = category;
        this.gender = gender;
        this.diseaseSeverity = diseaseSeverity;
        this.profession = profession;
        this.fitnessLevel = fitnessLevel;
        this.substanceUse = substanceUse;
        this.familyStatus = familyStatus;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("");

        output.append("["  + diseaseSeverity + " disease; " + gender + "; " + category);
        if (category.equals("adult")) {
            output.append("; profession: " + profession);
            output.append("; fitness level: " + fitnessLevel);
            output.append("; substance use: " + substanceUse);
            output.append("; family status: " + familyStatus);
        }
        output.append("]");
        return output.toString();
    }


    /*
     * method to create a random Person
     */
    public static Person createRandomPerson(Random rand) {

        String categoryRand = CATEGORY_ORDER.get(rand.nextInt(CATEGORY_ORDER.size()));
        String genderRand = GENDER_ORDER.get(rand.nextInt(GENDER_ORDER.size()));
        String severityRand = DISEASE_SEVERITY_ORDER.get(rand.nextInt(DISEASE_SEVERITY_ORDER.size()));

        if (categoryRand.equals("adult")) {
            String professionRand = PROFESSION_ORDER.get(rand.nextInt(PROFESSION_ORDER.size()));
            String fitnessRand = FITNESS_LEVELS_ORDER.get(rand.nextInt(FITNESS_LEVELS_ORDER.size()));
            String substanceRand = SUBSTANCE_USE_ORDER.get(rand.nextInt(SUBSTANCE_USE_ORDER.size()));
            String familyStatusRand = FAMILY_STATUS_ORDER.get(rand.nextInt(FAMILY_STATUS_ORDER.size()));
            
            return new Person(categoryRand, genderRand, severityRand, professionRand, fitnessRand, substanceRand, familyStatusRand);
        }

        return new Person(categoryRand, genderRand, severityRand);
    }

}