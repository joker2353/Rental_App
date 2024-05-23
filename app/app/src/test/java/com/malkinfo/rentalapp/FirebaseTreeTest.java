package com.malkinfo.rentalapp;

import static org.junit.Assert.assertNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FirebaseTreeTest {

    @Mock
    private FirebaseDatabase mockDatabase;

    @Mock
    private DatabaseReference mockReference;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testHomesTree() {
//        when(mockDatabase.getReference("homes")).thenReturn(mockReference);
//
//        HomesTree homesTree = new HomesTree() {
//            @Override
//            public FirebaseDatabase getFirebase() {
//                return mockDatabase;
//            }
//        };
//
//        DatabaseReference ref = homesTree.getFirebase();
//        assertNotNull(ref);
//        Mockito.verify(mockDatabase).getReference("homes");
//    }

//    @Test
//    public void testUsersTree() {
//        when(mockDatabase.getReference("users")).thenReturn(mockReference);
//
//        UsersTree usersTree = new UsersTree() {
//            @Override
//            public FirebaseDatabase getFirebase() {
//                return mockDatabase;
//            }
//        };
//
//        DatabaseReference ref = usersTree.getFirebase();
//        assertNotNull(ref);
//        Mockito.verify(mockDatabase).getReference("users");
//    }

//    @Test
//    public void testTreeFactoryForUsers() {
//        TreeFactory treeFactory = new TreeFactory() {
//            @Override
//            public DatabaseReference getFirebaseTree(String treeType) {
//                if (treeType.equalsIgnoreCase("users")) {
//                    return new UsersTree() {
//                        @Override
//                        public FirebaseDatabase getFirebase() {
//                            return mockDatabase;
//                        }
//                    }.getFirebase();
//                } else if (treeType.equalsIgnoreCase("homes")) {
//                    return new HomesTree() {
//                        @Override
//                        public FirebaseDatabase getFirebase() {
//                            return mockDatabase;
//                        }
//                    }.getFirebase();
//                } else {
//                    return null;
//                }
//            }
//        };
//
//        when(mockDatabase.getReference("users")).thenReturn(mockReference);
//        DatabaseReference ref = treeFactory.getFirebaseTree("users");
//        assertNotNull(ref);
//        Mockito.verify(mockDatabase).getReference("users");
//    }

//    @Test
//    public void testTreeFactoryForHomes() {
//        TreeFactory treeFactory = new TreeFactory() {
//            @Override
//            public DatabaseReference getFirebaseTree(String treeType) {
//                if (treeType.equalsIgnoreCase("users")) {
//                    return new UsersTree() {
//                        @Override
//                        public FirebaseDatabase getFirebase() {
//                            return mockDatabase;
//                        }
//                    }.getFirebase();
//                } else if (treeType.equalsIgnoreCase("homes")) {
//                    return new HomesTree() {
//                        @Override
//                        public FirebaseDatabase getFirebase() {
//                            return mockDatabase;
//                        }
//                    }.getFirebase();
//                } else {
//                    return null;
//                }
//            }
//        };
//
//        when(mockDatabase.getReference("homes")).thenReturn(mockReference);
//        DatabaseReference ref = treeFactory.getFirebaseTree("homes");
//        assertNotNull(ref);
//        Mockito.verify(mockDatabase).getReference("homes");
//    }

    @Test
    public void testTreeFactoryInvalidType() {
        TreeFactory treeFactory = new TreeFactory();
        DatabaseReference ref = treeFactory.getFirebaseTree("invalid");
        assertNull(ref);

    }
}