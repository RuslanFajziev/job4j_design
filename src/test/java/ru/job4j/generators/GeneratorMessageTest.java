//package ru.job4j.generators;
//
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//public class GeneratorMessageTest {
//    String template = "I am a ${name}, Who are ${subject}?";
//
//    @Test
//    public void checkGoodArguments() {
//        Map<String, String> mapArg = new HashMap<>();
//        mapArg.put("name", "Petr Arsentev");
//        mapArg.put("subject ", "you");
//        GeneratorMessage generatorMessage = new GeneratorMessage();
//        assertThat("I am a Petr Arsentev, Who are you?", is(generatorMessage.produce(template, mapArg)));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void checkManyArguments() {
//        Map<String, String> mapArg = new HashMap<>();
//        mapArg.put("name", "Petr Arsentev");
//        mapArg.put("subject ", "you");
//        mapArg.put("age ", "45");
//        GeneratorMessage generatorMessage = new GeneratorMessage();
//        String outputMsg = generatorMessage.produce(template, mapArg);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void checkIncorrectArguments() {
//        Map<String, String> mapArg = new HashMap<>();
//        mapArg.put("name", "Petr Arsentev");
//        mapArg.put("age ", "45");
//        GeneratorMessage generatorMessage = new GeneratorMessage();
//        String outputMsg = generatorMessage.produce(template, mapArg);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void checkEmptyArguments() {
//        Map<String, String> mapArg = new HashMap<>();
//        GeneratorMessage generatorMessage = new GeneratorMessage();
//        String outputMsg = generatorMessage.produce(template, mapArg);
//    }
//}