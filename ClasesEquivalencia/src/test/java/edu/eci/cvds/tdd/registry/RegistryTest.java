package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {
        Person person = new Person("Maria", 92382273, 31, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void testUnderage() {
        Person juan = new Person("Juan", 2346547, 15, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(juan);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void testDead() {
        Person muerto = new Person("JuanPablo", 98567829, 33, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(muerto);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void testDuplicate() {
        Person duplicate = new Person("Juan2", 92382273, 19, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(duplicate);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void testInvalidAge() {
        Person invalid = new Person("Gonzalo", 57623847, 23, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(invalid);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
}