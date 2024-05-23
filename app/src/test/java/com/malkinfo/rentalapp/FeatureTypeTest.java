package com.malkinfo.rentalapp;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FeatureTypeTest {
    @Test
    void test3(){
        assertEquals(1,1);
    }

@Test
void testAcFeatureTypeName() {
    FeatureType acFeature = new ac("AC");
    assertEquals("AC", acFeature.getTypeName());
}

    @Test
    void testNonAcFeatureTypeName() {
        FeatureType nonAcFeature = new nonac("Non AC");
        assertEquals("Non AC", nonAcFeature.getTypeName());
    }

    @Test
    void testSoundFeatureTypeName() {
        FeatureType soundFeature = new sound("Sound System");
        assertEquals("Sound System", soundFeature.getTypeName());
    }

//    @BeforeEach
//    void setUp() {
//        acFeature = new ac("AC");
//        nonAcFeature = new nonac("Non AC");
//        soundFeature = new sound("Sound System");
//    }

//    @Test
//    void testAcFeatureTypeName() {
//        assertEquals("AC", acFeature.getTypeName());
//        acFeature.setTypeName("Updated AC");
//        assertEquals("Updated AC", acFeature.getTypeName());
//    }

//    @Test
//    void testNonAcFeatureTypeName() {
//        assertEquals("Non AC", nonAcFeature.getTypeName());
//        nonAcFeature.setTypeName("Updated Non AC");
//        assertEquals("Updated Non AC", nonAcFeature.getTypeName());
//    }

//    @Test
//    void testSoundFeatureTypeName() {
//        assertEquals("Sound System", soundFeature.getTypeName());
//        soundFeature.setTypeName("Updated Sound System");
//        assertEquals("Updated Sound System", soundFeature.getTypeName());
//    }
}

