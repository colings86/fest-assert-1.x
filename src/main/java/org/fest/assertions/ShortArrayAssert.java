/*
 * Created on Feb 14, 2008
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

import static org.fest.assertions.ArrayInspection.copy;
import static org.fest.assertions.ErrorMessages.unexpectedEqual;
import static org.fest.assertions.ErrorMessages.unexpectedNotEqual;

import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * Assertions for arrays of {@code short}.
 * </p>
 *
 * <p>
 * To create a new instance of this class invoke {@link Assertions#assertThat(short[])}.
 * </p>
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ShortArrayAssert extends ArrayAssert<ShortArrayAssert, short[]> {
  /**
   * Creates a new {@link ShortArrayAssert}.
   * 
   * @param actual the target to verify.
   */
  protected ShortArrayAssert(@Nullable short... actual) {
    super(ShortArrayAssert.class, actual);
  }

  /**
   * Verifies that the actual {@code short} array contains the given values.
   * 
   * @param values the values to look for.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code short} array is {@code null}.
   * @throws NullPointerException if the given {@code short} array is {@code null}.
   * @throws AssertionError if the actual {@code short} array does not contain the given values.
   */
  public @Nonnull ShortArrayAssert contains(@Nonnull short... values) {
    assertContains(copy(values));
    return this;
  }

  /**
   * Verifies that the actual {@code short} array contains the given values <strong>only</strong>.
   * 
   * @param values the values to look for.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code short} array is {@code null}.
   * @throws NullPointerException if the given {@code short} array is {@code null}.
   * @throws AssertionError if the actual {@code short} array does not contain the given objects, or if the actual
   *           {@code short} array contains elements other than the ones specified.
   */
  public @Nonnull ShortArrayAssert containsOnly(@Nonnull short... values) {
    assertContainsOnly(copy(values));
    return this;
  }

  /**
   * Verifies that the actual {@code short} array does not contain the given values.
   * 
   * @param values the values the array should exclude.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code short} array is {@code null}.
   * @throws NullPointerException if the given {@code short} array is {@code null}.
   * @throws AssertionError if the actual {@code Object} array contains any of the given values.
   */
  public @Nonnull ShortArrayAssert excludes(short... values) {
    assertExcludes(copy(values));
    return this;
  }

  /**
   * Verifies that the actual {@code short} array is equal to the given array. Array equality is checked by
   * {@link Arrays#equals(short[], short[])}.
   * 
   * @param expected the given array to compare the actual array to.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code short} array is not equal to the given one.
   */
  @Override
  public @Nonnull ShortArrayAssert isEqualTo(@Nullable short[] expected) {
    if (Arrays.equals(actual, expected)) {
      return this;
    }
    failIfCustomMessageIsSet();
    throw failure(unexpectedNotEqual(actual, expected));
  }

  /**
   * Verifies that the actual {@code short} array is not equal to the given array. Array equality is checked by
   * {@link Arrays#equals(short[], short[])}.
   * 
   * @param array the given array to compare the actual array to.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code short} array is equal to the given one.
   */
  @Override
  public @Nonnull ShortArrayAssert isNotEqualTo(@Nullable short[] array) {
    if (!Arrays.equals(actual, array)) {
      return this;
    }
    failIfCustomMessageIsSet();
    throw failure(unexpectedEqual(actual, array));
  }
}
