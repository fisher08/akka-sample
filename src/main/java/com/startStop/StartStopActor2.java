package com.startStop;

import akka.actor.AbstractActor;

/**
 * Created by Kirill on 02.03.2018.
 */
class StartStopActor2 extends AbstractActor {
    @Override
    public void preStart() {
        System.out.println("second started");
    }

    @Override
    public void postStop() {
        System.out.println("second stopped");
    }

    // Actor.emptyBehavior is a useful placeholder when we don't
    // want to handle any messages in the actor.
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .build();
    }
}