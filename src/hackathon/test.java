package hackathon;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

    Scanner scanner = new Scanner(System.in);

    public void setUp(){
        Dashboard dashboard = Dashboard.getinstance();
        // adding questions.
        dashboard.adding_contestant_to_contest("Anmol", "anm@gmail.com", "8901092096", 1);
        dashboard.adding_contestant_to_contest("Mayank", "may@gmail.com", "8901092054", 2);
        dashboard.adding_contestant_to_contest("Suyash", "suy@gmail.com", "8901092023", 3);
        // adding contestant.
        dashboard.adding_question_to_contest("Merge Sort", "Implement merge sort with O(logn) Time Complexity", 2, 1);
        dashboard.adding_question_to_contest("Heap Sort", "Implement Heap sort with O(logn) Time Complexity", 4, 2);
        dashboard.adding_question_to_contest("Dkistra", "Implement Dkistra algorithm", 4, 3);
    }

    public void solvetestflow(Integer quesId, Integer participantId){
        Contestant contestant = Dashboard.usermap.get(participantId);
        contestant.solve(quesId, participantId, 1);
        System.out.println("Do you want to like this problem or not, for like Enter 1 or for unlike enter -1.");
        int number = scanner.nextInt();
        question.like_or_dislike_a_problem(quesId, number);
    }

    public ArrayList<question> solved_by_contestant(Integer userId){
        Contestant contestant = Dashboard.usermap.get(userId);
        return contestant.solved_question;
    }

    public int get_rating_contestant(Integer userId){
        Contestant contestant = Dashboard.usermap.get(userId);
        return contestant.rating;
    }

    public ArrayList<question> list_questions_solved_by_user(Integer userId){
        Contestant contestant = Dashboard.usermap.get(userId);
        return contestant.solved_question;
    }
    
}
