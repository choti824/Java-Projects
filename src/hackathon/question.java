package hackathon;

import java.util.Random;
import java.util.UUID;


public class question implements Comparable<question>{

    public int no_of_users_solved;
    public int no_of_users_attempted;
    int no_of_likes;
    String questionText;
    String name;
    int Id;

    public question(String name, String description, int level, int quesId){
        this.name = name;
        this.questionText = description;
        set_question_difficulty_level(level);
        this.Id = quesId;
    }

    @Override
    public int compareTo(question other){
        return Integer.compare(this.no_of_likes, other.no_of_likes);
    }

    public enum Difficulty_level{
        VERY_HARD,
        HARD,
        MEDIUM,
        EASY,
        VERY_EASY
    }

    Difficulty_level level;

    public void set_question_difficulty_level(int complexity){
        if(complexity == 1){
            this.level = Difficulty_level.VERY_EASY;
        }
        else if(complexity == 2){
            this.level = Difficulty_level.EASY;
        }
        else if(complexity == 3){
            this.level = Difficulty_level.MEDIUM;
        }
        else if(complexity == 4){
            this.level = Difficulty_level.HARD;
        }
        else{
            System.out.println("Incorrect value for level.");
        }
    }

    private enum Status{
        NOT_ATTEMPTED,
        ATTEMPTED,
        SUBMITTED
    }

    private Status status;

    public Status get_status(){
        return status;
    }

    public void set_status(int status){
        if(status == 0){
            this.status = Status.NOT_ATTEMPTED;
        }
        else if(status == 1){
            this.status = Status.ATTEMPTED;
        }
        else if(status ==2){
            this.status  = Status.SUBMITTED;
        }
    }

    public static String generaterandomString(int length){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, Math.min(length, uuid.length()));
    }

    public static void like_or_dislike_a_problem(Integer id, int like){
        question ques = Dashboard.get_question(id);
        if(like == 1){
            ques.no_of_likes ++;
        }
        else{
            ques.no_of_likes --;
        }
    }
}
