package models

import models.Heading._
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AntSpec extends AnyWordSpec with Matchers {

  "walk" must {
    "step forward" when {
      Seq(
        (West, (-1, 0)),
        (East, (1, 0)),
        (North, (0, 1)),
        (South, (0, -1)),
      ).foreach{case (heading, (x, y)) =>
        s"facing $heading" in {
          val ant = Ant(heading, 0, 0)
          ant.walk mustBe ant.copy(x = x, y = y)
        }
      }
    }
  }
  
  "turn" must {
    "turn clockwise 90 degrees" when {
      Seq(
        (West, North),
        (East, South),
        (North, East),
        (South, West)
      ).foreach{case (starting, finishing) =>
        s"ant starts facing $starting and is on a white square" in {
          Ant(starting, 0, 0).turn(onBlack = false).heading mustBe finishing
        }
      }
    }
    "turn counter clockwise 90 degrees" when {
      Seq(
        (West, South),
        (East, North),
        (North, West),
        (South, East)
      ).foreach{case (starting, finishing) =>
        s"ant starts facing $starting and is on a white square" in {
          Ant(starting, 0, 0).turn(onBlack = true).heading mustBe finishing
        }
      }
    } 
  }

}
