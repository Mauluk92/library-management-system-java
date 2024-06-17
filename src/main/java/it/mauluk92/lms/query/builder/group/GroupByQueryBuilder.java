package it.mauluk92.lms.query.builder.group;

import it.mauluk92.lms.query.builder.order.OrderByQueryBuilder;

public interface GroupByQueryBuilder {

    OrderByQueryBuilder addOrderBy();
    GroupByQueryBuilder addGroupBy(String groupBy);
    String build();
}
