package Model;

public class Member extends User {

    public Member(Integer id, String name, LibraryCard libraryCard) {
        super(id, name, UserType.member, libraryCard);
    }

    public void notifyForLate(String message){
        System.out.println(message);
    }

}
