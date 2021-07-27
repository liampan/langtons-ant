package models

import models.Heading.{East, North, West}
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StateSpec extends AnyWordSpec with Matchers {

  "nextState" must {
    "move the board through one cycle with ant on white square" in {
      val startingState = State(Ant(North, 0, 0), Set.empty)
      val nextState = startingState.nextState

      withClue("ant should have turned clockwise and walked 1 square") {
        nextState.ant mustBe startingState.ant.move(false)
      }
      withClue("origin square ant was on should now be considered black"){
        nextState.blackSquares mustBe Set(startingState.ant.position)
      }
    }

    "move the board through one cycle with ant on black square" in {
      val startingState = State(Ant(North, 0, 0), Set((0, 0)))
      val nextState = startingState.nextState

      withClue("ant should have turned counter clockwise and walked 1 square") {
        nextState.ant mustBe startingState.ant.move(true)
      }
      withClue("origin square ant was on should now be considered white"){
        nextState.blackSquares mustBe Set.empty
      }
    }
  }

}
