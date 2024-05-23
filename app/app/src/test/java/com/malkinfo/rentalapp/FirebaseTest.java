package com.malkinfo.rentalapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class FirebaseTest {

    @Before
    public void setUp() throws Exception {
        // Use reflection to reset the database instance to null before each test
        Field instanceField = Firebase.class.getDeclaredField("database");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
    }

    @Test
    public void testGetFirebase_ShouldReturnNonNullInstance() {
        FirebaseDatabase mockDatabase = Mockito.mock(FirebaseDatabase.class);
        // Use reflection to set the mock instance to the private static field
        setMockFirebaseDatabaseInstance(mockDatabase);
        FirebaseDatabase database = Firebase.getFirebase();
        assertNotNull("Firebase instance should not be null", database);
    }

    @Test
    public void testGetFirebase_ShouldReturnSameInstance() {
        FirebaseDatabase mockDatabase = Mockito.mock(FirebaseDatabase.class);
        // Use reflection to set the mock instance to the private static field
        setMockFirebaseDatabaseInstance(mockDatabase);
        FirebaseDatabase firstInstance = Firebase.getFirebase();
        FirebaseDatabase secondInstance = Firebase.getFirebase();
        assertSame("Firebase instances should be the same", firstInstance, secondInstance);
    }

    // Utility method to set the mock FirebaseDatabase instance
    private void setMockFirebaseDatabaseInstance(FirebaseDatabase mockDatabase) {
        try {
            Field instanceField = Firebase.class.getDeclaredField("database");
            instanceField.setAccessible(true);
            instanceField.set(null, mockDatabase);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set mock FirebaseDatabase instance", e);
        }
    }
}