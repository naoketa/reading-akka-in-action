package com.example

import akka.actor.Actor
import akka.util.Timeout

object BoxOffice {

}

class BoxOffice(implicit timeout: Timeout) extends Actor {
  override def receive: Receive = ???
}