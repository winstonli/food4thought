package com.food4thought.food4thought.model.pubsub;

/**
 * Created by Roxy on 25/10/14.
 */
public interface Subscriber<P> {

    public void update(PublishCode code, P publisher);

}
