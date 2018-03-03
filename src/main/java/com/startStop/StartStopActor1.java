package com.startStop;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * Created by Kirill on 02.03.2018.
 */
class StartStopActor1 extends AbstractActor {
    @Override
    public void preStart() {
        System.out.println("first started");
        getContext().actorOf(Props.create(StartStopActor2.class), "second");
    }

    @Override
    public void postStop() {
        System.out.println("first stopped");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("stop", s -> {
                    getContext().stop(getSelf());
                })
                .build();
    }
}