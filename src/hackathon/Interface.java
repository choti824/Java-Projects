package hackathon;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "Here are the following actions you want to take.\n"+
            "1. if you want to find the rating of a contestant press 1.\n"+
            "2. if you want to solve the problem press the 2. \n"+
            "3. if you want to get the list of problems solved by participant press 3."
        );
        int op = scanner.nextInt();

        test testing = new test();
        testing.setUp();

        switch(op){
            case 1:
                System.out.println("Please enter the userId");
                int userId = scanner.nextInt();
                System.out.println(testing.get_rating_contestant(userId));
                Interface.main(args);
            case 2:
                System.out.println("please enter the userId");
                int user = scanner.nextInt();
                System.out.println("Plese enter the quesId");
                int quesId = scanner.nextInt();
                testing.solvetestflow(quesId, user);
                Interface.main(args);
            case 3:
                System.out.println(("please enter the userId whose list of questions u want"));
                int use = scanner.nextInt();
                System.out.println(Dashboard.quesmap);
                System.out.println(testing.list_questions_solved_by_user(use));
                Interface.main(args);
        }
    }   
}

// things that we need to test.
// 1. first add questions and contestants to the contest.
// 2. solve , like, unlike the problem.
// 3. get top N questions and N ranked participants.
// 4. problems solved by particular contestant.
// 5. get score or rank of a contestant.
