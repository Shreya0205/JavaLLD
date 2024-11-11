package Java.Services;

import Java.Exceptions.ResourceNotFoundException;
import Java.Models.Sprint;
import Java.Models.Task;
import Java.Models.User;
import Java.Repository.SprintRepository;
import Java.Repository.UserRepository;

import java.util.ArrayList;

public class SprintService {

    private final SprintRepository sprintRepository;
    private static SprintService sprintService;

    public SprintService(){
        this.sprintRepository = new SprintRepository();
    }

    public static SprintService getInstance(){
        if(sprintService == null){
            sprintService = new SprintService();
        }
        return sprintService;
    }

    public Integer createSprint(){
        Sprint sprint = new Sprint(null);
        sprintRepository.save(sprint);
        return sprint.getId();
    }

    public void addTask(Task task, Integer id){
        Sprint sprint = sprintRepository.findById(id);
        sprint.addTasks(task);
    }

    public void removeTask(Task task, Integer id){
        Sprint sprint = sprintRepository.findById(id);
        sprint.removeTask(task);
    }

    public void sprintSnapshot(Integer id){
        Sprint sprint = sprintRepository.findById(id);
        ArrayList<Task> tasks = sprint.getTasks();

        for(Task task: tasks){
            System.out.println(task.toString() + "Is on track: " + task.isTaskOnTrack());
        }

    }

}
