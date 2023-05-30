import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
        //Test case 1
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(null, Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Test case 2
        assertFalse(SILab2.function(new User(null, "test test", "ms@test.com"),
                List.of(new User("ms@test.com", "test test", "ms@test.com"),
                        new User("Mila", "p@ssword", "mm@tt.com"))));

        //Test case 3
        assertFalse(SILab2.function(new User("Mila", "abcd12345", "mm"), Collections.emptyList()));

        //Test case 4
        assertFalse(SILab2.function(new User("Mila", "t!a#a1234", "tt"), Collections.emptyList()));

        //Test case 5
        assertFalse(SILab2.function(new User("Mila", "t", "tt"), Collections.emptyList()));

    }

    @Test
    void multipleConditionTest(){
        RuntimeException ex;

        //T || X || X 	user=null, user.getPassword()=anything, user.getEmail()=anything
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(null, Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F || T || X 	user!=null, user.getPassword()=null, user.getEmail()=anything
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(new User("user1", null, "mail"), Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F || F || T 	user!=null, user.getPassword()!=null, user.getEmail()=null
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(new User("user2", "n0tNu11", null), Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F || F || F 	user!=null, user.getPassword()!=null, user.getEmail()!=null
        assertFalse(SILab2.function(new User("user3", "pass", "someEmail"), Collections.emptyList()));

    }
}