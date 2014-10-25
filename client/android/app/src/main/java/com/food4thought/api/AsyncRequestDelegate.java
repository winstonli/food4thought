package com.food4thought.api;

public interface AsyncRequestDelegate {

  public void success(String result);
  
  public void failure();

}