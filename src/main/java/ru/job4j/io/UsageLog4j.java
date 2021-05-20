package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int intVar = 10;
        byte byteVar = 2;
        long longVar = 4;
        float floatVar = 2.3F;
        double doubleVar = 12.0;
        Boolean booleanVar = true;
        String stringVar = "Bla bla";
        char charVar = 0xd83d;
        LOG.debug("Print any var: int {}, byte {}, long {}, float {}, double {}, Boolean {}, String {}, char {}",
                intVar, byteVar, longVar, floatVar, doubleVar, booleanVar, stringVar, charVar);
    }
}