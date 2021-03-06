/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.hpl.jena.sparql.engine.iterator;

import java.util.NoSuchElementException ;

import org.apache.jena.atlas.io.IndentedWriter ;

import com.hp.hpl.jena.sparql.engine.ExecutionContext ;
import com.hp.hpl.jena.sparql.engine.QueryIterator ;
import com.hp.hpl.jena.sparql.engine.binding.Binding ;
import com.hp.hpl.jena.sparql.serializer.SerializationContext ;
import com.hp.hpl.jena.sparql.util.Utils ;

/** Closeable empty query iterator */

public class QueryIterNullIterator extends QueryIter
{
    public static QueryIterator create(ExecutionContext qCxt) { return new QueryIterNullIterator(qCxt) ; }
    
    // Or QueryIterYieldN with N = 0 ;
    // but sometimes it clearer just to w-r-i-t-e the code.
    
    public QueryIterNullIterator(ExecutionContext qCxt) { super(qCxt) ; }

    @Override
    protected boolean hasNextBinding()
    { return false ; }

    @Override
    protected Binding moveToNextBinding()
    { throw new NoSuchElementException(Utils.className(this)) ; }

    @Override
    protected void closeIterator() {}
    
    @Override
    protected void requestCancel() { }

    @Override
    public void output(IndentedWriter out, SerializationContext sCxt)
    { out.println(Utils.className(this)) ; }
}
