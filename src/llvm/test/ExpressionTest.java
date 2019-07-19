package llvm.test;

import llvm.Expression;
import llvm.Value;
import llvm.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Expression Test")
class ExpressionTest {

    Expression e1;
    Expression e2;
    Expression e3;
    Expression e4;

    @BeforeEach
    void setUp() {
        e1 = new Expression("+", new Variable("jeff", "integer", false), new Value("integer", "69"));
        e2 = new Expression("-", e1, new Value("integer", "42"));
        e3 = new Expression("*", new Variable("ayy", "integer", false), e2);
        e4 = new Expression("*", new Variable("ayy", "real", false), new Value("real", "123.45"));
    }

    @Test
    void getRawType() {
        assertEquals("integer", e1.getRawType());
        assertEquals("integer", e2.getRawType());
        assertEquals("integer", e3.getRawType());
        assertEquals("real", e4.getRawType());
    }

    @Test
    void setRawType() {
    }

    @Test
    void getLLVMType() {
    }

    @Test
    void getLLVMString() {
        assertEquals("add i32 %jeff, 69", e1.getLLVMString());
        assertEquals("sub i32 %0, 42", e2.getLLVMString());
        assertEquals("mul i32 %ayy, %1", e3.getLLVMString());
        assertEquals("", e4.getLLVMString());
    }
}