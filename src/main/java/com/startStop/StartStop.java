package com.startStop;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by Kirill on 02.03.2018.
 */
public class StartStop {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("helloakka");
        ActorRef first = system.actorOf(Props.create(StartStopActor1.class), "first");
        first.tell("stop", ActorRef.noSender());
    }
}