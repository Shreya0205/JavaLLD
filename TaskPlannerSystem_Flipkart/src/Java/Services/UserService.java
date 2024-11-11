package Java.Services;

import Java.Exceptions.ResourceNotFoundException;
import Java.Models.User;
import Java.Repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private static UserService userService=null;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public User createUser(String name){
        User user = new User(name, null);
        userRepository.save(user);
        return user;
    }

    public User findUser(Integer Id){
        User user = userRepository.findById(Id);
        if (user == null) throw new ResourceNotFoundException("List not found with id: " + Id);
        return user;
    }

}
