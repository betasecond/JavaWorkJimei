package edu.jimei.three;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest{
    private WildAnimal animal; // 将animal设为类的成员变量

    @BeforeEach
    public void setWildAnimal() {
        animal = new WildAnimal("Large");
    }

    @Test
    public void testWildAnimal() {
        System.out.println("Animal size: " + animal.getSize());
        System.out.println("Activity style: " + animal.getActivityStyle());
        System.out.println("Activity style (custom): " + animal.getActivityStyle("Running"));

        WildAnimal.getActivityArea("little rookie");
        System.out.println("Activity area: " + WildAnimal.getActivityArea());
        System.out.println("Activity area (custom): " + WildAnimal.getActivityArea("Jungle"));
    }
}
