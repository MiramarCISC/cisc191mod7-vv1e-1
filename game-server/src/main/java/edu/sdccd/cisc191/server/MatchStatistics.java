package edu.sdccd.cisc191.server;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Tracks server-wide match statistics shared by many gRPC request threads.
 */
public class MatchStatistics {

    private final AtomicInteger joinedMatchCount = new AtomicInteger(0);
    private final AtomicInteger completedMatchCount = new AtomicInteger(0);

    public void recordJoin() {
        joinedMatchCount.incrementAndGet();
    }

    public void recordCompletion() {
        completedMatchCount.incrementAndGet();
    }

    public int getJoinedMatchCount() {
        return joinedMatchCount.get();
    }

    public int getCompletedMatchCount() {
        return completedMatchCount.get();
    }

    public String buildStatusLine() {
        return String.format("Server stats: %d joined, %d completed", getJoinedMatchCount(), getCompletedMatchCount());
    }
}
