package main;

import main.data.Statement;
import main.rental.Rental;

import java.util.List;

class StatementPresenter {
    private Statement statement;

    public StatementPresenter(Statement statement) {
        this.statement = statement;
    }

    public String build() {
        List<Rental> rentals = statement.getRentals();
        String result = getStatementHeader();
        result += getStatementBody(rentals);
        result += getStatementFooter(rentals);
        return result;
    }

    private String getStatementHeader() {
        return "Rental Record for " + statement.getName() + "\n";
    }

    private String getStatementFooter(List<Rental> rentals) {
        double totalAmount = rentals.stream().map(Rental::getRentalAmount).mapToDouble(Double::new).sum();
        int frequentRenterPoints = rentals.stream().map(Rental::getFrequentRenterPoints).mapToInt(Integer::new).sum();

        String footer = "";
        footer += "You owed " + String.valueOf(totalAmount) + "\n";
        footer += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return footer;
    }

    private String getStatementBody(List<Rental> rentals) {
        String body = "";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovieTitle() + "\t"
                    + String.valueOf(rental.getRentalAmount()) + "\n";
        }
        return body;
    }
}
