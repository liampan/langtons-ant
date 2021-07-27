package models

sealed trait Heading {
  def turnClockwise: Heading
  def turnCounterClockwise: Heading
}

object Heading {

  case object West extends Heading {
    override def turnClockwise: Heading = North

    override def turnCounterClockwise: Heading = South
  }

  case object East extends Heading {
    override def turnClockwise: Heading = South

    override def turnCounterClockwise: Heading = North
  }

  case object North extends Heading {
    override def turnClockwise: Heading = East

    override def turnCounterClockwise: Heading = West
  }

  case object South extends Heading {
    override def turnClockwise: Heading = West

    override def turnCounterClockwise: Heading = East
  }

}
