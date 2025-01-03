package Java.Models.Status;

import java.util.ArrayList;
import java.util.Arrays;

public class BugStatus extends IStatus {

    private ArrayList<Status> allowedStatus;

    public BugStatus(){
        super();
        this.allowedStatus = new ArrayList(Arrays.asList(Status.Open, Status.InProgress, Status.Fixed));
    }

    public void changeStatus(Status status){
        if( this.allowedStatus.contains(status))
            this.currentStatus = status;
        throw new IllegalArgumentException("Status not permitted");
    }

    public Status getFinalStatus(){
        return Status.Fixed;
    }
}
