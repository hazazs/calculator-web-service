package hu.hazazs.calculator.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import hu.hazazs.calculator.service.CalculatorService;
import hu.hazazs.calculator_web_service.GetResultResponse;
import hu.hazazs.calculator_web_service.GetSubtractionRequest;
import hu.hazazs.calculator_web_service.GetAdditionRequest;
import hu.hazazs.calculator_web_service.GetDivisionRequest;
import hu.hazazs.calculator_web_service.GetMultiplicationRequest;

/**
 * This class will be a candidate for processing incoming SOAP messages.
 * 
 * @author hazazs
 *
 */
@Endpoint
public class CalculatorEndpoint {
	
	private final CalculatorService calculatorService;
	
	@Autowired
	public CalculatorEndpoint(final CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	private static final String NAMESPACE_URI = "http://hazazs.hu/calculator-web-service";
	
	/**
	 * It will handle processing SOAP messages for the addition operation.
	 * 
	 * @param request {@link GetAdditionRequest} containing the left and right operand
	 * @return {@link GetResultResponse} containing the result
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdditionRequest")
	@ResponsePayload
	public GetResultResponse addition(@RequestPayload GetAdditionRequest request) {
		final GetResultResponse response = new GetResultResponse();
		
		response.setResult(calculatorService.addition(request.getLeftOperand(), request.getRightOperand()));

		return response;
	}
	
	/**
	 * It will handle processing SOAP messages for the subtraction operation.
	 * 
	 * @param request {@link GetSubtractionRequest} containing the left and right operand
	 * @return {@link GetResultResponse} containing the result
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSubtractionRequest")
	@ResponsePayload
	public GetResultResponse subtraction(@RequestPayload GetSubtractionRequest request) {
		final GetResultResponse response = new GetResultResponse();
		
		response.setResult(calculatorService.subtraction(request.getLeftOperand(), request.getRightOperand()));

		return response;
	}
	
	/**
	 * It will handle processing SOAP messages for the multiplication operation.
	 * 
	 * @param request {@link GetMultiplicationRequest} containing the left and right operand
	 * @return {@link GetResultResponse} containing the result
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMultiplicationRequest")
	@ResponsePayload
	public GetResultResponse multiplication(@RequestPayload GetMultiplicationRequest request) {
		final GetResultResponse response = new GetResultResponse();
		
		response.setResult(calculatorService.multiplication(request.getLeftOperand(), request.getRightOperand()));

		return response;
	}
	
	/**
	 * It will handle processing SOAP messages for the division operation.
	 * 
	 * @param request {@link GetDivisionRequest} containing the left and right operand
	 * @return {@link GetResultResponse} containing the result
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDivisionRequest")
	@ResponsePayload
	public GetResultResponse division(@RequestPayload GetDivisionRequest request) {
		final GetResultResponse response = new GetResultResponse();
		
		response.setResult(calculatorService.division(request.getLeftOperand(), request.getRightOperand()));

		return response;
	}

}