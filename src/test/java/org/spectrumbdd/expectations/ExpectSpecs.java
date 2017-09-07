package org.spectrumbdd.expectations;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static com.greghaskins.spectrum.dsl.specification.Specification.xdescribe;
import static org.spectrumbdd.expectations.Expect.expect;
import static org.spectrumbdd.expectations.Matchers.throwException;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

@RunWith(Spectrum.class)
public class ExpectSpecs {
  {
    xdescribe("The expect() function", () -> {

      describe("with a Block", () -> {

        it("throws AssertionError when matcher does not match", () -> {
          class FooException extends Throwable {}
          expect(() -> {}).to(throwException(FooException.class));
        });

      });

    });
  }
}
