package com.food4thought.food4thought.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 25/10/14.
 */
public class Publisher<P> {

    private P publisher;
    private List<Subscriber<P>> subscribers;

    public Publisher(P publisher) {
        this.publisher = publisher;
        subscribers = new ArrayList<Subscriber<P>>();
    }

    public void subscribe(Subscriber<P> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber<P> subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishWithCode(PublishCode code) {
        for (Subscriber<P> subscriber : subscribers) {
            subscriber.update(code, publisher);
        }
    }

}
