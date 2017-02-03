package main;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class VideoStoreTest {
    private Statement statement;
    private Movie newRelease1;
    private Movie newRelease2;
    private Movie childrens1;
    private Movie regular1;
    private Movie regular2;
    private Movie regular3;

    @Before
	public void setUp ()  {
		statement = new Statement("Fred");
        newRelease1 = new NewReleaseMovie("The Cell");
        newRelease2 = new NewReleaseMovie("The Tigger Movie");
        childrens1 = new ChildrensMovie("The Tigger Movie");
        regular1 = new RegularMovie("Plan 9 from Outer Space");
        regular2 = new RegularMovie("8 1/2");
        regular3 = new RegularMovie("Eraserhead");
    }

	@Test
	public void testSingleNewReleaseStatement () {
        statement.addRental(new Rental(newRelease1, 3));

		assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", statement.make());
	}

	@Test
	public void testDualNewReleaseStatement () {
        statement.addRental(new Rental(newRelease1, 3));
        statement.addRental(new Rental(newRelease2, 3));

		assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", statement.make());
	}

	@Test
	public void testSingleChildrensStatement () {
        statement.addRental(new Rental(childrens1, 3));

		assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", statement.make());
	}

	@Test
	public void testMultipleRegularStatement () {
        statement.addRental(new Rental(regular1, 1));
        statement.addRental(new Rental(regular2, 2));
        statement.addRental(new Rental(regular3, 3));

		assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", statement.make());
	}
}