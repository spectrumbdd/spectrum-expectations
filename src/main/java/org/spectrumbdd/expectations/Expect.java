package org.spectrumbdd.expectations;

public interface Expect {

  static BlockExpectation expect(Block block) {
    return new BlockExpectation(block);
  }

}
