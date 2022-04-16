
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import NumberDifference.CalcNUmberDifference;
import NumberDifference.App;

public class NumberDifferenceTest {
	private CalcNUmberDifference sut;
	private App main_sut;

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

	/**
	 * Test Case yang dibuat oleh Afdal Ramdan Daman Huri
	 */

	/**
	 * Test Case No. 1 (Dibuat oleh Afdal dan diupdate oleh Aldy)
	 */
	@Test
	public void testNRangeNoValidLowBoundary() {
		String expectedMessage = "Number difference can not be processed";
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream("0".getBytes()));

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		App.main(new String[0]);

		System.setIn(stdin);
		System.setOut(stdout);

		String outputText = byteArrayOutputStream.toString();
		String output = outputText.substring(outputText.indexOf(expectedMessage)).trim();
		assertEquals(expectedMessage, output);
	}

	/**
	 * Test Case No. 2 (Dibuat oleh Afdal dan diupdate oleh Aldy)
	 */
	@Test
	public void testNRangeNoValidUpBoundary() {
		String expectedMessage = "Number difference can not be processed";
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream("11".getBytes()));

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		App.main(new String[0]);

		System.setIn(stdin);
		System.setOut(stdout);

		String outputText = byteArrayOutputStream.toString();
		String output = outputText.substring(outputText.indexOf(expectedMessage)).trim();
		assertEquals(expectedMessage, output);
	}

	/**
	 * Test Case No. 3
	 */
	@Test
	public void testNonGroupNoDiffNonLoop() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5));
		String expectedMessage = "Difference : 0\nNon Group, There's no difference";
		Integer expectedDifference = 0;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 4
	 */
	@Test
	public void testNonGroupNoDiff1xLoop() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 5));
		String expectedMessage = "Difference : 0\nNon Group, There's no difference";
		Integer expectedDifference = 0;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 5
	 */
	@Test
	public void testNonGroupNoDiff2xLoop() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 5, 5));
		String expectedMessage = "Difference : 0\nNon Group, There's no difference";
		Integer expectedDifference = 0;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 6
	 */
	@Test
	public void testNonGroupNoDiff5xLoop() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5));
		String expectedMessage = "Difference : 0\nNon Group, There's no difference";
		Integer expectedDifference = 0;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case yang dibuat oleh Aldy Akbarrizky
	 */

	/**
	 * Test Case No. 7
	 */
	@Test
	public void testNonGroupNoDiff9xLoop() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
		String expectedMessage = "Difference : 0\nNon Group, There's no difference";
		Integer expectedDifference = 0;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 8
	 */
	@Test
	public void testGroup1SmallDiff1xLoopLowBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 4));
		String expectedMessage = "Difference : 1\nGroup 1, Small Difference";
		Integer expectedDifference = 1;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 9
	 */
	@Test
	public void testGroup1SmallDiff2xLoopMidBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 4, 9));
		String expectedMessage = "Difference : 5\nGroup 1, Small Difference";
		Integer expectedDifference = 5;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 10
	 */
	@Test
	public void testGroup1SmallDiff5xLoopTopBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 1, 11, 5, 5, 5));
		String expectedMessage = "Difference : 10\nGroup 1, Small Difference";
		Integer expectedDifference = 10;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 11
	 */
	@Test
	public void testGroup1SmallDiff9xLoopTopBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 1, 11, 5, 5, 5, 5, 5, 5, 5));
		String expectedMessage = "Difference : 10\nGroup 1, Small Difference";
		Integer expectedDifference = 10;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case No. 12
	 */
	@Test
	public void testGroup2MedDiff1xLoopLowBoundary() {
		ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(5, 16));
		String expectedMessage = "Difference : 11\nGroup 2, Medium Difference";
		Integer expectedDifference = 11;

		Integer actualDifference = sut.numberDiffirenceProcess(testData);
		assertEquals(expectedDifference, actualDifference);

		String actualMessage = sut.groupingDifference(actualDifference);
		assertEquals(expectedMessage, actualMessage);
	}

	/**
	 * Test Case yang dibuat oleh Muhammad Fauzan Lubis
	 */

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
