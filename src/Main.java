import java.util.*;

public class Main {
    public static String Input(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static char PlayerChoice(){
        String Answer;
        while(true){
            System.out.println("What is your next move: ");
            Answer = Input();
            if(Answer.equals("R") || Answer.equals("P") || Answer.equals("S")){
                break;
            }else if(Answer.length() > 1){
                System.out.println("It should be only one letter: \nR - Rock\nP - Paper\nS - Scissors\nTry again\n");
            }else if(Answer.isEmpty()){
                System.out.println("You have to write one of those: \nR - Rock\nP - Paper\nS - Scissors\nTry again\n");
            }else{
                System.out.println("Something went wrong!\nTry again\n");
            }
        }
        return Answer.charAt(0);
    }

    public static String Answer(char player, char comp) {
        if (player == comp) {
            return "Draw";
        }

        if ((player == 'R' && comp == 'S') ||
                (player == 'P' && comp == 'R') ||
                (player == 'S' && comp == 'P')) {
            return "Win";
        }

        if ((comp == 'R' && player == 'S') ||
                (comp == 'P' && player == 'R') ||
                (comp == 'S' && player == 'P')) {
            return "Loss";
        }
        return "Error";
    }

    public static char CompChoice(){
        char[] moves = {'R', 'P', 'S'};
        return moves[(int) (Math.random() * 3)];
    }

    public static void Game(){
            StartMessage();
        int PlayerPoints = 0;
        int CompPoints = 0;

        while(PlayerPoints < 3 && CompPoints < 3){
            char Player = PlayerChoice();
            char Comp = CompChoice();
            switch (Answer(Player, Comp)) {
                case "Win" -> {
                    ++PlayerPoints;
                    RoundMessage(Player, Comp, true);
                    ShowScores(PlayerPoints, CompPoints);
                }
                case "Loss" -> {
                    ++CompPoints;
                    RoundMessage(Player, Comp, false);
                    ShowScores(PlayerPoints, CompPoints);
                }
                case "Draw" -> {
                    RoundMessage(Player, Comp, true);
                    ShowScores(PlayerPoints, CompPoints);
                }
                case "Error" -> System.out.println("Something went wrong\n");
            }
        }
        FinalMessage(PlayerPoints);
    }

    public static void StartMessage(){
        System.out.println("\tThis is Rock Paper Scissors game!\n " +
                "The rules are simple just chose:\nR - Rock\nP - Paper\nS - Scissors\n" +
                "The game will end when you or computer gets 3 point.");
    }

    public static void RoundMessage(char player, char comp, boolean round){
        System.out.println("Computer choice: " + comp);
        if (player == comp) {
            System.out.println("It is draw!\n");
            return;
        } else if (round) {
            System.out.println("You won this round!\n");
        } else {
            System.out.println("You lost this round!\n");
        }
    }

    public static void ShowScores(int Player, int Comp){
        System.out.println("Scores of the match\n" + "Player: " + Player + " | Computer: " + Comp);
    }

    public static void FinalMessage(int player){
        if(player >= 3){
            System.out.println("\t!!!YOU WON!!!\nIf you want to play more write: yes\nIf you want to exit write: no");
        }else{
            System.out.println("\tYou lost\nIf you want to play more write: yes\nIf you want to exit write: no");
        }
    }

    public static void main(String[] args) {
            while (true){
                Game();
                String game = Input();
                if(!game.equals("yes"))
                    break;
            }
    }
}
