package it.mauluk92.lms.query.builder;

import it.mauluk92.lms.query.builder.instrunction.InstructionQueryBuilder;

public interface QueryBuilder {

    InstructionQueryBuilder insertInstruction(String instruction);
}
