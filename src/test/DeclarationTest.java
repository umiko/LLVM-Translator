package test;

import llvm.translators.Declaration;
import llvm.utility.Parameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Declarations")
class DeclarationTest {

    Parameter[] params = new Parameter[3];
    Parameter[] params2 = new Parameter[1];
    Parameter[] params3 = new Parameter[1];
    Parameter[] params4 = null;

    @BeforeEach
    void setUp() {
        params[0] = new Parameter("wellwell", "string");
        params[1] = new Parameter("whotsall", "char");
        params[2] = new Parameter("disden", "integer");
        params2[0] = new Parameter(null, "real");
        params3[0] = null;
    }

    @Test
    @DisplayName("Translate Function Declarations")
    void translateFunctionDeclaration() {
        assertEquals("declare i32 @fish (i8* %wellwell, i8 %whotsall, i32 %disden)", Declaration.translateFunctionDeclaration("integer", "fish", params));
        assertEquals("declare i8 @steak (float)", Declaration.translateFunctionDeclaration("char", "steak", params2));
        assertEquals("declare i8 @steak ()", Declaration.translateFunctionDeclaration("char", "steak", params3));
        assertEquals("declare i8 @steak ()", Declaration.translateFunctionDeclaration("char", "steak", params4));
    }

    @Test
    @DisplayName("writeln Declaration")
    void writeLnDeclaration() {
        assertEquals("declare i32 @puts (i8*)", Declaration.writeLnDeclaration());
    }

    @Test
    @DisplayName("Build Function Declaration")
    void buildFunctionDeclaration() {
        assertEquals("declare i32 @puts (i8* %wellwell, i8 %whotsall, i32 %disden)", Declaration.buildFunctionDeclaration("i32", "@puts", params));
        assertEquals("declare i32 @puts (float)", Declaration.buildFunctionDeclaration("i32", "@puts", params2));
        assertEquals("declare i32 @puts ()", Declaration.buildFunctionDeclaration("i32", "@puts", params3));
        assertEquals("declare i32 @puts ()", Declaration.buildFunctionDeclaration("i32", "@puts", params4));
    }

    @Test
    @DisplayName("Build Parameter List")
    void buildParameterList() {
        assertEquals("i8* %wellwell, i8 %whotsall, i32 %disden", Declaration.buildParameterList(params));
        assertEquals("float", Declaration.buildParameterList(params2));
        assertEquals("", Declaration.buildParameterList(params3));
        assertEquals("", Declaration.buildParameterList(params4));
    }

    @Test
    @DisplayName("Generic Build Function")
    void buildFunction() {
        assertEquals("fish steak potato", Declaration.buildFunction("%s %s %s", "fish", "steak", "potato"));
        assertEquals("fish steak", Declaration.buildFunction("%s %s", "fish", "steak", "potato"));
        assertEquals("fish steak", Declaration.buildFunction("%s %s", "fish", "steak", null));
        assertEquals("fish null", Declaration.buildFunction("%s %s", "fish", null, null));
    }

    @Test
    @DisplayName("Build Function Definition")
    void buildFunctionDefinition() {
        assertEquals("define i32 @puts (i8* %wellwell, i8 %whotsall, i32 %disden){", Declaration.buildFunctionDefinition("i32", "@puts", params));
        assertEquals("define i32 @puts (float){", Declaration.buildFunctionDefinition("i32", "@puts", params2));
        assertEquals("define i32 @puts (){", Declaration.buildFunctionDefinition("i32", "@puts", params3));
        assertEquals("define i32 @puts (){", Declaration.buildFunctionDefinition("i32", "@puts", params4));
    }

    @Test
    @DisplayName("Translate Funciton Definition")
    void translateFunctionDefinition() {
        assertEquals("define i32 @fish (i8* %wellwell, i8 %whotsall, i32 %disden){", Declaration.translateFunctionDefinition("integer", "fish", params));
        assertEquals("define i8 @steak (float){", Declaration.translateFunctionDefinition("char", "steak", params2));
        assertEquals("define i8 @steak (){", Declaration.translateFunctionDefinition("char", "steak", params3));
        assertEquals("define i8 @steak (){", Declaration.translateFunctionDefinition("char", "steak", params4));
    }
}