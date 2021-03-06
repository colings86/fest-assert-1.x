/*
 * Created on Sep 16, 2007
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
 * Copyright @2007-2013 the original author or authors.
 */
package org.fest.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for {@link Formatting#format(String)}.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class Formatting_format_Test {
  @Test
  public void should_return_empty_String_if_message_is_null() {
    assertEquals("", Formatting.format(null));
  }

  @Test
  public void should_return_empty_String_if_message_is_empty() {
    assertEquals("", Formatting.format(""));
  }

  @Test
  public void should_format_non_empty_message() {
    assertEquals("[some message] ", Formatting.format("some message"));
  }
}
