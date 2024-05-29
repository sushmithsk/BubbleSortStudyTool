import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Define a List to store pairs of state and capital
        List<Pair<String, String>> statesAndCapitals = new ArrayList<>();

        // Add elements (state, capital) to the list for all 50 states
        statesAndCapitals.add(new Pair <>("Alabama", "Montgomery"));
        statesAndCapitals.add(new Pair <>("Alaska", "Juneau"));
        statesAndCapitals.add(new Pair <>("Arizona", "Phoenix"));
        statesAndCapitals.add(new Pair <>("Arkansas", "Little Rock"));
        statesAndCapitals.add(new Pair <>("California", "Sacramento"));
        statesAndCapitals.add(new Pair <>("Colorado", "Denver"));
        statesAndCapitals.add(new Pair <>("Connecticut", "Hartford"));
        statesAndCapitals.add(new Pair <>("Delaware", "Dover"));
        statesAndCapitals.add(new Pair <>("Florida", "Tallahassee"));
        statesAndCapitals.add(new Pair <>("Georgia", "Atlanta"));
        statesAndCapitals.add(new Pair <>("Hawaii", "Honolulu"));
        statesAndCapitals.add(new Pair <>("Idaho", "Boise"));
        statesAndCapitals.add(new Pair <>("Illinois", "Springfield"));
        statesAndCapitals.add(new Pair <>("Indiana", "Indianapolis"));
        statesAndCapitals.add(new Pair <>("Iowa", "Des Moines"));
        statesAndCapitals.add(new Pair <>("Kansas", "Topeka"));
        statesAndCapitals.add(new Pair <>("Kentucky", "Frankfort"));
        statesAndCapitals.add(new Pair <>("Louisiana", "Baton Rouge"));
        statesAndCapitals.add(new Pair <>("Maine", "Augusta"));
        statesAndCapitals.add(new Pair <>("Maryland", "Annapolis"));
        statesAndCapitals.add(new Pair <>("Massachusetts", "Boston"));
        statesAndCapitals.add(new Pair <>("Michigan", "Lansing"));
        statesAndCapitals.add(new Pair <>("Minnesota", "St. Paul"));
        statesAndCapitals.add(new Pair <>("Mississippi", "Jackson"));
        statesAndCapitals.add(new Pair <>("Missouri", "Jefferson City"));
        statesAndCapitals.add(new Pair <>("Montana", "Helena"));
        statesAndCapitals.add(new Pair <>("Nebraska", "Lincoln"));
        statesAndCapitals.add(new Pair <>("Nevada", "Carson City"));
        statesAndCapitals.add(new Pair <>("New Hampshire", "Concord"));
        statesAndCapitals.add(new Pair <>("New Jersey", "Trenton"));
        statesAndCapitals.add(new Pair <>("New Mexico", "Santa Fe"));
        statesAndCapitals.add(new Pair <>("New York", "Albany"));
        statesAndCapitals.add(new Pair <>("North Carolina", "Raleigh"));
        statesAndCapitals.add(new Pair <>("North Dakota", "Bismarck"));
        statesAndCapitals.add(new Pair <>("Ohio", "Columbus"));
        statesAndCapitals.add(new Pair <>("Oklahoma", "Oklahoma City"));
        statesAndCapitals.add(new Pair <>("Oregon", "Salem"));
        statesAndCapitals.add(new Pair <>("Pennsylvania", "Harrisburg"));
        statesAndCapitals.add(new Pair <>("Rhode Island", "Providence"));
        statesAndCapitals.add(new Pair <>("South Carolina", "Columbia"));
        statesAndCapitals.add(new Pair <>("South Dakota", "Pierre"));
        statesAndCapitals.add(new Pair <>("Tennessee", "Nashville"));
        statesAndCapitals.add(new Pair <>("Texas", "Austin"));
        statesAndCapitals.add(new Pair <>("Utah", "Salt Lake City"));
        statesAndCapitals.add(new Pair <>("Vermont", "Montpelier"));
        statesAndCapitals.add(new Pair <>("Virginia", "Richmond"));
        statesAndCapitals.add(new Pair <>("Washington", "Olympia"));
        statesAndCapitals.add(new Pair <>("West Virginia", "Charleston"));
        statesAndCapitals.add(new Pair <>("Wisconsin", "Madison"));
        statesAndCapitals.add(new Pair <>("Wyoming", "Cheyenne"));

        // Access and print the elements before bubble sort by capital
        System.out.println("Before capital sort:");
        for (Pair<String, String> pair : statesAndCapitals) {
            System.out.println("The capital of " + pair.getFirst() + " is " + pair.getSecond());
        }

        // Sort the list by capital
        bubbleSortByCapitals(statesAndCapitals);

        // Access and print the elements after capital sort
        System.out.println("After capital sort:");
        for (Pair<String, String> pair : statesAndCapitals) {
            System.out.println("The capital of " + pair.getFirst() + " is " + pair.getSecond());
        }

        // Commence the game
        game(statesAndCapitals);
    }

    // Defining the bubble sort function
    private static void bubbleSortByCapitals(List<Pair<String, String>> statesAndCapitals) {
        int size = statesAndCapitals.size();
        List<String> states = new ArrayList<>();
        List<String> capitals = new ArrayList<>();

        // Loop through the list and store all the states and capitals in separate lists
        for (Pair<String, String> pair : statesAndCapitals) {
            states.add(pair.getFirst());
            capitals.add(pair.getSecond());
        }

        // Clear out the original list
        statesAndCapitals.clear();

        // Bubble sort the capitals list
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (capitals.get(j).compareTo(capitals.get(j + 1)) > 0) {
                    swap(capitals, j, j + 1);
                    swap(states, j, j + 1);
                }
            }
        }

        // Update the statesAndCapitals list with the sorted states and capitals
        for (int i = 0; i < size; i++) {
            statesAndCapitals.add(new Pair<>(states.get(i), capitals.get(i)));
        }
    }

    // Defining the game function
    private static void game(List<Pair<String, String>> statesAndCapitals) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the State Capital Game!");
        System.out.println("Guess the capital of each state as they appear!");
        int score = 0;

      //Loop through all the states and capitals
        for (Pair<String, String> stateCapPair : statesAndCapitals) {
            String state = stateCapPair.getFirst();
            String capital = stateCapPair.getSecond();

          //Ask the question and get the answer
            System.out.println("What is the capital of " + state + "?");
            String guess = scanner.next();
          // Clear the input buffer
            scanner.nextLine(); 

            if (guess.equalsIgnoreCase(capital)) {
                score++;
                System.out.println("You answered correctly!");
            } else {
                System.out.println("Incorrect! The capital of " + state + " is " + stateCapPair.getSecond());
            }
        }

        System.out.println("Thank you for playing the capitals game!\nYour score is " + score +
                " out of " + statesAndCapitals.size());
        scanner.close();
    }

    // Function to swap elements in a list
    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Pair class to represent a pair of elements
    private static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }
}
