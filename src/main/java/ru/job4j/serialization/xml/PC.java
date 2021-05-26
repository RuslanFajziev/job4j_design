package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.io.StringReader;
import java.util.Arrays;

@XmlRootElement(name = "PC")
@XmlAccessorType(XmlAccessType.FIELD)
public class PC {
    @XmlAttribute
    private boolean gamingPc;
    @XmlAttribute
    private boolean waterColl;
    @XmlAttribute
    private int guaranteePeriod;
    @XmlAttribute
    private String brand;
    @XmlElementWrapper
    @XmlElement(name = "cpuType")
    private String[] cpuTypes;
    private MB mb;

    public PC() {
    }

    public PC(boolean gamingPc, boolean waterColl, int guaranteePeriod, String brand, MB mb, String... cpuTypes) {
        this.gamingPc = gamingPc;
        this.waterColl = waterColl;
        this.guaranteePeriod = guaranteePeriod;
        this.brand = brand;
        this.cpuTypes = cpuTypes;
        this.mb = mb;
    }

    @Override
    public String toString() {
        return "PC{"
                + "gamingPc=" + gamingPc
                + ", waterColl=" + waterColl
                + ", guaranteePeriod=" + guaranteePeriod
                + ", brand='" + brand + '\''
                + ", mb=" + mb
                + ", cpuType=" + Arrays.toString(cpuTypes)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        PC pc = new PC(true, true, 36, "Sitylinke",
                new MB(false, 32, "LGA 2066"), "Pentium", "Celeron");
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(PC.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(pc, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        // Для десериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            PC result = (PC) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}

@com.sun.xml.txw2.annotation.XmlElement(value = "MB")
class MB {
    @XmlAttribute
    private String socket;
    @XmlAttribute
    private boolean serverBoard;
    @XmlAttribute
    private int maxRamSize;

    public MB() {
    }

    public MB(boolean serverBoard, int maxRamSize, String socket) {
        this.serverBoard = serverBoard;
        this.maxRamSize = maxRamSize;
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "MB{"
                + "serverBoard=" + serverBoard
                + ", maxRamSize=" + maxRamSize
                + ", socket='" + socket + '\''
                + '}';
    }
}
