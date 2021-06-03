package ru.job4j.findfiles;

import java.util.HashMap;
import java.util.Map;

public class ArgmBase {
    private final Map<String, String> value = new HashMap<>();

    public String getValue(String key) {
        return value.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty parameter list!");
        } else if (args.length < 4) {
            throw new IllegalArgumentException("Parameters must be 4");
        }
        for (var elm : args) {
            String[] arrString = elm.split("=");
            if (arrString.length == 1) {
                throw new IllegalArgumentException("One of the parameters is empty!");
            }
            String keyValue = arrString[0].substring(1);
            if (!(keyValue.equals("d") || keyValue.equals("n") || keyValue.equals("t") || keyValue.equals("o"))) {
                throw new IllegalArgumentException("Starting with Keys Only -d -n -t -o");
            }
            value.put(keyValue, arrString[1]);
        }
    }

    public static ArgmBase of(String[] args) {
        ArgmBase argmBase = new ArgmBase();
        argmBase.parse(args);
        return argmBase;
    }

    public static void main(String[] args) {
        ArgmBase argmBase = ArgmBase.of(new String[]{args[0], args[1], args[2], args[3]});
//        ArgmBase argmBase = ArgmBase.of(new String[]{"-d=d:\\share_vm\\check\\", "-n=xml", "-t=name", "-o=d:\\my.log"});
        System.out.println(argmBase.getValue("d"));
        System.out.println(argmBase.getValue("n"));
        System.out.println(argmBase.getValue("t"));
        System.out.println(argmBase.getValue("o"));
    }
}
