package co.uk.openframeworks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Circles {

    private HashMap<String, Set<String>> circle;

    public Circles() {
        circle = new HashMap<String, Set<String>>();
    }

    public void addCircleName(String name) {
        if (!circle.containsKey(name)) {
            circle.put(name, new HashSet<String>());
        }
    }

    public void addCircles(String name, Set<String> circles) {
        if (this.circle.containsKey(name)) {
            this.circle.get(name).addAll(circles);
        } else throw new NullPointerException("Circle with name " + name + " does not exist");
    }

    public HashMap<String, Set<String>> exportCircle() {
        return circle;
    }

}
