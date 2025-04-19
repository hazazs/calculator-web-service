package hu.hazazs.calculator.service;

import org.springframework.stereotype.Service;

/**
 * It represents a calculator with its four basic operations.
 * 
 * @author hazazs
 *
 */
@Service
public class CalculatorService {
	
	/**
	 * It adds the @param rightOperand to the @param leftOperand.
	 * 
	 * @param leftOperand left operand of the addition operation
	 * @param rightOperand right operand of the addition operation
	 * @return the result of the addition
	 */
	public double addition(final double leftOperand, final double rightOperand) {
		return leftOperand + rightOperand;
	}
	
	/**
	 * It subtracts the @param rightOperand from the @param leftOperand.
	 * 
	 * @param leftOperand left operand of the subtraction operation
	 * @param rightOperand right operand of the subtraction operation
	 * @return the result of the subtraction
	 */
	public double subtraction(final double leftOperand, final double rightOperand) {
		return leftOperand - rightOperand;
	}
	
	/**
	 * It multiplies the @param leftOperand with the @param rightOperand.
	 * 
	 * @param leftOperand left operand of the multiplication operation
	 * @param rightOperand right operand of the multiplication operation
	 * @return the result of the multiplication
	 */
	public double multiplication(final double leftOperand, final double rightOperand) {
		return leftOperand * rightOperand;
	}
	
	/**
	 * It divides the @param leftOperand by the @param rightOperand.
	 * 
	 * @param leftOperand left operand of the division operation
	 * @param rightOperand right operand of the division operation
	 * @return the result of the division, which will be {@code Double.NaN} in case of dividing by zero.
	 */
	public double division(final double leftOperand, final double rightOperand) {
		try {
			return leftOperand / rightOperand;
		} catch (final ArithmeticException ex) {
			return Double.NaN;
		}
	}

}