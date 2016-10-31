package ch.makery.address.model;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ch.makery.address.util.LocalDateAdapter;
import javafx.beans.property.*;

/**
 * Model class for a Person.
 *
 *
 */
public class Person {

    private static final Logger logger = Logger.getLogger(Person.class.getName());

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty attendedShahriya;

    private static int countPersons = 0;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
        Person.countPersons++;
        logger.log(Level.INFO, "Persons in application: " + Person.countPersons);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.attendedShahriya = new SimpleStringProperty("false");
        Person.countPersons++;
        logger.log(Level.INFO, "Persons in application: " + Person.countPersons);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getAttendedShahriya() {
        return attendedShahriya.get();
    }

    public StringProperty attendedShahriyaProperty() {
        return attendedShahriya;
    }

    public void setAttendedShahriya(String attendedShahriya) {
        this.attendedShahriya.set(attendedShahriya);
    }

    public static int getCountPersons() {
        return countPersons;
    }

    public static void setCountPersons(int countPersons) {
        Person.countPersons = countPersons;
    }
}