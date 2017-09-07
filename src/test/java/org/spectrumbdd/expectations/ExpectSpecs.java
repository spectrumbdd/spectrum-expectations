package org.spectrumbdd.expectations;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.spectrumbdd.expectations.Expect.expect;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;
import org.spectrumbdd.expectations.Matcher.Result;

@RunWith(Spectrum.class)
public class ExpectSpecs {

  {
    describe("The expect() function", () -> {

      describe("with a Block", () -> {

        it("throws AssertionError when matcher does not match", () -> {
          assertThatThrownBy(() -> {
            expect(() -> {
            }).to($ -> new Result(false, "boom"));

          })
              .isInstanceOf(AssertionError.class)
              .hasMessage("boom");
        });

        it("does not throw AssertionError when matcher passes", () -> {
          assertThatCode(() -> {
            expect(() -> {
            }).to($ -> new Result(true, ""));

          })
              .doesNotThrowAnyException();
        });

      });

    });
  }
}
