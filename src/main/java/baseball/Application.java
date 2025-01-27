package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isRunning = true;
        while (isRunning) {
            List<Integer> computer = generateComputerNumbers();
            boolean isGameEnded = playGame(computer);

            if (isGameEnded) {
                isRunning = askRestart(); // 재시작 여부 확인
            }
        }
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static boolean playGame(List<Integer> computer) {
        while (true) {
            String userInput = getUserInput(); // 잘못된 입력 시 예외 발생
            List<Integer> userNumbers = parseInput(userInput);
            String result = compareNumbers(computer, userNumbers);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        validateInput(input); // 입력값 검증, 예외 발생 가능
        return input;
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("입력 값은 비어 있을 수 없습니다.");
            System.out.println("프로그램이 종료되었습니다.");
            throw new IllegalArgumentException("입력 값은 비어 있을 수 없습니다.");
        }
        if (input.length() != 3 || !input.matches("\\d{3}")) {
            System.out.println("입력 값은 3자리의 숫자여야 합니다.");
            System.out.println("프로그램이 종료되었습니다.");
            throw new IllegalArgumentException("입력 값은 3자리의 숫자여야 합니다.");
        }

        List<Integer> digits = parseInput(input);
        if (digits.size() != 3 || digits.stream().distinct().count() != 3) {
            System.out.println("입력 값은 서로 다른 숫자여야 합니다.");
            System.out.println("프로그램이 종료되었습니다.");
            throw new IllegalArgumentException("입력 값은 서로 다른 숫자여야 합니다.");
        }
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private static String compareNumbers(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private static boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (!input.equals("1") && !input.equals("2")) {
            System.out.println("입력 값은 1 또는 2여야 합니다.");
            System.out.println("프로그램이 종료되었습니다.");
            throw new IllegalArgumentException("입력 값은 1 또는 2여야 합니다.");
        }

        return input.equals("1");
    }
}
