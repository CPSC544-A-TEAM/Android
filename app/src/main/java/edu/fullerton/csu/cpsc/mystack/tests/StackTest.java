package edu.fullerton.csu.cpsc.mystack.tests;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import edu.fullerton.csu.cpsc.mystack.MyStack;

/**
 * Created by wennbc on 9/5/15 for com.nbcuni.mps
 * http://mps.nbcuni.com
 */




public class StackTest extends TestCase {
    @Override
    protected void setUp () throws Exception {

        super.setUp();
    }
    @SmallTest
    public void testMyStack(){
        MyStack stack = new MyStack();
        assertNotNull(stack);
    }
    @SmallTest
    public void testMyStackPop(){
        MyStack stack = new MyStack();
        stack.push(3);
        Object element = stack.pop();
        assertEquals(3, element);
    }
    @SmallTest
    public void testMyStackEmpty(){
        MyStack stack = new MyStack();
        stack.push(3);
        Object element = stack.pop();
        assertEquals(3, element);
    }
}
