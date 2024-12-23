package Services;

import Model.Member;

import java.util.List;

public class NotificationService {

    public void notifyUserOfLateFine(Member member, String message){
        member.notifyForLate(message);
    }

}
