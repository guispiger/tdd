package designPatternsExceptions;

public class InvalidSecondDegreeEquationException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Equation";
	}
}
