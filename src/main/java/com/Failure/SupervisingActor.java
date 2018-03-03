package com.Failure;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * Created by Kirill on 03.03.2018.
 */
class SupervisingActor extends AbstractActor {
    ActorRef child = getContext().actorOf(Props.create(SupervisedActor.class), "supervised-actor");

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("failChild", f -> {
                    child.tell("fail", getSelf());
                })
                .build();
    }
}