package Java.models;

public class Doctor extends User{
    Speciality speciality;

    public Doctor(String name, Integer ID, UserType type) {
        super(name, ID, type);
        this.speciality = null;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
