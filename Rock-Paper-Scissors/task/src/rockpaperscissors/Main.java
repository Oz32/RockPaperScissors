package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[] options = new String[]{"rock", "paper", "scissors", "lizard", "spock"};
    static String[] options15 = new String[]{"rock", "gun", "lightning", "devil", "dragon", "water", "air", "paper", "sponge", "wolf", "tree", "human", "snake", "scissors", "fire"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String computerChoice = "";
        Player player = new Player();
        Random random = new Random();
        File file = new File("C:\\JavaLessons\\rating.txt");

        System.out.println("Enter your name:");
        player.setName(scanner.nextLine());
        try (Scanner scanner1 = new Scanner(file)) {
            while (scanner1.hasNext()) {
                String[] data = scanner1.nextLine().split(" ");
                if (player.getName().equalsIgnoreCase(data[0])) {
                    player.setRating(Integer.parseInt(data[1]));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Hello, " + player.getName());
        String inputConidtions = scanner.nextLine();
        System.out.println("Okay, let's start");

        if (inputConidtions.equals("rock,gun,lightning,devil,dragon,water,air,paper,sponge,wolf,tree,human,snake,scissors,fire")) {
            while (true) {
                int random15 = random.nextInt(15);
                computerChoice = options15[random15];
                player.setChoice(scanner.nextLine());
                String playerInput15 = player.getChoice();
                if (playerInput15.equals("!exit")) {
                    System.out.println("Bye!");
                    break;
                } else if (playerInput15.equals("!rating")) {
                    System.out.println(player.getRating());
                } else if (Arrays.asList(options15).contains(playerInput15)) {
                    result15(playerInput15, computerChoice, player);
                } else {
                    System.out.println("Invalid input");
                }
            }
        } else {
            while (true) {
                if (inputConidtions.equals("rock,paper,scissors,lizard,spock")) {
                    int randomNumber = random.nextInt(16667);
                    if (randomNumber < 3333) {
                        computerChoice = options[0];
                    } else if (randomNumber >= 3333 && randomNumber < 6666) {
                        computerChoice = options[1];
                    } else if (randomNumber >= 6667 && randomNumber < 10000) {
                        computerChoice = options[2];
                    } else if (randomNumber >= 10000 && randomNumber < 13333) {
                        computerChoice = options[3];
                    } else if (randomNumber >= 13334 && randomNumber < 16667) {
                        computerChoice = options[4];
                    }
                } else {
                    int randomNumber = random.nextInt(10000);
                    if (randomNumber < 3333) {
                        computerChoice = options[0];
                    } else if (randomNumber >= 3333 && randomNumber < 6666) {
                        computerChoice = options[1];
                    } else if (randomNumber >= 6667 && randomNumber < 10000) {
                        computerChoice = options[2];
                    }
                }
                player.setChoice(scanner.nextLine());
                String playerInput = player.getChoice();
                if (playerInput.equals("!exit")) {
                    System.out.println("Bye!");
                    break;
                } else if (playerInput.equals("!rating")) {
                    System.out.println(player.getRating());
                } else if (Arrays.asList(options).contains(playerInput)) {
                    result3or5(playerInput, computerChoice, player);
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public static void result3or5(String playerChoice, String computerChoice, Player player) {
        if (playerChoice.equals(computerChoice)) {
            player.setRating(50);
            System.out.println("There is a draw (" + computerChoice + ")");
        } else if (playerChoice.equals(options[0]) && computerChoice.equals(options[1])
                || playerChoice.equals(options[0]) && computerChoice.equals(options[4])
                || playerChoice.equals(options[1]) && computerChoice.equals(options[2])
                || playerChoice.equals(options[1]) && computerChoice.equals(options[3])
                || playerChoice.equals(options[2]) && computerChoice.equals(options[0])
                || playerChoice.equals(options[2]) && computerChoice.equals(options[4])
                || playerChoice.equals(options[3]) && computerChoice.equals(options[2])
                || playerChoice.equals(options[4]) && computerChoice.equals(options[1])
                || playerChoice.equals(options[4]) && computerChoice.equals(options[3])
                || playerChoice.equals(options[3]) && computerChoice.equals(options[0])) {
            System.out.println("Sorry, but the computer chose " + computerChoice);
        } else if (playerChoice.equals(options[0]) && computerChoice.equals(options[2])
                || playerChoice.equals(options[0]) && computerChoice.equals(options[3])
                || playerChoice.equals(options[1]) && computerChoice.equals(options[0])
                || playerChoice.equals(options[1]) && computerChoice.equals(options[4])
                || playerChoice.equals(options[2]) && computerChoice.equals(options[1])
                || playerChoice.equals(options[2]) && computerChoice.equals(options[3])
                || playerChoice.equals(options[3]) && computerChoice.equals(options[1])
                || playerChoice.equals(options[4]) && computerChoice.equals(options[2])
                || playerChoice.equals(options[4]) && computerChoice.equals(options[0])
                || playerChoice.equals(options[3]) && computerChoice.equals(options[4])) {
            player.setRating(100);
            System.out.println("Well done. The computer chose " + computerChoice + " and failed");
        }
    }

    public static void result15(String playerChoice, String computerChoice, Player player) {
        if (playerChoice.equals(computerChoice)) {
            player.setRating(50);
            System.out.println("There is a draw (" + computerChoice + ")");
            return;
        }
        int indexPlayer = 1;
        int indexComp = 1;
        for (int i = 0; i < options15.length; i++) {
            if (playerChoice.equals(options15[i])) {
                indexPlayer += i;
            } else if (computerChoice.equals(options15[i])) {
                indexComp += i;
            }
        }
        int difference = indexPlayer - indexComp;
        if (indexPlayer >= 8 && difference < 8 && difference > 0 || indexPlayer < 8 && difference >= -14 && difference < -7
                || indexPlayer < 8 && difference > 0 && difference < 7) {
            player.setRating(100);
            System.out.println("Well done. The computer chose " + computerChoice + " and failed");
        } else {
            System.out.println("Sorry, but the computer chose " + computerChoice);
        }
    }
}