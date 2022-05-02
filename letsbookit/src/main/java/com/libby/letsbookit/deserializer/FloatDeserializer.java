package com.libby.letsbookit.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class FloatDeserializer extends JsonDeserializer<Float> {

  @Override
  public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JacksonException {
    String floatString = jsonParser.getText();
    return Float.valueOf(floatString);
  }
}
