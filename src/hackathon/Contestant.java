package hackathon;

import java.util.ArrayList;

import hackathon.question.Difficulty_level;

public class Contestant implements Comparable<Contestant>{
    Integer userId;
    String name;
    String email_id;
    String contact_no;
    ArrayList<question> solved_question = new ArrayList<>();
    Integer rating;    

    public Contestant(String name, String emailId, String contact_no, int userID){
        this.contact_no = contact_no;
        this.email_id = emailId;
        this.name = name;
        this.userId = userId;
        this.rating = 0;
    }

    @Override
    public int compareTo(Contestant other){
        return Integer.compare(this.rating, other.rating);
    }

    public void solve(Integer quesId , Integer participantId, int status){
        if(Dashboard.quesmap.containsKey(quesId)){
            question ques = Dashboard.quesmap.get(quesId);
            Contestant participant = Dashboard.usermap.get(participantId);
            ques.set_status(status);
            participant.update_rating(status, ques);
            participant.solved_question.add(ques);
        }
    }

    public void update_rating(int status, question ques){
        switch(ques.level){
            case VERY_EASY:
                this.rating += 100;
                break;
            case EASY:
                this.rating += 200;
            case MEDIUM:
                this.rating += 500;
            case HARD:
                this.rating += 700;
                break;
            case VERY_HARD:
                this.rating += 1000;
                break;
        }
    }    
}
