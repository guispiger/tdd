package designPatterns;

import designPatternsExceptions.InvalidSecondDegreeEquationException;

public class SecondDegreeEquation {

	private float a;
	private float b;
	private float c;

	public SecondDegreeEquation(float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;

		if (!validateEquation()) {
			throw new InvalidSecondDegreeEquationException();
		}
	}

	private boolean validateEquation() {
		if (validateA()) {
			return true;
		}
		return false;
	}

	private boolean validateA() {
		if (this.a > 0f) {
			return true;
		}
		return false;
	}

	private float returnDelta() {
		return (this.b * this.b) - 4 * this.a * this.c;
	}

	public boolean hasRealSolution() {
		float delta = this.returnDelta();

		if (delta >= 0) {
			return true;
		}
		return false;
	}

	public int howManyRealSolutions() {
		float delta = this.returnDelta();

		if (delta > 0) {
			return 2;
		} 
		
		if (delta == 0) {
			return 1;
		}

		return 0;
	}
	
	public float[] getRealSolutions() {
		float[] realSolutions = new float[2];
		float delta = returnDelta();		
		float solutionOne;
		float solutionTwo;
		
		solutionOne = (- this.b + (float) Math.sqrt(delta)) / (2 * this.a);
		solutionTwo = (- this.b - (float) Math.sqrt(delta)) / (2 * this.a);
	    
		realSolutions = this.orderSolutions(solutionOne, solutionTwo);
		
		return realSolutions;
	}
	
	public float[] orderSolutions(float solutionOne, float solutionTwo) {
		float[] solutions = new float[2];
		
		if(solutionOne < solutionTwo) {
			solutions[0] = solutionOne;
			solutions[1] = solutionTwo;
		} else {
			solutions[0] = solutionTwo;
			solutions[1] = solutionOne;
		}
		
		return solutions;
	}

	public float getA() {
		return a;
	}

	public float getB() {
		return b;
	}

	public float getC() {
		return c;
	}
}
