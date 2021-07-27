package models

final case class Ant(heading: Heading, private val x: Int, private val y: Int) {
  def walk: Ant = heading match {
      case Heading.West => copy(x = x - 1)
      case Heading.East => copy(x = x + 1)
      case Heading.North => copy(y = y + 1)
      case Heading.South => copy(y = y -1)
    }

  def turn(onBlack: Boolean): Ant = copy(heading = if (onBlack) heading.turnCounterClockwise else heading.turnClockwise)

  def move(onBlack: Boolean): Ant = turn(onBlack).walk

  def position: (Int, Int) = (x, y)

}
