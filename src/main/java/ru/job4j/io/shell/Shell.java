package ru.job4j.io.shell;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Shell {
    private static final String ROOT = "/";
    private final Stack<String> stackPath = new Stack<>();

    public void cd(String path) {
        checkPath(path);
    }

    public void checkPath(String path) {
        if (path.startsWith(ROOT)) {
            stackPath.clear();
            String[] elmPath = path.split(ROOT);
            Arrays.stream(elmPath).forEach(stackPath::push);
        } else {
            String[] elmPath = path.split(ROOT);
            for (var elm : elmPath) {
                if (elm.equals("..") && !stackPath.empty()) {
                    stackPath.pop();
                } else if (!elm.equals("..")) {
                    stackPath.push(elm);
                }
            }
        }
    }

    public String path() {
        if (stackPath.empty()) {
            return ROOT;
        }
        return stackPath.stream().filter(x -> !x.equals(""))
                .collect(Collectors.joining(ROOT, ROOT, ""));
    }
}

