package com.it.learn.to8.interface1;

import com.test.lambda.impl4inteface.ChildImpl;
import com.test.lambda.impl4inteface.OverridingParent;
import com.test.lambda.impl4inteface.ParentImpl;
import com.test.lambda.interface1.Child;
import com.test.lambda.interface1.Parent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author huangchangling on 2017/7/13 0013
 */
public class DefaultTest {

    @Test
    public void parentDefaultUsed(){
        Parent parent = new ParentImpl();

        parent.welcome();

        assertEquals("Parent:Hi!",parent.getLastMessage());
    }
    @Test
    public void childOverrideDefault(){
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child:Hi!",child.getLastMessage());
    }

    @Test
    public void concreteBeatsDefault(){
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent:Hi!",parent.getLastMessage());
            }


}
