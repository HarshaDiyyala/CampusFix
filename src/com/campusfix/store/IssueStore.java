package com.campusfix.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import com.campusfix.model.Issue;

public class IssueStore {
    private static final List<Issue> ISSUES = Collections.synchronizedList(new ArrayList<>());
    private static final AtomicInteger NEXT_ID = new AtomicInteger(1001);
    static {
        ISSUES.add(new Issue(NEXT_ID.getAndIncrement(), "Priya", "priya@campus.edu", "Wi-Fi / Internet", "Library - 2nd Floor", "Wi-Fi is disconnecting repeatedly in the reading area."));
        ISSUES.add(new Issue(NEXT_ID.getAndIncrement(), "Arjun", "arjun@campus.edu", "Cleanliness", "Block B - Room 204", "The classroom needs cleaning before the next lecture."));
        ISSUES.add(new Issue(NEXT_ID.getAndIncrement(), "Meghana", "meghana@campus.edu", "Electrical", "Main Block - Lab 1", "Two tube lights are not working."));
    }
    public static List<Issue> all() {
        synchronized (ISSUES) { return new ArrayList<>(ISSUES); }
    }
    public static Issue find(int id) {
        synchronized (ISSUES) {
            for (Issue issue : ISSUES) if (issue.getId() == id) return issue;
        }
        return null;
    }
    public static Issue add(String name, String email, String category, String location, String description) {
        Issue issue = new Issue(NEXT_ID.getAndIncrement(), name, email, category, location, description);
        ISSUES.add(0, issue);
        return issue;
    }
    public static int nextIdPreview() { return NEXT_ID.get(); }
}
