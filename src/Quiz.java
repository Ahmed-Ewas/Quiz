/*
 Ahmed Hamza Shamat Ewas
// 03 October 2023
// 6
Create a short answer quiz that asks a certain number of players a question and then prints their score.
*/

import java.util.Scanner;
class Player
{
    int id;
    int points;
}
public class Quiz
{
    public static void main (String [] args)
    {
        final int Number_Of_Players = Integer.parseInt(user_input("How many players? "));
        Player[] players = new Player[Number_Of_Players];
        for(int i = 0; i < Number_Of_Players; i++)
        {
            players[i] = makePlayer(0, i+1);
        }
        rules();
        question1(players);
        question2(players);
    }
    public static String user_input(String message)
    {
        Scanner scanner = new Scanner (System.in);
        System.out.println(message);
        String response = scanner.nextLine();
        return response;
    }
    public static Player makePlayer(int points, int id)
    {
        Player player = new Player();
        player.id = id;
        player.points = points;
        return player;
    }
    public static void rules()
    {
        System.out.println("For this quiz the first question is worth 1 point. When you get an answer correct the points for the next question doubles. \nHowever, if you get a question wrong the next question drops back to being worth only 1 point");
        System.out.println(" ");
    }
    public static void question1(Player[] players)
    {
        String answer = null;
        for(int i = 0; i<players.length; i++)
        {
            System.out.println("Player " + (i+1)+ " turn:");
            answer = user_input("First Question: How many primary colours are there? ");
            System.out.println("Player " + (i+1) + " you chose " + answer + " correct?");
            if(answer.equals("3"))
            {
                System.out.println("You answered this question correctly! You have scored 1 point! The next question will now be worth 2 points.");
                players[i].points++;
                System.out.println("You currently have " + players[i].points + " points");
            }
            else
            {
                System.out.println("You answered this question incorrectly! The next question will now be worth 1 point.");
                System.out.println("You currently have " + players[i].points + " points");
            }
            System.out.println("");
        }
    }
    public static void question2(Player[] players)
    {
        for (int i = 0; i < players.length; i++)
        {
            System.out.println("Player " + (i+1) + " turn:");

            for (int j = 0; j < 1; j++)
            {
                String answer = user_input("Second Question: What is the capital of Germany? ");
                System.out.println("Player " + (i+1) + ", you chose " + answer + " correct?");

                if (answer.equals("Berlin"))
                {
                    players[i].points = (players[i].points * 2);
                    if(players[i].points == 0)
                    {
                        players[i].points = players[i].points + 1;
                    }
                    System.out.println("You answered this question correctly! You have scored " + players[i].points + " points!");
                }
                else
                {
                    System.out.println("You answered this question incorrectly! You earned 0 points.");
                }
                System.out.println();
            }
        }
    }
}
