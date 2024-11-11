package Java.Services;

import Java.Models.FeatureImpact;
import Java.Models.*;
import Java.Models.Status.Status;
import Java.Models.Status.SubtrackStatus;
import Java.Repository.SubTrackRepository;
import Java.Repository.TaskRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TaskService {

    private final TaskRepository taskRepository;
    private final SubTrackRepository subTrackRepository;
    static private TaskService taskService;
    UserService userService;

    TaskService(UserService userService){
        this.taskRepository = new TaskRepository();
        this.subTrackRepository = new SubTrackRepository();
        this.userService = userService;
    }

    public static TaskService getInstance(UserService userService){
        if(taskService == null){
            taskService = new TaskService(userService);
        }
        return taskService;
    }

    public Task createFeatureTask(String title, User creatorUser, User asigneeUser, LocalDate dueDate, String summary, FeatureImpact impact){
        Task task = TaskFactory.getFeatureTask(null, title, asigneeUser, creatorUser, dueDate, summary, impact);
        taskRepository.save(task);
        return task;
    }

    public Task createBugTask(String title, User creatorUser, User asigneeUser, LocalDate dueDate, BugSeverity severity){
        Task task = TaskFactory.getBugTask(null, title, creatorUser, asigneeUser, dueDate, severity);
        taskRepository.save(task);
        return task;
    }

    public Task createStoryTask(String title, User creatorUser, User asigneeUser, LocalDate dueDate, String summary){
        Task task = TaskFactory.getStoryTask(null, title, creatorUser, asigneeUser, dueDate, summary);
        taskRepository.save(task);
        return task;
    }

    public SubTrack createSubTrack(String title){
        SubTrack subTrack = new SubTrack(title, new SubtrackStatus());
        subTrackRepository.save(subTrack);
        return subTrack;
    }


    public void changeStatus(Integer id, Status status){
        Task task = taskRepository.findById(id);
        task.getStatus().changeStatus(status);
    }

    public void displayTasks(Integer userId){
        User user = userService.findUser(userId);
        Collection<Task> tasks = taskRepository.findAll();
        HashMap<TaskType, ArrayList<Task>> assignedTasks = new HashMap<>();

        for( TaskType type: TaskType.values()){
            assignedTasks.put(type, new ArrayList<>());
        }

        for(Task task: tasks){
            if ( task.getAsignee() == user ){
                assignedTasks.get(task.getType()).add(task);
            }
        }

        for(TaskType type: assignedTasks.keySet()){
            System.out.println("User have tasks of type: " + type);
            System.out.println(assignedTasks.get(type).toString());
        }

    }



}
