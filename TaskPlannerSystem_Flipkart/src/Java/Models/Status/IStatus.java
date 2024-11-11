package Java.Models.Status;

public class IStatus {

    Status currentStatus;

    public IStatus() {
        this.currentStatus = Status.Open;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void changeStatus(Status status){
        this.currentStatus = status;
    }

    public Status getFinalStatus(){
        return Status.Deployed;
    }
}
