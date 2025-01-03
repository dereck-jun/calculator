package com.example.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loopStr = "";

        while (!loopStr.equalsIgnoreCase("exit")) {
            try {
                System.out.print("첫 번째 0을 포함한 양의 정수를 입력해주세요 > ");
                int firstNum = scanner.nextInt();
                validateNumber(firstNum);

                System.out.print("두 번째 0을 포함한 양의 정수를 입력해주세요 > ");
                int secondNum = scanner.nextInt();

                System.out.print("연산 기호를 입력해주세요 > ");
                scanner.nextLine(); // 개행 문자 제거 용도
                char operator = scanner.nextLine().charAt(0);

                switch (operator) {
                    case '+' -> System.out.println("덧셈 결과 > " + (firstNum + secondNum));
                    case '-' -> System.out.println("뺄셈 결과 > " + (firstNum - secondNum));
                    case '*' -> System.out.println("곱셈 결과 > " + (firstNum * secondNum));
                    case '/' -> System.out.println("나눗셈 결과 > " + (double) firstNum / secondNum);
                    default -> {
                        System.out.println("지원하지 않는 연산 기호입니다.");
                        continue;
                    }
                }
            } catch (InputMismatchException ime) {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine();
                continue;
            } catch (IllegalArgumentException iae) {
                System.out.println("0을 포함한 양의 정수만을 입력해야 합니다.");
                scanner.nextLine();
                continue;
            }

            System.out.print("계속 진행하시겠습니까? (exit 입력 시 종료) > ");
            loopStr = scanner.nextLine();
        }
    }

    private static void validateNumber(int num) {
        if (num >= 0) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
