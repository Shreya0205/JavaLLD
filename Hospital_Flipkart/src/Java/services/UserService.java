package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.*;
import Java.repository.UserRepository;

public class UserService {
    private static UserService userService = null;
    private UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepository();
    }

    public static UserService getInstance(){
        if( userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public User createUser(String name, UserType type){
        User user = UserFactory.createUser(type, null, name);
        userRepository.save(user);
        return user;
    }

    public User findUser(Integer Id){
        User user = userRepository.findById(Id);
        if (user == null) throw new ResourceNotFoundException("List not found with id: " + Id);
        return user;
    }

}
