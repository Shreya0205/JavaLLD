import Java.Models.FeatureImpact;
import Java.Models.*;
import Java.Models.Status.Status;
import Java.Services.SprintService;
import Java.Services.TaskService;
import Java.Services.UserService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/5961562/Flipkart-Machine-Coding-Round-or-SDE-2-Role

        SprintService sprintService = SprintService.getInstance();
        UserService userService = UserService.getInstance();
        TaskService taskService = TaskService.getInstance(userService);

        User user = userService.createUser("shreya");

        Task feature  = taskService.createFeatureTask("feature1", user, user, LocalDate.now(), "testing", FeatureImpact.low );
        Task bug  = taskService.createBugTask("bug1", user, user, LocalDate.now(), BugSeverity.p0 );
        Task story = taskService.createStoryTask("story1",user, user, LocalDate.now(), "testing" );

        taskService.displayTasks(user.getId());
        try {
            taskService.changeStatus(feature.getId(), Status.Completed);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            taskService.changeStatus(feature.getId(), Status.InProgress);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Integer sprintID = sprintService.createSprint();
        sprintService.addTask(feature, sprintID);
        sprintService.addTask(bug, sprintID);
        sprintService.addTask(story, sprintID);
        sprintService.sprintSnapshot(sprintID);

    }
}