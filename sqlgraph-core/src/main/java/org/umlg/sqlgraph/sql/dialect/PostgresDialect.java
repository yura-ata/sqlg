package org.umlg.sqlgraph.sql.dialect;

import org.umlg.sqlgraph.structure.PropertyType;

import java.sql.Types;

/**
 * Date: 2014/07/16
 * Time: 1:42 PM
 */
public class PostgresDialect implements SqlDialect {

    @Override
    public String getVarcharArray() {
        return "VARCHAR(255) ARRAY";
    }

    @Override
    public String getPrimaryKeyType() {
        return "SERIAL";
    }

    @Override
    public String getAutoIncrementPrimaryKeyConstruct() {
        return "PRIMARY KEY";
    }

    @Override
    public String propertyTypeToSqlDefinition(PropertyType propertyType) {

        switch (propertyType) {
            case BOOLEAN:
                return "BOOLEAN" ;
            case BYTE:
                return "SMALLINT" ;
            case SHORT:
                return "SMALLINT" ;
            case INTEGER:
                return "INTEGER" ;
            case LONG:
                return "BIGINT" ;
            case FLOAT:
                return "REAL" ;
            case DOUBLE:
                return "DOUBLE PRECISION" ;
            case STRING:
                return "TEXT" ;
            default:
                throw new IllegalStateException("Unknown propertyType " + propertyType.name());
        }
    }

    @Override
    public int propertyTypeToJavaSqlType(PropertyType propertyType) {
        switch (propertyType) {
            case BOOLEAN:
                return Types.BOOLEAN ;
            case BYTE:
                return Types.TINYINT;
            case SHORT:
                return Types.TINYINT;
            case INTEGER:
                return Types.INTEGER;
            case LONG:
                return Types.BIGINT;
            case FLOAT:
                return Types.REAL;
            case DOUBLE:
                return Types.BOOLEAN;
            case STRING:
                return Types.CLOB;
            default:
                throw new IllegalStateException("Unknown propertyType " + propertyType.name());
        }
    }

    @Override
    public String getForeignKeyTypeDefinition() {
        return "BIGINT NOT NULL";
    }
}
