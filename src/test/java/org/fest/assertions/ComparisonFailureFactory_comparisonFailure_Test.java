/*
 * Created on Feb 15, 2008
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2008-2013 the original author or authors.
 */
package org.fest.assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.ComparisonFailure;
import org.junit.Test;

/**
 * Tests for {@link ComparisonFailureFactory#comparisonFailure(String, Object, Object)}.
 * 
 * @author Alex Ruiz
 */
public class ComparisonFailureFactory_comparisonFailure_Test {
  @Test
  public void should_create_exception_if_actual_or_expected_are_not_String() {
    AssertionError failure = ComparisonFailureFactory.comparisonFailure("message", new Jedi("Luke"), new Jedi("Ben"));
    assertThatIsComparisonFailure(failure);
    assertEquals("[message] expected:<Jedi [name=[Luke]]> but was:<Jedi [name=[Ben]]>", failure.getMessage());
  }

  @Test
  public void should_create_exception_if_actual_and_expected_are_String() {
    AssertionError failure = ComparisonFailureFactory.comparisonFailure("message", "expected", "actual");
    assertThatIsComparisonFailure(failure);
    assertEquals("[message] expected:<'[expected]'> but was:<'[actual]'>", failure.getMessage());
  }

  @Test
  public void should_create_exception_if_actual_or_expected_are_equal_to_null() {
    AssertionError failure = ComparisonFailureFactory.comparisonFailure("message", null, "actual");
    assertThatIsComparisonFailure(failure);
    assertEquals("[message] expected:<null> but was:<'actual'>", failure.getMessage());
  }

  private static void assertThatIsComparisonFailure(AssertionError failure) {
    assertTrue(failure instanceof ComparisonFailure);
  }

  private static class Jedi {
    final String name;

    Jedi(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return String.format("Jedi [name=%s]", name);
    }
  }
}
