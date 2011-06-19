package org.producteev.model

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class LabelSpec extends Spec with ShouldMatchers {
  describe("Label") {
    val label = new Label(
      1,
      2,
      3,
      "title",
      "color",
      1,
      -1,
      -1,
      -1,
      "Wed, 11 May 2011 21:04:20 +0200",
      "Wed, 11 May 2011 21:04:21 +0200",
      "",
      0,
      -1
    )

    it("should return id_label") {
      label.id_label should equal(1)
    }

    it("should return id_creator") {
      label.id_creator should equal(2)
    }

    it("should return id_dashboard") {
      label.id_dashboard should equal(3)
    }

    it("should return title") {
      label.title should equal("title")
    }

    it("should return color") {
      label.color should equal("color")
    }

    it("should return type") {
      label.label_type should equal(1)
    }

    it("should return x") {
      label.x should equal(-1)
    }

    it("should return y") {
      label.y should equal(-1)
    }

    it("should return order") {
      label.order should equal(-1)
    }

    it("should return time_create") {
      label.time_create should equal("Wed, 11 May 2011 21:04:20 +0200")
    }

    it("should return time_lastchange") {
      label.time_lastchange should equal("Wed, 11 May 2011 21:04:21 +0200")
    }

    it("should return from") {
      label.from should equal("")
    }

    it("should return deleted") {
      label.deleted should equal(0)
    }

    it("should return order_position") {
      label.order_position should equal(-1)
    }
  }
}
