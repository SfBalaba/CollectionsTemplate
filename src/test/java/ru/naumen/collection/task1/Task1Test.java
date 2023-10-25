package ru.naumen.collection.task1;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static ru.naumen.collection.task1.Task1.findDuplicates;

public class Task1Test {
    @Test
    public void testIfPassordNotEquals(){
        ArrayList<User> collA = new ArrayList<User>();
        ArrayList<User> collB = new ArrayList<User>();
        collB.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 1, 5}));
        collA.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 45, 5}));

        List<User> out = findDuplicates(collA, collB);
        Assert.assertEquals(0, out.size());
    }
    @Test
    public void testIfAllFieldsEquals(){
        ArrayList<User> collA = new ArrayList<User>();
        ArrayList<User> collB = new ArrayList<User>();
        collB.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 1, 5}));
        collA.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 1, 5}));

        List<User> out = findDuplicates(collA, collB);
        Assert.assertEquals(1, out.size());
    }

    @Test
    public void test(){
        ArrayList<User> collA = new ArrayList<User>();
        ArrayList<User> collB = new ArrayList<User>();
        collB.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 1, 5}));
        collB.add(new User("Masha", "milasha4@gmail.com", new byte[]{12, 24, 45, 5}));
        collB.add(new User("Anna12", "ann@gmail.com", new byte[]{12, 24, 5}));
        collA.add(new User("Dasha12", "dashulya@gmail.com", new byte[]{12, 24, 0, 5}));

        collA.add(collB.get(0));

        List<User> out = findDuplicates(collA, collB);
        Assert.assertEquals(1, out.size());
    }

    @Test
    public void testEmptyCollection(){
        ArrayList<User> collA = new ArrayList<User>();
        ArrayList<User> collB = new ArrayList<User>();
        collB.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 1, 5}));
        collB.add(new User("Masha", "milasha4@gmail.com", new byte[]{12, 24, 45, 5}));
        collB.add(new User("Anna12", "ann@gmail.com", new byte[]{12, 24, 5}));

        List<User> out = findDuplicates(collA, collB);
        Assert.assertEquals(0, out.size());
    }

    @Test
    public void testDuplicatrsInsideCollection(){
        ArrayList<User> collA = new ArrayList<User>();
        ArrayList<User> collB = new ArrayList<User>();
        collB.add(new User("Sasha", "sanya@gmail.com", new byte[]{12, 24, 1, 5}));
        collB.add(new User("Masha", "milasha4@gmail.com", new byte[]{12, 24, 45, 5}));
        collB.add(new User("Anna12", "ann@gmail.com", new byte[]{12, 24, 5}));
        collA.addAll(collB);
        collA.addAll(collB);

        List<User> out = findDuplicates(collA, collB);
        Assert.assertEquals(3, out.size());
    }

}