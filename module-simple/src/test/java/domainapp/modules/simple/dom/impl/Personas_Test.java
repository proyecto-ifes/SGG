/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package domainapp.modules.simple.dom.impl;

public class Personas_Test {

    /*@Rule
    public JUnitRuleMockery2 context = JUnitRuleMockery2.createFor(Mode.INTERFACES_AND_CLASSES);

    @Mock
    RepositoryService mockRepositoryService;

    SimpleObjects simpleObjects;

    @Before
    public void setUp() {
        simpleObjects = new SimpleObjects();
        simpleObjects.repositoryService = mockRepositoryService;
    }

    public static class Create extends Personas_Test {

        @Test
        public void happyCase() {

            final String someName = "Foobar";

            // given
            context.checking(new Expectations() {
                {
                    oneOf(mockRepositoryService).persist(with(nameOf(someName)));
                    will(JMockActions.returnArgument(0));
                }

            });

            // when
            final SimpleObject obj = simpleObjects.create(someName);

            // then
            assertThat(obj).isNotNull();
            assertThat(obj.getName()).isEqualTo(someName);
        }

        private static Matcher<SimpleObject> nameOf(final String name) {
            return new TypeSafeMatcher<SimpleObject>() {
                @Override
                protected boolean matchesSafely(final SimpleObject item) {
                    return name.equals(item.getName());
                }

                public void describeTo(final Description description) {
                    description.appendText("has name of '" + name + "'");
                }
            };
        }
    }

    public static class ListAll extends Personas_Test {

        @Test
        public void happyCase() {

            // given
            final List<SimpleObject> all = Lists.newArrayList();

            context.checking(new Expectations() {
                {
                    oneOf(mockRepositoryService).allInstances(SimpleObject.class);
                    will(returnValue(all));
                }
            });

            // when
            final List<SimpleObject> list = simpleObjects.listAll();

            // then
            assertThat(list).isEqualTo(all);
        }
    }*/
}
