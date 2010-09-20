/*
 *  Copyright 2010 Christopher Pheby
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.jadira.usertype.dateandtime.shared.spi;

import java.math.BigInteger;
import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.type.BigIntegerType;
import org.jadira.usertype.dateandtime.shared.reflectionutils.Hibernate36Helper;

public abstract class AbstractBigIntegerColumnMapper<T> extends AbstractColumnMapper<T, BigInteger> {

    private static final long serialVersionUID = 1702998875351962961L;

    public final int getSqlType() {
        return Types.BIGINT;
    }
    
    @SuppressWarnings("deprecation")
	public final BigIntegerType getHibernateType() {
    	if (Hibernate36Helper.USE_STANDARD_BASIC_TYPE_API) {
    		return (BigIntegerType) Hibernate36Helper.getHibernateType("BIG_INTEGER");
    	} else {
    		return (BigIntegerType) Hibernate.BIG_INTEGER;
    	}
    }
    
    public abstract T fromNonNullValue(BigInteger value);
    
    public abstract T fromNonNullString(String s);

    public abstract BigInteger toNonNullValue(T value);
    
    public abstract String toNonNullString(T value);
}