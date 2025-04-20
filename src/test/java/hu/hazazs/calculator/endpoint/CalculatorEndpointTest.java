package hu.hazazs.calculator.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import hu.hazazs.calculator.service.CalculatorService;
import hu.hazazs.calculator_web_service.GetAdditionRequest;
import hu.hazazs.calculator_web_service.GetDivisionRequest;
import hu.hazazs.calculator_web_service.GetMultiplicationRequest;
import hu.hazazs.calculator_web_service.GetSubtractionRequest;

class CalculatorEndpointTest {
	
	private final CalculatorEndpoint calculatorEndpoint = new CalculatorEndpoint(new CalculatorService());
	
	@ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
	@MethodSource("parametersAddition")
	void addition(final double leftOperand, final double rightOperand, final double result) {
		final GetAdditionRequest getAdditionRequest = new GetAdditionRequest();
		
		getAdditionRequest.setLeftOperand(leftOperand);
		getAdditionRequest.setRightOperand(rightOperand);
		
		assertEquals(result, calculatorEndpoint.addition(getAdditionRequest).getResult());
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
		final GetSubtractionRequest getSubtractionRequest = new GetSubtractionRequest();
		
		getSubtractionRequest.setLeftOperand(leftOperand);
		getSubtractionRequest.setRightOperand(rightOperand);
		
		assertEquals(result, calculatorEndpoint.subtraction(getSubtractionRequest).getResult());
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
		final GetMultiplicationRequest getMultiplicationRequest = new GetMultiplicationRequest();
		
		getMultiplicationRequest.setLeftOperand(leftOperand);
		getMultiplicationRequest.setRightOperand(rightOperand);
		
		assertEquals(result, calculatorEndpoint.multiplication(getMultiplicationRequest).getResult());
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
		final GetDivisionRequest getDivisionRequest = new GetDivisionRequest();
		
		getDivisionRequest.setLeftOperand(leftOperand);
		getDivisionRequest.setRightOperand(rightOperand);
		
		assertEquals(result, calculatorEndpoint.division(getDivisionRequest).getResult());
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