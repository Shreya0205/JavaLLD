package Java.Models;

import Java.Models.Status.BugStatus;
import Java.Models.Status.FeatureStatus;
import Java.Models.Status.StoryStatus;

import java.time.LocalDate;

public class TaskFactory {

    public static Task getFeatureTask(Integer id, String title, User creator, User assignee, LocalDate dueDate, String summary, FeatureImpact impact) {
        return new FeatureTask(id, title, creator, assignee, new FeatureStatus(), TaskType.feature, dueDate, summary, impact);
    }

    public static Task getBugTask(Integer id, String title, User creator, User assignee, LocalDate dueDate, BugSeverity severity) {
        return new BugTask(id, title, creator, assignee, new BugStatus(), TaskType.bug, dueDate, severity);
    }

    public static Task getStoryTask(Integer id, String title, User creator, User assignee, LocalDate dueDate, String summary) {
        return new StoryTask(id, title, creator, assignee, new StoryStatus(), TaskType.story, dueDate, summary);
    }

}
