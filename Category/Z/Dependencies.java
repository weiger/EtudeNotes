import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    public static class DiGraph {
        Set<String> libs;
        Map<String, Set<String>> map = new HashMap<>();

        public DiGraph(Set<String> libs) {
            this.libs = libs;
            for(String lib:libs) {
                map.put(lib, new HashSet<String>());
            }
        }

        public void addDependency(String lib, String dependentLib) {
            map.get(lib).add(dependentLib);
        }

        public Set<String> depends(String lib) {
            return map.get(lib);
        }
    }

    public static List<String> toposort(DiGraph g, String lib) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        if(toposortCycle(g, lib, stack, visited)) {
            stack.clear();
        }
        while(!stack.isEmpty()) {
            result.add(0, stack.pop());
        }
        return result;
    }

    public static boolean toposortCycle(DiGraph g, String lib, Stack<String> stack, Set<String> visited) {
        visited.add(lib);
        for(String parentLib:g.depends(lib)) {
            if(visited.contains(parentLib)) return true;
            if(toposortCycle(g, parentLib, stack, visited)) {
                return true;
            }
        }
        stack.push(lib);
        return false;
    }

    public static void main(String[] args) {
        Set<String> libs = new HashSet<>();
        libs.add("xm.js");
        libs.add("lib.js");
        libs.add("foo.js");
        libs.add("bar.js");
        libs.add("main.js");
        DiGraph g = new DiGraph(libs);
        g.addDependency("foo.js", "bar.js");
        g.addDependency("foo.js", "main.js");
        g.addDependency("bar.js", "lib.js");
        // add cycle here
        // g.addDependency("lib.js", "xm.js");
        g.addDependency("xm.js", "foo.js");
        List<String> result = toposort(g, "xm.js");
        System.out.println(result);
    }
}
