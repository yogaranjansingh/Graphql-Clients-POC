package com.coxautodev.java.graphql.client.tests.queries;

import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.coxautodev.java.graphql.client.tests.type.CustomType;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetActionsQuery implements Query<GetActionsQuery.Data, Optional<GetActionsQuery.Data>, Operation.Variables> {
  public static final String OPERATION_DEFINITION = "query getActions {\n"
      + "  actions(filterBy: {}) {\n"
      + "    id\n"
      + "    name\n"
      + "    canonicalName\n"
      + "    createdAt\n"
      + "    updatedAt\n"
      + "    createdBy\n"
      + "    updatedBy\n"
      + "    description\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "getActions";
    }
  };

  private final Operation.Variables variables;

  public GetActionsQuery() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return "1706446786608139ac2415e710c411041f010bc210dff02dee11616bf828514e";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public Optional<GetActionsQuery.Data> wrapData(GetActionsQuery.Data data) {
    return Optional.ofNullable(data);
  }

  @Override
  public Operation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetActionsQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    Builder() {
    }

    public GetActionsQuery build() {
      return new GetActionsQuery();
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObjectList("actions", "actions", new UnmodifiableMapBuilder<String, Object>(1)
        .put("filterBy", new UnmodifiableMapBuilder<String, Object>(0)
        .build())
      .build(), true)
    };

    final Optional<List<Action>> actions;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable List<Action> actions) {
      this.actions = Optional.ofNullable(actions);
    }

    /**
     * Query Actions by applying one or more Filter
     */
    public Optional<List<Action>> actions() {
      return this.actions;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], actions.isPresent() ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (Action $item : actions.get()) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "actions=" + actions
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return this.actions.equals(that.actions);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= actions.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Action.Mapper actionFieldMapper = new Action.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<Action> actions = reader.readList($responseFields[0], new ResponseReader.ListReader<Action>() {
          @Override
          public Action read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<Action>() {
              @Override
              public Action read(ResponseReader reader) {
                return actionFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(actions);
      }
    }
  }

  public static class Action {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("id", "id", null, false),
      ResponseField.forString("name", "name", null, true),
      ResponseField.forString("canonicalName", "canonicalName", null, false),
      ResponseField.forCustomType("createdAt", "createdAt", null, true, CustomType.DATE),
      ResponseField.forCustomType("updatedAt", "updatedAt", null, true, CustomType.DATE),
      ResponseField.forString("createdBy", "createdBy", null, true),
      ResponseField.forString("updatedBy", "updatedBy", null, true),
      ResponseField.forString("description", "description", null, true)
    };

    final @Nonnull String id;

    final Optional<String> name;

    final @Nonnull String canonicalName;

    final Optional<Object> createdAt;

    final Optional<Object> updatedAt;

    final Optional<String> createdBy;

    final Optional<String> updatedBy;

    final Optional<String> description;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Action(@Nonnull String id, @Nullable String name, @Nonnull String canonicalName,
        @Nullable Object createdAt, @Nullable Object updatedAt, @Nullable String createdBy,
        @Nullable String updatedBy, @Nullable String description) {
      if (id == null) {
        throw new NullPointerException("id can't be null");
      }
      this.id = id;
      this.name = Optional.ofNullable(name);
      if (canonicalName == null) {
        throw new NullPointerException("canonicalName can't be null");
      }
      this.canonicalName = canonicalName;
      this.createdAt = Optional.ofNullable(createdAt);
      this.updatedAt = Optional.ofNullable(updatedAt);
      this.createdBy = Optional.ofNullable(createdBy);
      this.updatedBy = Optional.ofNullable(updatedBy);
      this.description = Optional.ofNullable(description);
    }

    public @Nonnull String id() {
      return this.id;
    }

    public Optional<String> name() {
      return this.name;
    }

    public @Nonnull String canonicalName() {
      return this.canonicalName;
    }

    public Optional<Object> createdAt() {
      return this.createdAt;
    }

    public Optional<Object> updatedAt() {
      return this.updatedAt;
    }

    public Optional<String> createdBy() {
      return this.createdBy;
    }

    public Optional<String> updatedBy() {
      return this.updatedBy;
    }

    public Optional<String> description() {
      return this.description;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], id);
          writer.writeString($responseFields[1], name.isPresent() ? name.get() : null);
          writer.writeString($responseFields[2], canonicalName);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], createdAt.isPresent() ? createdAt.get() : null);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[4], updatedAt.isPresent() ? updatedAt.get() : null);
          writer.writeString($responseFields[5], createdBy.isPresent() ? createdBy.get() : null);
          writer.writeString($responseFields[6], updatedBy.isPresent() ? updatedBy.get() : null);
          writer.writeString($responseFields[7], description.isPresent() ? description.get() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Action{"
          + "id=" + id + ", "
          + "name=" + name + ", "
          + "canonicalName=" + canonicalName + ", "
          + "createdAt=" + createdAt + ", "
          + "updatedAt=" + updatedAt + ", "
          + "createdBy=" + createdBy + ", "
          + "updatedBy=" + updatedBy + ", "
          + "description=" + description
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Action) {
        Action that = (Action) o;
        return this.id.equals(that.id)
         && this.name.equals(that.name)
         && this.canonicalName.equals(that.canonicalName)
         && this.createdAt.equals(that.createdAt)
         && this.updatedAt.equals(that.updatedAt)
         && this.createdBy.equals(that.createdBy)
         && this.updatedBy.equals(that.updatedBy)
         && this.description.equals(that.description);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        h *= 1000003;
        h ^= canonicalName.hashCode();
        h *= 1000003;
        h ^= createdAt.hashCode();
        h *= 1000003;
        h ^= updatedAt.hashCode();
        h *= 1000003;
        h ^= createdBy.hashCode();
        h *= 1000003;
        h ^= updatedBy.hashCode();
        h *= 1000003;
        h ^= description.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Action> {
      @Override
      public Action map(ResponseReader reader) {
        final String id = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final String canonicalName = reader.readString($responseFields[2]);
        final Object createdAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final Object updatedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[4]);
        final String createdBy = reader.readString($responseFields[5]);
        final String updatedBy = reader.readString($responseFields[6]);
        final String description = reader.readString($responseFields[7]);
        return new Action(id, name, canonicalName, createdAt, updatedAt, createdBy, updatedBy, description);
      }
    }
  }
}
