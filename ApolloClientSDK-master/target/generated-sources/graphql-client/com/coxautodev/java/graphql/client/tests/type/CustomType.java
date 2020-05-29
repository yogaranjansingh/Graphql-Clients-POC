package com.coxautodev.java.graphql.client.tests.type;

import com.apollographql.apollo.api.ScalarType;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;

@Generated("Apollo GraphQL")
public enum CustomType implements ScalarType {
  DATE {
    @Override
    public String typeName() {
      return "Date";
    }

    @Override
    public Class javaType() {
      return Object.class;
    }
  }
}
