
import static org.junit.Assert.*;

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

}
