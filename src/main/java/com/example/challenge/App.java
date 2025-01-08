package com.example.challenge;

import com.example.challenge.exception.BaseException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("exit")) {
            try {
                System.out.println("== 작업을 선택해주세요 ==");
                System.out.println("(1) 계산기 | (2) 결과 확인 | (3) 최근 값 하나 제거 | (4) 특정 인덱스 값 변경 | (5) 초기값 설정 | (6) 입력 값보다 큰 저장 값 조회");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> handleCalculation(scanner, calculator);
                    case 2 -> handlePrintResults(calculator);
                    case 3 -> handleRemoveFirstResult(calculator);
                    case 4 -> handleUpdateResult(scanner, calculator);
                    case 5 -> handleInsertInitialValue(scanner, calculator);
                    case 6 -> handleFindResultsGreaterThanInput(scanner, calculator);
                    default -> throw new BaseException("목록에 없는 값입니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("잘못된 입력입니다.");
                continue;
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("잘못된 인덱스 지정입니다.");
                continue;
            } catch (ArithmeticException ae) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            } catch (BaseException be) {
                continue;
            } catch (Exception e) {
                System.out.println("예상치 못한 에러가 발생했습니다.");
            }

            System.out.print("작업을 종료하시겠습니까? (exit 입력 시 종료) > ");
            userChoice = scanner.nextLine();
        }
        scanner.close();
    }

    private static void handleCalculation(Scanner scanner, Calculator calculator) {
        System.out.print("수식을 입력해주세요 > ");
        String operator = scanner.nextLine();

        Number result = calculator.calculate(operator);
        calculator.saveAndPrintResult(result);

        System.out.println("현재 저장된 개수: " + calculator.getOperationResults().size());
    }

    private static void handlePrintResults(Calculator calculator) {
        System.out.println("=== 최근 결과 출력 ===");
        calculator.printNumbers();
    }

    private static void handleRemoveFirstResult(Calculator calculator) {
        calculator.removeFirstResult();

        System.out.println("=== 제거 후 남은 값 ===");
        calculator.printNumbers();
    }

    private static void handleUpdateResult(Scanner scanner, Calculator calculator) {
        System.out.print("변경할 인덱스를 입력해주세요 > ");
        int idx = Integer.parseInt(scanner.nextLine());

        System.out.print("값을 입력해주세요 > ");
        Number value = scanner.nextBigDecimal();
        calculator.updateDataAtIndex(idx, value);

        System.out.println("=== 변경한 값 출력 ===");
        calculator.printNumber(idx);
        scanner.nextLine();
    }

    private static void handleInsertInitialValue(Scanner scanner, Calculator calculator) {
        List<Number> tempList = new ArrayList<>();
        System.out.print("넣으려는 초기값의 개수를 입력해주세요 > ");
        int count = Integer.parseInt(scanner.nextLine());
        validateNumber(count);

        for (int i = 0; i < count; i++) {
            System.out.print("저장할 " + (i + 1) + " 번째 값을 입력해주세요 > ");
            Number value = scanner.nextBigDecimal();
            tempList.add(value);
        }
        calculator.setOperationResults(tempList);

        System.out.println("=== 입력한 초기값 결과 ===");
        calculator.printNumbers();
        scanner.nextLine();
    }

    private static void handleFindResultsGreaterThanInput(Scanner scanner, Calculator calculator) {
        System.out.print("검색하려는 값을 입력해주세요 > ");
        Number input = scanner.nextBigDecimal();
        calculator.printNumbersGreaterThanInput(input);
        scanner.nextLine();
    }

    private static void validateNumber(int num) {
        if (num >= 0) {
            return;
        }
        throw new BaseException("0을 포함한 양의 정수만 입력할 수 있습니다.");
    }
}
