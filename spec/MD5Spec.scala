package org.producteev.misc

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class MD5Spec extends Spec with ShouldMatchers {
  describe("MD5") {
    it("should calc the md5 hash of a string") {
      MD5.sum("somestring") should equal ("1f129c42de5e4f043cbd88ff6360486f")
    }
  }
}
