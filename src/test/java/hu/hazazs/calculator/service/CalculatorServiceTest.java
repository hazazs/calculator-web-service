package hu.hazazs.calculator.service;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {
	
	private final CalculatorService calculatorService = new CalculatorService();
	
	@ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
	@MethodSource("parametersAddition")
	void addition(final double leftOperand, final double rightOperand, final double result) {
		assertEquals(result, calculatorService.addition(leftOperand, rightOperand));
	}
	
	private static Stream<Arguments> parametersAddition() {
		return Stream.of(
				Arguments.of(4, 7, 11),
				Arguments.of(10, 0, 10),
				Arguments.of(-6, 7, 1),
				Arguments.of(-11, -3, -14),
				Arguments.of(5.6, 4.1, 9.7),
				Arguments.of(0, 0, 0)
			);
	}
	
	@ParameterizedTest(name = "[{index}] {0} - {1} = {2}")
	@MethodSource("parametersSubtraction")
	void subtraction(final double leftOperand, final double rightOperand, final double result) {
		assertEquals(result, calculatorService.subtraction(leftOperand, rightOperand));
	}
	
	private static Stream<Arguments> parametersSubtraction() {
		return Stream.of(
				Arguments.of(4, 7, -3),
				Arguments.of(10, 0, 10),
				Arguments.of(-6, 7, -13),
				Arguments.of(-11, -3, -8),
				Arguments.of(5.6, 4.1, 1.5),
				Arguments.of(0, 0, 0)
			);
	}
	
	@ParameterizedTest(name = "[{index}] {0} * {1} = {2}")
	@MethodSource("parametersMultiplication")
	void multiplication(final double leftOperand, final double rightOperand, final double result) {
		assertEquals(result, calculatorService.multiplication(leftOperand, rightOperand));
	}
	
	private static Stream<Arguments> parametersMultiplication() {
		return Stream.of(
				Arguments.of(4, 7, 28),
				Arguments.of(10, 0, 0),
				Arguments.of(-6, 7, -42),
				Arguments.of(-11, -3, 33),
				Arguments.of(5.6, 4.1, 22.959999999999997),
				Arguments.of(0, 0, 0)
			);
	}
	
	@ParameterizedTest(name = "[{index}] {0} / {1} = {2}")
	@MethodSource("parametersDivision")
	void division(final double leftOperand, final double rightOperand, final double result) {
		assertEquals(result, calculatorService.division(leftOperand, rightOperand));
	}
	
	private static Stream<Arguments> parametersDivision() {
		return Stream.of(
				Arguments.of(4, 7, 0.5714285714285714),
				Arguments.of(10, 0, Double.POSITIVE_INFINITY),
				Arguments.of(-6, 7, -0.8571428571428571),
				Arguments.of(-11, -3, 3.6666666666666665),
				Arguments.of(5.6, 4.1, 1.3658536585365855),
				Arguments.of(0, 0, Double.NaN)
			);
	}
	
}