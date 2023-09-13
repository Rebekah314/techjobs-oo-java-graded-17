package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }
    public Job( String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString(){
        String unavailable = "Data not available";
        String output =  System.lineSeparator()
                + "ID: " + this.getId() + System.lineSeparator() + "Name: ";
        output += this.getName().isEmpty() ? unavailable : this.getName();
        output += System.lineSeparator() + "Employer: ";
        output += this.getEmployer().getValue().isEmpty() ? unavailable : this.getEmployer().getValue();
        output += System.lineSeparator() + "Location: ";
        output += this.getLocation().getValue().isEmpty() ? unavailable :  this.getLocation().getValue();
        output += System.lineSeparator() + "Position Type: ";
        output += this.getPositionType().getValue().isEmpty() ? unavailable : this.getPositionType().getValue();
        output += System.lineSeparator() + "Core Competency: ";
        output += this.getCoreCompetency().getValue().isEmpty() ? unavailable : this.getCoreCompetency().getValue();
        output += System.lineSeparator();

        if (this.getName().isEmpty() && this.getEmployer().getValue().isEmpty()
                && this.getLocation().getValue().isEmpty() && this.getPositionType().getValue().isEmpty()
                && this.getCoreCompetency().getValue().isEmpty()) {
            output = "OOPS! This job does not seem to exist.";
        }


        return output;
    }
}
