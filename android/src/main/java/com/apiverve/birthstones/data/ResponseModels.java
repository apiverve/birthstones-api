// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     BirthstonesData data = Converter.fromJsonString(jsonString);

package com.apiverve.birthstones.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static BirthstonesData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(BirthstonesData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(BirthstonesData.class);
        writer = mapper.writerFor(BirthstonesData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// BirthstonesData.java

package com.apiverve.birthstones.data;

import com.fasterxml.jackson.annotation.*;

public class BirthstonesData {
    private long month;
    private String monthName;
    private String primaryStone;
    private String[] alternateStones;
    private String color;
    private String meaning;
    private String[] zodiacSigns;
    private double hardness;
    private String mineralFamily;
    private long anniversaryYear;

    @JsonProperty("month")
    public long getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(long value) { this.month = value; }

    @JsonProperty("monthName")
    public String getMonthName() { return monthName; }
    @JsonProperty("monthName")
    public void setMonthName(String value) { this.monthName = value; }

    @JsonProperty("primaryStone")
    public String getPrimaryStone() { return primaryStone; }
    @JsonProperty("primaryStone")
    public void setPrimaryStone(String value) { this.primaryStone = value; }

    @JsonProperty("alternateStones")
    public String[] getAlternateStones() { return alternateStones; }
    @JsonProperty("alternateStones")
    public void setAlternateStones(String[] value) { this.alternateStones = value; }

    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }

    @JsonProperty("meaning")
    public String getMeaning() { return meaning; }
    @JsonProperty("meaning")
    public void setMeaning(String value) { this.meaning = value; }

    @JsonProperty("zodiacSigns")
    public String[] getZodiacSigns() { return zodiacSigns; }
    @JsonProperty("zodiacSigns")
    public void setZodiacSigns(String[] value) { this.zodiacSigns = value; }

    @JsonProperty("hardness")
    public double getHardness() { return hardness; }
    @JsonProperty("hardness")
    public void setHardness(double value) { this.hardness = value; }

    @JsonProperty("mineralFamily")
    public String getMineralFamily() { return mineralFamily; }
    @JsonProperty("mineralFamily")
    public void setMineralFamily(String value) { this.mineralFamily = value; }

    @JsonProperty("anniversaryYear")
    public long getAnniversaryYear() { return anniversaryYear; }
    @JsonProperty("anniversaryYear")
    public void setAnniversaryYear(long value) { this.anniversaryYear = value; }
}