/*
 * This class represents a Person and includes private variables for first name, last name, phone number,
 * zip code, city, relation, and a Relationship enum. It provides a constructor, getter and setter methods,
 * and overrides the toString() method for meaningful representation.
 */
public class Person implements Comparable<Person>{
    public int compareTo(Person otherPerson) {
        return this.fname.compareToIgnoreCase(otherPerson.fname);
    }

    /*
     * Private variables to store personal information.
     */
    private String fname;
    private String lname;
    private String phnNo;
    private int zipCode;
    private String city;
    private String state;
    private String relation;
    private Relationship relationship;

    /*
     * Constructor to initialize a Person object with the provided parameters.
     *
     * @param fname First name of the person.
     * @param lname Last name of the person.
     * @param phnNo Phone number of the person.
     * @param zipCode Zip code of the person.
     * @param city City of the person.
     * @param relation Relation of the person (family, friends, associates, colleagues).
     */
    public Person(String fname, String lname, String phnNo, int zipCode, String city, String state, String relation) {
        this.fname = fname;
        this.lname = lname;
        this.phnNo = phnNo;
        this.zipCode = zipCode;
        this.city = city;
        this.state= state;
        this.relationship = Relationship.fromString(relation);
    }

    /*
     * Override of the toString() method to provide a formatted string representation of the Person object.
     */
    @Override
    public String toString() {
        return "Person{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phnNo='" + phnNo + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", relation='" + relation + '\'' +
                ", relationship=" + relationship +
                '}';
    }

    // Getter and setter methods for private variables.

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) { this.state = state; }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }

    public String getRelation() {
        return relation;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public Relationship getRelationship() {
        return relationship;
    }
}

/*
 * Enum class representing possible relationship types with associated string values.
 */
enum Relationship {
    FAMILY("family"),
    FRIENDS("friends"),
    ASSOCIATES("associates"),
    COLLEAGUES("colleagues");

    /*
     * Private variable to store the relation associated with each enum constant.
     */
    private final String relation;

    /*
     * Constructor to associate a string value with each enum constant.
     *
     * @param relation The string value associated with the enum constant.
     */
    Relationship(String relation) {
        this.relation = relation;
    }

    /*
     * Getter method to retrieve the string value associated with the enum constant.
     *
     * @return The string value associated with the enum constant.
     */
    public String getRelation() {
        return relation;
    }

    /*
     * Static method to convert a string to the corresponding Relationship enum constant.
     *
     * @param text The string to be converted to a Relationship enum constant.
     * @return The Relationship enum constant corresponding to the input string.
     * @throws IllegalArgumentException If no constant with the specified text is found.
     */
    public static Relationship fromString(String text) {
        for (Relationship relationship : Relationship.values()) {
            if (relationship.relation.equalsIgnoreCase(text)) {
                return relationship;
            }
        }
        throw new IllegalArgumentException("No constant with text '" + text + "' found");
    }
}
