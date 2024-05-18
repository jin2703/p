package midterm;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"가위", "바위", "보"};
        
        System.out.println("가위바위보 게임을 시작합니다!");
        System.out.println("가위, 바위, 보 중에서 하나를 선택해주세요.");

        System.out.print("당신의 선택: ");
        String userChoice = scanner.next().toLowerCase();
        if (!isValidOption(userChoice, options)) {
            System.out.println("잘못된 선택입니다. 가위, 바위, 보 중에서 선택해주세요.");
            return;
        }
        
        int computerChoiceIndex = (int) (Math.random() * options.length);
        String computerChoice = options[computerChoiceIndex];
        
        String result = calculateResult(userChoice, computerChoice);
        
        System.out.println("컴퓨터의 선택: " + computerChoice);
        System.out.println("결과: " + result);
    }
    
    public static boolean isValidOption(String option, String[] options) {
        for (String validOption : options) {
            if (validOption.equals(option)) {
                return true;
            }
        }
        return false;
    }
    
    public static String calculateResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "비겼습니다!";
        } else if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
                   (userChoice.equals("바위") && computerChoice.equals("가위")) ||
                   (userChoice.equals("보") && computerChoice.equals("바위"))) {
            return "당신이 이겼습니다!";
        } else {
            return "컴퓨터가 이겼습니다!";
        }
    }
}
