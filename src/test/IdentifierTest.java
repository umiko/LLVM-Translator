package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import llvm.translators.Identifier;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Identifier Translation")
class IdentifierTest {

    @Test
    @DisplayName("Parameter Validity")
    void translateIdentifierParameterValidity(){
        assertNull(Identifier.translateIdentifier("", true), "Empty Identifier does not return Null");
        assertNull(Identifier.translateIdentifier("", false), "Empty Identifier does not return Null");
        assertNull(Identifier.translateIdentifier(null, false), "Null Identifier does not return Null");
        assertNotNull(Identifier.translateIdentifier("fish", false), "Valid Identifier does return Null");
    }

    @Test
    @DisplayName("Global Translation")
    void translateGlobalIdentifier() {
        assertEquals("@SomeIdent", Identifier.translateIdentifier("SomeIdent", true));
        assertNotEquals("%SomeIdent", Identifier.translateIdentifier("SomeIdent", true));
    }

    @Test
    @DisplayName("Local Translation")
    void translateLocalIdentifier(){
        assertEquals("%SomeIdent", Identifier.translateIdentifier("SomeIdent", false));
        assertNotEquals("@SomeIdent", Identifier.translateIdentifier("SomeIdent", false));
    }
}