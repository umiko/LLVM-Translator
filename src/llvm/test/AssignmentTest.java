package llvm.test;

import llvm.Assignment;
import llvm.Expression;
import llvm.Value;
import llvm.Variable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Assignment")
class AssignmentTest {

    Assignment a1;
    Assignment a2;
    Assignment a3;

    @BeforeEach
    void setUp() {
        Variable v1 = new Variable("ayy", "integer", true);
        Variable v2 = new Variable("lmao", "integer", false);
        a1 = new Assignment(v1, new Value("integer", "27"));
        a2 = new Assignment(v1, v2);
        a3 = new Assignment(v2, new Expression("/", v1, new Value("integer", "42")));

    }

    @Test
    void buildAssignment() {
        assertEquals("@ayy = add i32 27, 0", a1.buildAssignment());
        assertEquals("@ayy = add i32 %lmao, 0", a2.buildAssignment());
        assertEquals("%lmao = sdiv i32 @ayy, 42", a3.buildAssignment());
    }
}