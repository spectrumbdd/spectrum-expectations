package org.spectrumbdd.expectations.matchers.throwable;

import org.spectrumbdd.expectations.Matcher;
import org.spectrumbdd.expectations.Block;

public class ThrowExceptionMatcher implements Matcher<Block> {

  private final Class<? extends Throwable> expectedType;

  public ThrowExceptionMatcher(Class<? extends Throwable> expectedType) {
    this.expectedType = expectedType;
  }

  @Override
  public Result match(Block block) {
    try {
      block.run();
      return new Result(false, "block did not raise a throwable");
    } catch (Throwable exception) {
      boolean doesMatch = this.expectedType.isInstance(exception);
      if (!doesMatch) {
        return new Result(false, "block raised a throwable of the wrong type\n\n"
            + "Expecting: " + this.expectedType.getCanonicalName() + "\n"
            + "but it threw a: " + exception.getClass().getCanonicalName());
      }
    }
    return new Result(true, null);

  }
}
