package com.Failure;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by Kirill on 03.03.2018.
 */
public class FailureMain {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("failureAkka");
        ActorRef supervisingActor = system.actorOf(Props.create(SupervisingActor.class), "supervising-actor");
        supervisingActor.tell("failChild", ActorRef.noSender());
    }
}