/*
 * Created on Jun 12, 2010
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
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.util.Strings.isNullOrEmpty;
import static org.fest.util.ToString.toStringOf;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.junit.ComparisonFailure;

/**
 * @author Alex Ruiz
 */
final class FailureMessages {
  static @Nonnull String actualIsNull() {
    return "expecting actual value not to be null";
  }

  static @Nonnull String actualIsNull(String description) {
    return String.format("[%s] expecting actual value not to be null", description);
  }

  static @Nonnull String notEqual(Object actual, Object expected) {
    return notEqual(null, actual, expected);
  }

  static @Nonnull String notEqual(String description, Object actual, Object expected) {
    String d = inBrackets(description);
    String a = toStringOf(actual);
    String e = toStringOf(expected);
    boolean isArray = isArray(actual) || isArray(expected);
    if (!isArray) {
      return new ComparisonFailure(d, e, a).getMessage();
    }
    d = addSpaceIfNotEmpty(d);
    return String.format("%sexpected:<%s> but was:<%s>", d, e, a);
  }

  static @Nonnull String equal(Object actual, Object other) {
    return equal(null, actual, other);
  }

  static @Nonnull String equal(String description, Object actual, Object other) {
    String d = addSpaceIfNotEmpty(inBrackets(description));
    return String.format("%sactual value:<%s> should not be equal to:<%s>", d, toStringOf(actual), toStringOf(other));
  }

  static @Nonnull String equalOrLess(Object actual, Object other) {
    return equalOrLess(null, actual, other);
  }

  static @Nonnull String equalOrLess(String description, Object actual, Object other) {
    String d = addSpaceIfNotEmpty(inBrackets(description));
    return String.format("%sactual value:<%s> should be greater than:<%s>", d, toStringOf(actual), toStringOf(other));
  }

  static @Nonnull String notIn(String description, Object actual, Object other) {
    String d = addSpaceIfNotEmpty(inBrackets(description));
    return String.format("%sactual value:<%s> should be in:<%s>", d, toStringOf(actual), toStringOf(other));
  }

  static @Nonnull String in(String description, Object actual, Object other) {
    String d = addSpaceIfNotEmpty(inBrackets(description));
    return String.format("%sactual value:<%s> should not be in:<%s>", d, toStringOf(actual), toStringOf(other));
  }

  private static @Nullable String inBrackets(@Nullable String s) {
    if (isNullOrEmpty(s)) {
      return "";
    }
    return String.format("[%s]", s);
  }

  private static @Nullable String addSpaceIfNotEmpty(@Nullable String s) {
    if (isNullOrEmpty(s)) {
      return s;
    }
    return s + " ";
  }

  private static boolean isArray(Object o) {
    return o != null && o.getClass().isArray();
  }
}
