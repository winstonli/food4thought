package com.example.myfirstapp;

import com.google.gson.JsonElement;

public interface FFTHandler {
  
  public void jsonReceived(JsonElement newJsonElement);

  public void failed();

}
