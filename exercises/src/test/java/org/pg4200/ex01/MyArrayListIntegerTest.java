package org.pg4200.ex01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {
        private MyArrayListInteger data = new MyArrayListInteger(10);

        @Test
        public void testEmpty(){

            //a newly created container should be empty
            assertEquals(0, data.size());
        }


        @Test
        public void testAddOneElement(){

            int n = data.size();

            data.add(69);

            assertEquals(n + 1, data.size());

        /*
            An option here would have to be to test if size is just 1, as
            the container (should) starts empty, instead of n+1.
            However, we would conflate the testing of two different features
            in the same test.
            Here, I am testing that adding an element increases the size by 1,
            regardless of its original size (even though I do actually test it
            with just 0 as starting size, although I could add more tests to handle
            further different cases)
         */
        }

        @Test
        public void testAddAndRetrieveElement() {

            int value = 42;

            data.add(value);

        /*
            As the container is empty, I m expecting to have it in position 0
         */
            int res = data.get(0);

            assertEquals(value, res);
        }

        @Test
        public void testAdd5Elements(){

            assertEquals(0, data.size());
            int first = 1;
            int second = 2;
            int third = 3;

            data.add(first);
            data.add(second);
            data.add(third);
            data.add(first);
            data.add(first);

            assertEquals(first, data.get(0));
            assertEquals(second, data.get(1));
            assertEquals(third, data.get(2));
            assertEquals(first, data.get(3));
            assertEquals(first, data.get(4));
        }

        @Test
        public void testOutOfIndex(){

            assertNull(data.get(-5));
            assertNull(data.get(42));
        }
}

