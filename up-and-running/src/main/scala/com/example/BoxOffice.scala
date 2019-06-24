package com.example

import akka.actor.Actor
import akka.util.Timeout
import com.example.BoxOffice.{CreateEvent, EventCreated, EventExists}

object BoxOffice {
  case class CreateEvent(name: String, tickets: Int)

  case class GetEvent(name: String)

  case object GetEvents

  case class GetTickets(event: String, tickets: Int)

  case class CancelEvent(name: String)

  case class Event(name: String, tickets: Int)

  case class Events(events: Vector[Event])


  sealed trait EventResponse

  case class EventCreated(event: Event) extends EventResponse

  case object EventExists extends EventResponse
}

class BoxOffice(implicit timeOut: Timeout) extends Actor {

  def createTicketSeller(name: String) = context.actorOf(TicketSeller.props(name), name)
  override def receive: Receive = {
    case CreateEvent(name, tickets) =>
      def create() = {
        val eventTickets = createTicketSeller(name)
        val newTickets = (1 to tickets).map { ticketId =>
          TicketSeller.Ticket(ticketId)
        }.toVector
        eventTickets ! TicketSeller.Add(newTickets)
        sender() ! EventCreated
      }
      context.child(name).fold(create())(_ => sender()! EventExists)
  }
}
