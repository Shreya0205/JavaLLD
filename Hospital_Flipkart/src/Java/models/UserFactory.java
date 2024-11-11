package Java.models;

public class UserFactory {

    public static User createUser(UserType userType, Integer id, String name){
        if(userType == UserType.patient){
            return new Patient(name, id, userType);
        }
        else
            return new Doctor(name, id, userType);
    }

}
