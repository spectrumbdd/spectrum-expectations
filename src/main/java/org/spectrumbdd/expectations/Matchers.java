package org.spectrumbdd.expectations;

import org.spectrumbdd.expectations.matchers.throwable.ThrowExceptionMatcher;

public interface Matchers {

  static Matcher<Block> throwException(Class<? extends Throwable> expectedType) {
    return new ThrowExceptionMatcher(expectedType);
  }
}
