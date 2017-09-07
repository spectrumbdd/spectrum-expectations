package org.spectrumbdd.expectations;

import org.spectrumbdd.expectations.Matcher.Result;

public class BlockExpectation {

  private final Block block;

  BlockExpectation(Block block) {
    this.block = block;
  }

  public void to(Matcher<Block> matcher) {
    Result result = matcher.match(this.block);
    if (!result.doesMatch) {
      throw new AssertionError(result.message);
    }

  }

}
