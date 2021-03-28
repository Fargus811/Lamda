package main.java.com.sergeev.task4;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * Task to Write a collector that calculates how many times was clicked each url by users.
 */
public class Task4_4 {

    static Map<String, Long> clickCount(List<LogEntry> logs) {
        Map<String, Long> clickCount = logs.stream().collect(Collectors.groupingBy(LogEntry::getUrl, counting()));
        return clickCount;
    }

    public static void main(String[] args) {
        List<LogEntry> logs = new ArrayList<>();
        logs.add(new LogEntry(new Date(), "Khrusha", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Khrusha", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Karkusha", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Khrusha", "github.com"));
        logs.add(new LogEntry(new Date(), "Karkusha", "github.com"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
        for (Map.Entry<String, Long> entry : clickCount(logs).entrySet()) {
            System.out.println(entry.toString());
        }
    }

    static class LogEntry {
        private Date created;
        private String login;
        private String url;

        public LogEntry(Date created, String login, String url) {
            this.created = created;
            this.login = login;
            this.url = url;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LogEntry logEntry = (LogEntry) o;
            return Objects.equals(created, logEntry.created) && Objects.equals(login, logEntry.login)
                    && Objects.equals(url, logEntry.url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(created, login, url);
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "created=" + created +
                    ", login='" + login + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
