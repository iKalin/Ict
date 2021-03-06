package cfb.ict;

import java.net.InetSocketAddress;

public class Neighbor {

    final InetSocketAddress address;

    int numberOfAllTransactions, prevNumberOfAllTransactions;
    int numberOfNewTransactions, prevNumberOfNewTransactions;
    int numberOfInvalidTransactions, prevNumberOfInvalidTransactions;

    Neighbor(final String host, final int port) {

        address = new InetSocketAddress(host, port);
    }

    @Override
    public String toString() {

        return address.toString() + ": [" + numberOfNewTransactions + "+" + numberOfInvalidTransactions + "]/" + numberOfAllTransactions
                + " ([" + prevNumberOfNewTransactions + "+" + prevNumberOfInvalidTransactions + "]/" + prevNumberOfAllTransactions + ")";
    }

    void beginNewRound() {

        prevNumberOfAllTransactions = numberOfAllTransactions;
        prevNumberOfNewTransactions = numberOfNewTransactions;
        prevNumberOfInvalidTransactions = numberOfInvalidTransactions;

        numberOfAllTransactions = 0;
        numberOfNewTransactions = 0;
        numberOfInvalidTransactions = 0;
    }
}
