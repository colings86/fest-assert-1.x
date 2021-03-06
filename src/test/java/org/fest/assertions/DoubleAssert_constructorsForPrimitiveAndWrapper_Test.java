/*
 * Created on Apr 15, 2010
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

/**
 * Tests for {@link DoubleAssert#DoubleAssert(double)} and
 * {@link DoubleAssert#DoubleAssert(Double)}.
 * 
 * @author Ansgar Konermann
 * @author Alex Ruiz
 */
public class DoubleAssert_constructorsForPrimitiveAndWrapper_Test extends
GenericAssert_constructorsForPrimitiveAndWrapper_TestCase<DoubleAssert, Double> {
  @Override
  protected Class<DoubleAssert> assertionType() {
    return DoubleAssert.class;
  }

  @Override
  protected Class<?> primitiveType() {
    return double.class;
  }

  @Override
  protected Class<Double> primitiveWrapperType() {
    return Double.class;
  }
}
