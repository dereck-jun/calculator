package com.example.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String userCommand = "";

        while (!userCommand.equalsIgnoreCase("exit")) {
            try {
                System.out.println("== 작업을 선택해주세요 ==");
                System.out.println("(1) 계산기 | (2) 결과 확인 | (3) 최근 값 하나 제거 | (4) 저장된 값 변경");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> handleCalculation(scanner, calculator);
                    case 2 -> handlePrintResults(calculator);
                    case 3 -> handleRemoveResult(calculator);
                    case 4 -> handleUpdateResult(scanner, calculator);
                    default -> System.out.println("목록에 없는 값입니다.");
                }
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("저장된 값이 없거나 잘못된 인덱스 지정입니다.");
                scanner.nextLine(); // 개행 문자 제거
            } catch (InputMismatchException ime) {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine(); // 개행 문자 제거
            }

            scanner.nextLine(); // 개행 문자 제거

            System.out.print("작업을 종료하시겠습니까? (exit 입력 시 종료) > ");
            userCommand = scanner.nextLine();
        }
        scanner.close();
    }

    // 계산기
    private static void handleCalculation(Scanner scanner, Calculator calculator) {
        System.out.print("0을 포함한 양의 정수를 입력해주세요 (1) > ");
        int firstNum = scanner.nextInt();

        System.out.print("0을 포함한 양의 정수를 입력해주세요 (2) > ");
        int secondNum = scanner.nextInt();

        System.out.print("연산 기호를 입력해주세요 > ");
        char operator = scanner.next().charAt(0);

        double result = calculator.calculateAndSave(firstNum, secondNum, operator);
        System.out.println("작업 결과 > " + result);
    }

    // 최근 결과 출력
    private static void handlePrintResults(Calculator calculator) {
        System.out.println("=== 최근 결과 출력 ===");
        calculator.printNumbers();
    }

    // 첫 번째 결과 삭제
    private static void handleRemoveResult(Calculator calculator) {
        calculator.removeFirstResult();
        System.out.println("=== 제거 후 남은 값 ===");
        calculator.printNumbers();
    }

    // 특정 인덱스 값 수정
    private static void handleUpdateResult(Scanner scanner, Calculator calculator) {
        System.out.print("변경할 인덱스를 입력해주세요 > ");
        int idx = scanner.nextInt();

        System.out.print("값을 입력해주세요 > ");
        double value = scanner.nextDouble();
        calculator.setNumbers(idx, value);
    }
}
