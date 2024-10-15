public class UserBuilderFactory {

    public static User register(String name, UserType userType, Speciality speciality){
        if(userType ==  UserType.Patient){
            return new Patient(name);
        }
        else
            return new Doctor(name, speciality);
    }
}
