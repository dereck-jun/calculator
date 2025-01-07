package com.example.lv3;

import com.example.lv3.exception.ClientException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.example.lv3.operation.OperatorType.fromSymbol;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("exit")) {
            try {
                System.out.println("== 작업을 선택해주세요 ==");
                System.out.println("(1) 계산기 | (2) 결과 확인 | (3) 최근 값 하나 제거 | (4) 특정 인덱스 값 변경 | (5) 초기값 설정 | (6) 입력 값보다 큰 저장 값 조회");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> handleCalculation(scanner, calculator);
                    case 2 -> handlePrintResults(calculator);
                    case 3 -> handleRemoveFirstResult(calculator);
                    case 4 -> handleUpdateResult(scanner, calculator);
                    case 5 -> handleInsertInitialValue(scanner, calculator);
                    case 6 -> handleFindResultsGreaterThanInput(scanner, calculator);
                    default -> throw new ClientException("목록에 없는 값입니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("잘못된 인덱스 지정입니다.");
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (ArithmeticException ae) {
                System.out.println("0으로 나눌 수 없습니다.");
                scanner.nextLine(); // 개행 문자 제거
                continue;
            } catch (ClientException ce) {
                scanner.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("예상치 못한 에러가 발생했습니다.");
            }

            scanner.nextLine(); // 개행 문자 제거

            System.out.print("작업을 종료하시겠습니까? (exit 입력 시 종료) > ");
            userChoice = scanner.nextLine();
        }
        scanner.close();
    }

    private static void handleCalculation(Scanner scanner, ArithmeticCalculator<Number> calculator) {
        System.out.print("숫자를 입력해주세요 (1) > ");
        Number firstNum = scanner.nextBigDecimal();

        System.out.print("숫자를 입력해주세요 (2) > ");
        Number secondNum = scanner.nextBigDecimal();

        System.out.print("연산 기호를 입력해주세요 > ");
        String operator = scanner.next();

        Number result = calculator.calculate(firstNum, secondNum, fromSymbol(operator));
        calculator.printAndSaveResult(result);

        System.out.println("현재 저장된 개수: " + calculator.getNumbers().size());
    }

    private static void handlePrintResults(ArithmeticCalculator<Number> calculator) {
        System.out.println("=== 최근 결과 출력 ===");
        calculator.printNumbers();
    }

    private static void handleRemoveFirstResult(ArithmeticCalculator<Number> calculator) {
        calculator.removeFirstResult();

        System.out.println("=== 제거 후 남은 값 ===");
        calculator.printNumbers();
    }

    private static void handleUpdateResult(Scanner scanner, ArithmeticCalculator<Number> calculator) {
        System.out.print("변경할 인덱스를 입력해주세요 > ");
        int idx = scanner.nextInt();

        System.out.print("값을 입력해주세요 > ");
        Number value = scanner.nextBigDecimal();
        calculator.updateDataAtIndex(idx, value);

        System.out.println("=== 변경한 값 출력 ===");
        calculator.printNumber(idx);
    }

    private static void handleInsertInitialValue(Scanner scanner, ArithmeticCalculator<Number> calculator) {
        List<Number> tempList = new ArrayList<>();
        System.out.print("넣으려는 초기값의 개수를 입력해주세요 > ");
        int count = scanner.nextInt();
        validateNumber(count);

        for (int i = 0; i < count; i++) {
            System.out.print("저장할 " + (i + 1) + " 번째 값을 입력해주세요 > ");
            Number value = scanner.nextBigDecimal();
            tempList.add(value);
        }
        calculator.setNumbers(tempList);

        System.out.println("=== 입력한 초기값 결과 ===");
        calculator.printNumbers();
    }

    private static void handleFindResultsGreaterThanInput(Scanner scanner, ArithmeticCalculator<Number> calculator) {
        System.out.print("검색하려는 값을 입력해주세요 > ");
        Number input = scanner.nextBigDecimal();
        calculator.printNumbersGreaterThanInput(input);
    }

    private static void validateNumber(int num) {
        if (num >= 0) {
            return;
        }
        throw new ClientException("0을 포함한 양의 정수만 입력할 수 있습니다.");
    }
}
