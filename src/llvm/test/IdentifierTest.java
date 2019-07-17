package llvm.test;

import llvm.IIdentifiable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Identifier Translation")
class IdentifierTest {

    @Test
    @DisplayName("Parameter Validity")
    void translateIdentifierParameterValidity(){
        assertNull(IIdentifiable.translateIdentifier("", true), "Empty Identifier does not return Null");
        assertNull(IIdentifiable.translateIdentifier("", false), "Empty Identifier does not return Null");
        assertNull(IIdentifiable.translateIdentifier(null, false), "Null Identifier does not return Null");
        assertNotNull(IIdentifiable.translateIdentifier("fish", false), "Valid Identifier does return Null");
    }

    @Test
    @DisplayName("Global Translation")
    void translateGlobalIdentifier() {
        assertEquals("@SomeIdent", IIdentifiable.translateIdentifier("SomeIdent", true));
        assertNotEquals("%SomeIdent", IIdentifiable.translateIdentifier("SomeIdent", true));
    }

    @Test
    @DisplayName("Local Translation")
    void translateLocalIdentifier(){
        assertEquals("%SomeIdent", IIdentifiable.translateIdentifier("SomeIdent", false));
        assertNotEquals("@SomeIdent", IIdentifiable.translateIdentifier("SomeIdent", false));
    }

    @Test
    @DisplayName("Validate Identifier")
    void validateIdentifier(){
        assertTrue(IIdentifiable.validateIdentifier("fish"));
        assertFalse(IIdentifiable.validateIdentifier(null));
        assertFalse(IIdentifiable.validateIdentifier(""));
    }
}