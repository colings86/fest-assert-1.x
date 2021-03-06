/*
 * Created on May 26, 2010
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

import java.util.Collection;

/**
 * Tests for {@link ObjectArrayAssert#onProperty(String)}.
 * 
 * @author Joel Costigliola
 * @author Alex Ruiz
 */
public class ObjectArrayAssert_onProperty_Test extends ObjectGroupAssert_onProperty_Test<ObjectArrayAssert, Object[]> {
  @Override
  protected ObjectArrayAssert assertionsFor(Collection<?> data) {
    Object[] actual = data != null ? data.toArray() : null;
    return new ObjectArrayAssert(actual);
  }
}
