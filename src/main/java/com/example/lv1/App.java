package com.example.lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loopStr = "";

        while (!loopStr.equalsIgnoreCase("exit")) {
            System.out.print("첫 번째 양의 정수를 입력해주세요 > ");
            int firstNum = scanner.nextInt();
            if (!validateNumber(firstNum)) {
                continue;
            }

            System.out.print("두 번째 양의 정수를 입력해주세요 > ");
            int secondNum = scanner.nextInt();
            if (!validateNumber(secondNum)) {
                continue;
            }

            System.out.print("연산 기호를 입력해주세요 > ");
            scanner.nextLine(); // 개행 문자 제거 용도
            char operator = scanner.nextLine().charAt(0);

            switch (operator) {
                case '+':
                    System.out.println("덧셈 결과 > " + ((double) firstNum + secondNum));
                    break;
                case '-':
                    System.out.println("뺄셈 결과 > " + ((double) firstNum - secondNum));
                    break;
                case '*':
                    System.out.println("곱셈 결과 > " + (double) firstNum * secondNum);
                    break;
                case '/':
                    System.out.println("나눗셈 결과 > " + (double) firstNum / secondNum);
                    break;
                default:
                    System.out.println("지원하지 않는 연산 기호입니다!");
            }
            System.out.print("계속 진행하시겠습니까? (exit 입력 시 종료) > ");
            loopStr = scanner.nextLine();
        }
    }

    private static boolean validateNumber(int num) {
        if (num <= 0) {
            System.out.println("양의 정수만을 입력해야 합니다!");
            return false;
        }
        return true;
    }
}
