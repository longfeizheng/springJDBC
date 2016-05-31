package com.merryyou.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class Streams {
    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );

        final long totalPointsOfOpenTaskStatus = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("Total points:" + totalPointsOfOpenTaskStatus);

        final double totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);

        final Map<Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        final Collection<String> result = tasks
                .stream()
                .mapToInt(Task::getPoints)
                .asLongStream()
                .mapToDouble( points -> points/totalPoints)
                .boxed()
                .mapToLong( weight -> (long)(weight*100))
                .mapToObj( percentage -> percentage+"%")
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private enum Status {
        OPEN, CLOSED
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "status=" + status +
                    ", points=" + points +
                    '}';
        }
    }
}
