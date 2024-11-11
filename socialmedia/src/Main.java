//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        https://leetcode.com/discuss/interview-question/5011123/Flipkart-SDE-2-Machine-Coding-April-12
        
        Portal portal = new Portal();

        portal.register("lucious");
        portal.register("albus");
        portal.register("tom");

        portal.login("tom");
        portal.postItem("I am going to be the darkest dark wizard of all time");
        portal.postItem("I am lord Voldemort btw 3:)");

        portal.logout();

        portal.login("lucious");
        portal.follow("tom");
        portal.upvote(1);
        portal.addComment(1, "I am with you dark lord!");
        portal.logout();

        portal.login("albus");
        portal.postItem("Happiness can be found, even in the darkest of times, if one only remembers to turn on the light");

        portal.follow("tom");

        portal.downvote(1);
        portal.downvote(2);

        portal.addComment(2, "LOL");
        System.out.println("______________________");
        portal.showNewsFeed();
    }
}
