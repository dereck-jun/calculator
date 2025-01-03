package com.example.lv2;

import com.example.lv2.exception.ClientException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String userCommand = "";

        while (!userCommand.equalsIgnoreCase("exit")) {
            try {
                System.out.println("== 작업을 선택해주세요 ==");
                System.out.println("(1) 계산기 | (2) 결과 확인 | (3) 최근 값 하나 제거 | (4) 저장된 값 변경 | (5) 초기값 넣기");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> handleCalculation(scanner, calculator);
                    case 2 -> handlePrintResults(calculator);
                    case 3 -> handleRemoveResult(calculator);
                    case 4 -> handleUpdateResult(scanner, calculator);
                    case 5 -> handleInsertInitialValue(scanner, calculator);
                    default -> throw new ClientException("목록에 있는 값을 입력해주세요.");
                }
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("저장된 값이 없거나 잘못된 인덱스 지정입니다.");
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (InputMismatchException ime) {
                System.out.println("타입에 맞지 않는 입력입니다.");
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (ArithmeticException ae) {
                System.out.println("0 으로 나눌 수 없습니다.");
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (ClientException ce) {
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (Exception e) {
                System.out.println("예상하지 못한 에러가 발생했습니다.");
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
        validateNumber(firstNum);

        System.out.print("0을 포함한 양의 정수를 입력해주세요 (2) > ");
        int secondNum = scanner.nextInt();
        validateNumber(secondNum);

        System.out.print("연산 기호를 입력해주세요 > ");
        char operator = scanner.next().charAt(0);

        Number result = calculator.calculate(firstNum, secondNum, operator);
        calculator.printAndSaveResult(result);

        System.out.println("현재 저장된 개수: " + calculator.getNumbers().size());
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
        calculator.updateDataAtIndex(idx, value);

        System.out.println("=== 변경한 값 출력 ===");
        calculator.printNumber(idx);
    }

    // 초기값 설정
    private static void handleInsertInitialValue(Scanner scanner, Calculator calculator) {
        List<Number> tempList = new ArrayList<>();
        System.out.print("넣으려는 초기값의 개수를 입력해주세요 > ");
        int count = scanner.nextInt();
        validateNumber(count);

        for (int i = 0; i < count; i++) {
            System.out.print("저장할 " + i + " 번째 값을 입력해주세요 > ");
            double value = scanner.nextDouble();
            tempList.add(value);
        }
        calculator.setNumbers(tempList);

        System.out.println("=== 입력한 초기값 결과 ===");
        calculator.printNumbers();
    }

    private static void validateNumber(int num) {
        if (num >= 0) {
            return;
        }
        throw new ClientException("0을 포함한 양의 정수만 입력할 수 있습니다.");
    }
}
