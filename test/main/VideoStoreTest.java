package main;

import main.data.Customer;
import main.data.Movie;
import main.data.Statement;
import main.rental.ChildrensRentalStrategy;
import main.rental.NewReleaseRentalStrategy;
import main.rental.RegularRentalStrategy;
import main.rental.Rental;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class VideoStoreTest {
	private Statement statement;
	private Customer customer;

	private StatementPresenter presenter;
	private Rental newReleaseRental1;
	private Rental newReleaseRental2;
	private Rental childrensRental1;
	private Rental regularRental1;
	private Rental regularRental2;
	private Rental regularRental3;

	@Before
	public void setUp ()  {
		customer = new Customer("Fred");

		newReleaseRental1 = new Rental(new Movie("The Cell"), 3, new NewReleaseRentalStrategy());
		newReleaseRental2 = new Rental(new Movie("The Tigger Movie"), 3, new NewReleaseRentalStrategy());
		childrensRental1 = new Rental(new Movie("The Tigger Movie"), 3, new ChildrensRentalStrategy());
		regularRental1 = new Rental(new Movie("Plan 9 from Outer Space"), 1, new RegularRentalStrategy());
		regularRental2 = new Rental(new Movie("8 1/2"), 2, new RegularRentalStrategy());
		regularRental3 = new Rental(new Movie("Eraserhead"), 3, new RegularRentalStrategy());

		statement = new Statement();
		statement.addCustomer(customer);
		presenter = new StatementPresenter(statement);
	}

	@Test
	public void testSingleNewReleaseStatement () {
		statement.addRental(newReleaseRental1);
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", presenter.build());
	}

	@Test
	public void testDualNewReleaseStatement () {
		statement.addRental(newReleaseRental1);
		statement.addRental(newReleaseRental2);
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", presenter.build());
	}

	@Test
	public void testSingleChildrensStatement () {
		statement.addRental(childrensRental1);
		assertEquals ("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", presenter.build());
	}

	@Test
	public void testMultipleRegularStatement () {
		statement.addRental(regularRental1);
		statement.addRental(regularRental2);
		statement.addRental(regularRental3);
		
		assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", presenter.build());
	}
}