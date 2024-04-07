package designPatterns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import designPatternsExceptions.InvalidSecondDegreeEquationException;

class SecondDegreeEquationTest {

	@Test
	void shouldInstantiateCorrectly() {
		float a = 1.0f;
		float b = 2.0f;
		float c = 3.0f;

		SecondDegreeEquation equation = new SecondDegreeEquation(a, b, c);

		float tolerance = 0.000_000_000_000_1f;
		float obtained;

		obtained = equation.getA();
		assertTrue(Math.abs(a - obtained) <= tolerance);

		obtained = equation.getB();
		assertTrue(Math.abs(b - obtained) <= tolerance);

		obtained = equation.getC();
		assertTrue(Math.abs(c - obtained) <= tolerance);
	}

	@Test
	void shouldThrowsExceptionWithAnInvalidEquation() throws InvalidSecondDegreeEquationException {
		{
			float a = 0.0f;
			float b = 2.0f;
			float c = 3.0f;

			assertThrows(InvalidSecondDegreeEquationException.class, () -> {
				SecondDegreeEquation equation = new SecondDegreeEquation(a, b, c);
			});
		}
	}

	@Test
	void shouldReturnTrueOrFalseAsEquationHaveRealSolution() {
		float a = 1.0f;
		float b = 3.0f;
		float c = -4.0f;

		float a2 = 1.0f;
		float b2 = 2.0f;
		float c2 = 3.0f;

		SecondDegreeEquation equationWithSolution = new SecondDegreeEquation(a, b, c);
		SecondDegreeEquation equationWithoutSolution = new SecondDegreeEquation(a2, b2, c2);

		assertTrue(equationWithSolution.hasRealSolution());
		assertFalse(equationWithoutSolution.hasRealSolution());
	}

	@Test
	void shouldReturnHowManySolutionsCorrectly() {
		float a = 1.0f;
		float b = 2.0f;
		float c = 3.0f;

		float a2 = 1.0f;
		float b2 = 0.0f;
		float c2 = 0.0f;

		float a3 = 1.0f;
		float b3 = 3.0f;
		float c3 = -4.0f;

		SecondDegreeEquation equationWithZeroSolutions = new SecondDegreeEquation(a, b, c);
		SecondDegreeEquation equationWithOneSolution = new SecondDegreeEquation(a2, b2, c2);
		SecondDegreeEquation equationWithTwoSolutions = new SecondDegreeEquation(a3, b3, c3);

		assertEquals(0, equationWithZeroSolutions.howManyRealSolutions());
		assertEquals(1, equationWithOneSolution.howManyRealSolutions());
		assertEquals(2, equationWithTwoSolutions.howManyRealSolutions());

	}

	@Test
	void shouldReturnRealSolutionsCorrectly() {
		float a = 1.0f;
		float b = 3.0f;
		float c = -4.0f;
		float[] expectedResult = { -4.0f, 1.0f };

		SecondDegreeEquation equation = new SecondDegreeEquation(a, b, c);

		assertArrayEquals(expectedResult, equation.getRealSolutions());
	}
}
