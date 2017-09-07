package org.spectrumbdd.expectations;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.assertj.core.api.Assertions.assertThat;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;
import org.spectrumbdd.expectations.Matcher.Result;

@RunWith(Spectrum.class)
public class MatcherSpecs {

  {
    describe("raise[]", () -> {

      describe("when specifying a class", () -> {

        Matcher<Block> matcher = Matchers.raise(DummyException.class);

        it("fails when no exception is thrown", () -> {
          Result result = matcher.match(() -> {
          });
          assertThat(result.doesMatch).isFalse();
          assertThat(result.message).isEqualTo("block did not raise a throwable");
        });

        it("fails when another, unexpected type of exception is thrown", () -> {
          Result result = matcher.match(() -> {
            throw new RuntimeException();
          });
          assertThat(result.doesMatch).isFalse();
          assertThat(result.message)
              .contains("block raised a throwable of the wrong type")
              .contains("org.spectrumbdd.expectations.DummyException")
              .contains("java.lang.RuntimeException");
        });

        it("passes when the correct exception type is thrown", () -> {
          Result result = matcher.match(() -> {
            throw new DummyException();
          });
          assertThat(result.doesMatch).isTrue();
        });

        it("passes when a subclass of the correct exception type is thrown", () -> {
          class SubclassOfDummyException extends DummyException {
          }
          Result result = matcher.match(() -> {
            throw new SubclassOfDummyException();
          });
          assertThat(result.doesMatch).isTrue();
        });

      });

    });
  }
}
