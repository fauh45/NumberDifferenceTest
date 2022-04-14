
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import NumberDifference.CalcNUmberDifference;

public class NumberDifferenceTest {
	private CalcNUmberDifference sut;

	/**
	 * Setup = inisiasi sebelum test dijalankan, preparation object
	 * --> pay attention to keep components and test cases small,
	 * --> the trade-off seems acceptable.
	 * --> implicit setup can be used to deine the fixture common for all tests.
	 * --> Small in-line and delegate setup statements may supplement ..
	 * the speciic preconditions on per-test basis.
	 */
	@Before
	public void setUp() throws Exception {
		sut = new CalcNUmberDifference();
	}

	@Test
	public void testInputNBilLuarRange_01() {
		// (1) setup (arrange, build)
		int jumlahDeretBil;
		boolean actual, expected;
		jumlahDeretBil = 15; // bukan berada pada range 1-10
		expected = false;

		// (2) exercise (act, operate)
		actual = sut.validateRangeInputMaxDeret(jumlahDeretBil);

		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	@Test
	public void testInputNBilDalamRange_01() {
		// (1) setup (arrange, build)
		int jumlahDeretBil;
		boolean actual, expected;
		jumlahDeretBil = 5; // berada pada range 1-10
		expected = true;

		// (2) exercise (act, operate)
		actual = sut.validateRangeInputMaxDeret(jumlahDeretBil);

		// (3) verify (assert, check)
		assertEquals(expected, actual);
	}

	/**
	 * Test Case No. 13
	 */
	@Test
	public void testGroup2MedDiff2xLoopMidBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 16, 35));
		String expectedMessage = "Difference : 30\nGroup 2, Medium Difference";
		Integer expectedDifference = 30;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 14
	 */
	@Test
	public void testGroup2MedDiff5xLoopTopBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 4, 54, 5, 5, 5));
		String expectedMessage = "Difference : 50\nGroup 2, Medium Difference";
		Integer expectedDifference = 50;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 15
	 */
	@Test
	public void testGroup2MedDiff9xLoopTopBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 4, 54, 5, 5, 5, 5, 5, 5, 5));
		String expectedMessage = "Difference : 50\nGroup 2, Medium Difference";
		Integer expectedDifference = 50;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 16
	 */
	@Test
	public void testGroup3LargeDiff1xLoopLowerBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 56));
		String expectedMessage = "Difference : 51\nGroup 3, Large Difference";
		Integer expectedDifference = 51;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 17
	 */
	@Test
	public void testGroup3LargeDiff2xLoopUpperLowerBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 4, 56));
		String expectedMessage = "Difference : 52\nGroup 3, Large Difference";
		Integer expectedDifference = 52;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 18
	 */
	@Test
	public void testGroup3LargeDiff5xLoopUpperLowerBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 3, 56, 5, 5, 5));
		String expectedMessage = "Difference : 53\nGroup 3, Large Difference";
		Integer expectedDifference = 53;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 19
	 */
	@Test
	public void testGroup3LargeDiff9xLoopUpperLowerBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 3, 56, 5, 5, 5, 5, 5, 5, 5));
		String expectedMessage = "Difference : 53\nGroup 3, Large Difference";
		Integer expectedDifference = 53;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

}
