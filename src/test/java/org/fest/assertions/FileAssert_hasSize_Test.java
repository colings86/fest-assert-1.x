/*
 * Created on Dec 23, 2007
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

import static org.fest.assertions.FailureMessages.actualIsNull;
import static org.fest.assertions.FileStub.aFile;
import static org.fest.test.ExpectedException.none;

import org.fest.test.ExpectedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link FileAssert}.
 * 
 * @author David DIDIER
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FileAssert_hasSize_Test implements Assert_hasSize_TestCase {
  @Rule
  public ExpectedException thrown = none();

  private static FileStub file;

  @BeforeClass
  public static void setUpOnce() {
    file = aFile();
    file.length(8);
  }

  @Override
  @Test
  public void should_pass_if_actual_has_expected_size() {
    new FileAssert(file).hasSize(8);
  }

  @Override
  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    new FileAssert(null).hasSize(8);
  }

  @Override
  @Test
  public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull("A Test"));
    new FileAssert(null).as("A Test").hasSize(8);
  }

  @Override
  @Test
  public void should_fail_if_actual_does_not_have_expected_size() {
    thrown.expect(AssertionError.class, "size of file:<c:\\f.txt> expected:<6> but was:<8>");
    new FileAssert(file).hasSize(6);
  }

  @Override
  @Test
  public void should_fail_and_display_description_if_actual_does_not_have_expected_size() {
    thrown.expect(AssertionError.class, "[A Test] size of file:<c:\\f.txt> expected:<6> but was:<8>");
    new FileAssert(file).as("A Test").hasSize(6);
  }

  @Override
  @Test
  public void should_fail_with_custom_message_if_actual_does_not_have_expected_size() {
    thrown.expect(AssertionError.class, "My custom message");
    new FileAssert(file).overridingErrorMessage("My custom message").hasSize(6);
  }

  @Override
  @Test
  public void should_fail_with_custom_message_ignoring_description_if_actual_does_not_have_expected_size() {
    thrown.expect(AssertionError.class, "My custom message");
    new FileAssert(file).as("A Test").overridingErrorMessage("My custom message").hasSize(6);
  }
}