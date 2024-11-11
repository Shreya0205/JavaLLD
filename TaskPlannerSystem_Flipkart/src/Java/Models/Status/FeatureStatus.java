package Java.Models.Status;

import java.util.ArrayList;
import java.util.Arrays;

public class FeatureStatus extends IStatus {

    private ArrayList<Status> allowedStatus;

    public FeatureStatus(){
        super();
        this.allowedStatus = new ArrayList(Arrays.asList(Status.Open, Status.InProgress, Status.Testing, Status.Deployed));
    }

    public void changeStatus(Status status){
        if( this.allowedStatus.contains(status) ) {
            this.currentStatus = status;
            System.out.println("Status set");
            return;
        }
        throw new IllegalArgumentException("Feature Status not permitted");
    }

    public Status getFinalStatus(){
        return Status.Deployed;
    }
}
