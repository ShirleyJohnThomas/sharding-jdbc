package com.alibaba.druid.sql.dialect.mysql.parser;

import com.alibaba.druid.sql.lexer.Token;
import com.alibaba.druid.sql.parser.AbstractUpdateParser;
import com.alibaba.druid.sql.parser.SQLExprParser;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;

import java.util.List;

/**
 * MySQL Update语句解析器.
 *
 * @author zhangliang
 */
public final class MySQLUpdateParser extends AbstractUpdateParser {
    
    public MySQLUpdateParser(final ShardingRule shardingRule, final List<Object> parameters, final SQLExprParser exprParser) {
        super(shardingRule, parameters, exprParser);
    }
    
    @Override
    protected void parseBetweenUpdateAndTable() {
        while (getLexer().equalToken(Token.LOW_PRIORITY) || getLexer().equalToken(Token.IGNORE)) {
            getLexer().nextToken();
        }
    }
}
