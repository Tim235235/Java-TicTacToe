import java.util.*;
import java.util.stream.Collectors;

public class TicTacToe {
    public static List<Integer> xo_placer() {
        List<Integer> coordinates = new ArrayList<>();
        System.out.print("Enter the coordinates: ");
        Scanner scanner = new Scanner(System.in);
        String cords = scanner.nextLine().trim();
        List<String> cords_list = Arrays.asList(cords.split(","));
        for (String number : cords_list) {
            coordinates.add(Integer.parseInt(number.trim()));
        }

        return coordinates;
    }

    public static boolean win_checker(String[][] field, String turn) {
        boolean end_game = false;
        List<String> column_check = new ArrayList<>();
        List<String> diag_check1 = new ArrayList<>();
        List<String> diag_check2 = new ArrayList<>();
        for (String[] row : field) {
            Set<String> set = new HashSet<String>(Arrays.asList(row));
            if (set.size() == 1 && !set.contains("-"))
                {
                end_game = true;
            }
        }
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                column_check.add(field[row][col]);
            }
        }
        if (Collections.frequency(column_check.subList(0, 3), turn)>= 3 ||
                Collections.frequency(column_check.subList(3, 6), turn)>= 3 ||
                Collections.frequency(column_check.subList(6, 9), turn)>= 3){
            end_game = true;
        }

        for (int i = 0; i < 3; i++){
            diag_check1.add(field[i][i]);
        }

        for (int i = 0; i < 3; i++){
            diag_check2.add(field[i][2 - i]);
        }

        if (Collections.frequency(diag_check2, turn) >= 3 ||
                Collections.frequency(diag_check1, turn) >= 3){
            end_game = true;
        }

        return end_game;
    }

    public static void turn_placer() {
        String[][] matrix =
                {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        String turn = "X";
        int turn_counter = 1;

        while (true) {
            if (turn_counter % 2 == 0) {
                turn = "X";
            } else {
                turn = "O";
            }
            System.out.println();
            System.out.println("-------Its " + turn + "'s turn-------");
            for (String[] row : matrix) {
                System.out.println(Arrays.deepToString(row));
            }
            List<Integer> place = xo_placer();
            int x_cord = place.get(0) - 1;
            int y_cord = place.get(1) - 1;
            if (matrix[x_cord][y_cord] == "-")
            {
                matrix[x_cord][y_cord] = turn;
                turn_counter += 1;
            }
            else{
                System.out.println("please enter a valid coordinate");
                continue;
            }
            if (win_checker(matrix, turn))
            {
                for (String[] row : matrix) {
                    System.out.println(Arrays.deepToString(row));
                }
                System.out.println("Winner is " + turn);
                break;
            }
        }
    }

    public static void main(String[] args) {
        turn_placer();
    }
}
