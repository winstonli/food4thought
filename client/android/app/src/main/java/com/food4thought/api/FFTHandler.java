package com.food4thought.api;

import com.google.gson.JsonElement;

public interface FFTHandler {
  
  public void jsonReceived(JsonElement json);

  public void failed();

}
