package Java.Models.Status;

import java.util.ArrayList;
import java.util.Arrays;

public class SubtrackStatus extends IStatus {

    private ArrayList<Status> allowedStatus;

    public SubtrackStatus(){
        super();
        this.allowedStatus = new ArrayList(Arrays.asList(Status.Open, Status.InProgress, Status.Completed));
    }

    public void changeStatus(Status status){
        if( this.allowedStatus.contains(status))
            this.currentStatus = status;
        throw new IllegalArgumentException("Status not permitted");
    }

    public Status getFinalStatus(){
        return Status.Completed;
    }
}
