package it.mauluk92.lms.query.builder.filter;

import it.mauluk92.lms.query.builder.group.GroupByQueryBuilder;
import it.mauluk92.lms.query.builder.order.OrderByQueryBuilder;

public interface FilterQueryBuilder {

    OnGoingFilterQueryBuilder addAndCondition();
    OnGoingFilterQueryBuilder addOrCondition();
    OrderByQueryBuilder addOrderBy();
    GroupByQueryBuilder addGroupBy();
    String build();
}
