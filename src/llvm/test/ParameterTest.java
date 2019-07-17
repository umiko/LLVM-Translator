package llvm.test;

import llvm.Parameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Parameter")
class ParameterTest {

    private Parameter p;

    @BeforeEach
    void setUp() {
        p = new Parameter("SomeIdent", "integer");
    }

    @Test
    @DisplayName("Constructor Testing")
    void constructor(){
        assertThrows(IllegalArgumentException.class, ()-> new Parameter(null, null));
        assertThrows(IllegalArgumentException.class, ()-> new Parameter(null, ""));
        assertDoesNotThrow(()->{new Parameter(null, "integer");});
    }

    @Test
    @DisplayName("Raw Name Getter")
    void getRawName() {
        assertEquals("SomeIdent", p.getRawName());
    }

    @Test
    @DisplayName("Raw Name Setter")
    void setRawName() {
        assertEquals("SomeIdent", p.getRawName());
        p.setRawName("SomeOtherIdent");
        assertEquals("SomeOtherIdent", p.getRawName());
    }

    @Test
    @DisplayName("Raw Type Getter")
    void getRawType() {
        assertEquals("integer", p.getRawType());
    }

    @Test
    @DisplayName("Raw Type Setter")
    void setRawType() {
        assertDoesNotThrow(()-> p.setRawType("string"));
        assertEquals("string", p.getRawType());
        assertThrows(IllegalArgumentException.class, ()-> p.setRawType("fish"));
    }

    @Test
    @DisplayName("LLVM Name Getter")
    void getLLVMName() {
        assertEquals("%SomeIdent", p.getLLVMName());
    }

    @Test
    @DisplayName("LLVM Type Getter")
    void getLLVMType() {
        assertEquals("i32", p.getLLVMType());
    }

    @Test
    @DisplayName("LLVM String")
    void toLLVMString() {
        assertEquals("i32 %SomeIdent", p.toLLVMString());
        p.setRawName("");
        assertEquals("i32", p.toLLVMString());

    }
}