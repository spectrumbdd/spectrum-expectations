package org.spectrumbdd.expectations;

@FunctionalInterface
public interface Matcher<T> {

  class Result {

    public final boolean doesMatch;
    public final String message;

    public Result(boolean doesMatch, String message) {
      this.doesMatch = doesMatch;
      this.message = message;
    }
  }

  Result match(T actualValue);

}
