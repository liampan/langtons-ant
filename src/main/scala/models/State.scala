package models

final case class State(ant: Ant, blackSquares: Set[(Int, Int)]) {

  def nextState : State = {
    val antOnBlack = blackSquares.contains(ant.position)
    State(
      ant = ant.move(antOnBlack),
      blackSquares = if (antOnBlack) blackSquares - ant.position else blackSquares + ant.position
    )
  }

}
