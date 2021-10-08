package com.lobova.java_concurrency.lab6;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * The main class, that demonstrates the work of the company.
 */
public final class Founder {
    private final List<Worker> workers;
    CyclicBarrier cyclicBarrier;

    /**
     * @param company where departments are supposed to calculate concurrently.
     */
    public Founder(final Company company) {
        this.workers = new ArrayList<>(company.getDepartmentsCount());
        this.cyclicBarrier = new CyclicBarrier(company.getDepartmentsCount(),
                company::showCollaborativeResult); // the barrier action(!) param
        for (int i = 0; i < company.getDepartmentsCount(); i++) {
            workers.add(i, new Worker(cyclicBarrier, company.getFreeDepartment(i)));
        }
    }

    /**
     * To run the workers.
     */
    public void start() {
        for (final Runnable worker : workers) {
            new Thread(worker).start();
        }
    }

    /**
     * Here you can change the number of departments in the company.
     * Number of threads depend on it.
     * @param args are not used.
     */
    public static void main(final String[] args) {
        Company company = new Company(4);
        Founder founder = new Founder(company);
        founder.start();
    }
}