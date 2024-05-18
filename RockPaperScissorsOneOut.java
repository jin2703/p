import java.util.Scanner;

public class RockPaperScissorsOneOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"가위", "바위", "보"};
        
        System.out.println("가위바위보 하나빼기 게임을 시작합니다!");
        
        while (true) {

            System.out.print("가위, 바위, 보 중에서 첫 번째 선택을 입력해주세요: ");
            String userChoice1 = scanner.next().toLowerCase();
            System.out.print("가위, 바위, 보 중에서 두 번째 선택을 입력해주세요: ");
            String userChoice2 = scanner.next().toLowerCase();
            
          
            if (!isValidOption(userChoice1, options) || !isValidOption(userChoice2, options)) {
                System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                continue;
            }
            
          
            String computerChoice1 = options[(int) (Math.random() * options.length)];
            String computerChoice2 = options[(int) (Math.random() * options.length)];
            
          
            System.out.print("첫 번째 선택(" + userChoice1 + ")과 두 번째 선택(" + userChoice2 + ") 중 하나를 제거해주세요: ");
            String userRemoveChoice = scanner.next().toLowerCase();
            String userFinalChoice = userRemoveChoice.equals(userChoice1) ? userChoice2 : userChoice1;
            
           
            String computerRemoveChoice = Math.random() < 0.5 ? computerChoice1 : computerChoice2;
            String computerFinalChoice = computerRemoveChoice.equals(computerChoice1) ? computerChoice2 : computerChoice1;
            
        
            String result = calculateResult(userFinalChoice, computerFinalChoice);
            
         
            System.out.println("컴퓨터의 첫 번째 선택: " + computerChoice1 + ", 두 번째 선택: " + computerChoice2);
            System.out.println("컴퓨터가 제거한 선택: " + computerRemoveChoice);
            System.out.println("컴퓨터의 최종 선택: " + computerFinalChoice);
            System.out.println("결과: " + result);
            
         
            System.out.print("다시 플레이하시겠습니까? (예/아니요): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("예")) {
                break;
            }
        }
        
        System.out.println("게임을 종료합니다.");
        scanner.close();
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
