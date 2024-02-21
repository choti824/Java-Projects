package hackathon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class Dashboard {
    public static HashMap<Integer, question> quesmap = new HashMap<>();
    public static HashMap<Integer, Contestant> usermap = new HashMap<>();

    private static Dashboard dashboard = new Dashboard();
    private Dashboard(){}
    public static Dashboard getinstance(){
        return dashboard;
    }

    public void adding_question_to_contest(String name, String description, int level, int quesId){
        question ques = new question(name, description, level, quesId);
        Dashboard.quesmap.put(quesId, ques);
    }

    public void adding_contestant_to_contest(String name, String email_id, String contact_no, int userId){
        Contestant user = new Contestant(name, email_id, contact_no, userId);
        Dashboard.usermap.put(userId, user);
    }

    public static question get_question(Integer Id){
            return quesmap.get(Id);
    }

    public Contestant get_contestant(Integer userId){
            return usermap.get(userId);
    }
    // top n ranked contestants based on their rating.
    public ArrayList<Contestant> list_of_contestants(int number){
        Collection<Contestant> total_participants = Dashboard.usermap.values();
        ArrayList<Contestant> list = new ArrayList<>(total_participants);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    // top n ranked quesitons based on their likes and dislikes.
    public ArrayList<question> list_of_questions(int number){
        Collection<question> total_questions = Dashboard.quesmap.values();
        ArrayList<question> list = new ArrayList<>(total_questions);
        Collections.sort(list, Collections.reverseOrder());
        return list;

    }
    
}
