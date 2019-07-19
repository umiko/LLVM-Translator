package llvm.test;

import llvm.utility.Types;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Types")
class TypesTest {

    @Test
    @DisplayName("Type Lookup")
    void lookup() {
        assertEquals("i32", Types.lookup("integer"), "Integer lookup failed");
        assertEquals("i1", Types.lookup("boolean"),"Boolean lookup failed");
        assertEquals("i8*", Types.lookup("string"),"String lookup failed");
        assertEquals("i8", Types.lookup("char"),"Char lookup failed");
        assertEquals("float", Types.lookup("real"),"Real lookup failed");
        assertEquals("void", Types.lookup("void"),"Void lookup failed");
    }

    @Test
    @DisplayName("Type existence check")
    void hasRawType() {
        assertTrue(Types.hasRawType("integer"));
        assertTrue(Types.hasRawType("string"));
        assertTrue(Types.hasRawType("char"));
        assertFalse(Types.hasRawType("fish"));
    }
}