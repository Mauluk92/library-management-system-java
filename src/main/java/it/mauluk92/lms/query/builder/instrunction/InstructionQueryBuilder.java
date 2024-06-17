package it.mauluk92.lms.query.builder.instrunction;

import it.mauluk92.lms.query.builder.filter.OnGoingFilterQueryBuilder;

public interface InstructionQueryBuilder {

    OnGoingFilterQueryBuilder addFilter();
    String build();
}
