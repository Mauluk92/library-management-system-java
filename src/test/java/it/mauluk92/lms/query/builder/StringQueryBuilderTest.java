package it.mauluk92.lms.query.builder;

import it.mauluk92.lms.query.builder.impl.StringQueryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig
public class StringQueryBuilderTest {

    private final static String COMPLETE_QUERY = "SELECT * FROM DUAL WHERE FIELD = :FIELD AND SECOND_FIELD = :SECOND_FIELD GROUP BY FIELD ORDER BY FIELD";
    private final static String INSTRUCTION = "SELECT * FROM DUAL";
    private final static String WHERE_CONDITION_FIRST = "FIELD = :FIELD";
    private final static String WHERE_CONDITION_SECOND = "SECOND_FIELD = :SECOND_FIELD";
    private final static String GROUP_BY_CONDITION = "FIELD";
    private final static String ORDER_BY_CONDITION = "FIELD";

    @Test
    public void whenBuiltCorrectQueryInOutput(){
        QueryBuilder queryBuilder = new StringQueryBuilder();
        String sql = queryBuilder.insertInstruction(INSTRUCTION)
                .addFilter()
                .addFilter(WHERE_CONDITION_FIRST)
                .addAndCondition()
                .addFilter(WHERE_CONDITION_SECOND)
                .addGroupBy()
                .addGroupBy(GROUP_BY_CONDITION)
                .addOrderBy()
                .addOrderCondition(ORDER_BY_CONDITION)
                .build();
        Assertions.assertEquals(COMPLETE_QUERY, sql);
    }
}
