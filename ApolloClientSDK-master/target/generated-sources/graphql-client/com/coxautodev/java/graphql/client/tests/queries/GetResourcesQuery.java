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
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class GetResourcesQuery implements Query<GetResourcesQuery.Data, Optional<GetResourcesQuery.Data>, Operation.Variables> {
  public static final String OPERATION_DEFINITION = "query getResources {\n"
      + "  resources(filterBy: {}) {\n"
      + "    edges {\n"
      + "      cursor\n"
      + "    }\n"
      + "    pageInfo {\n"
      + "      hasPreviousPage\n"
      + "      hasNextPage\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "getResources";
    }
  };

  private final Operation.Variables variables;

  public GetResourcesQuery() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return "229c609cca2831de12741d1b13976b7b8e35d2095c48f664cc5cbe599734a05d";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public Optional<GetResourcesQuery.Data> wrapData(GetResourcesQuery.Data data) {
    return Optional.ofNullable(data);
  }

  @Override
  public Operation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetResourcesQuery.Data> responseFieldMapper() {
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

    public GetResourcesQuery build() {
      return new GetResourcesQuery();
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("resources", "resources", new UnmodifiableMapBuilder<String, Object>(1)
        .put("filterBy", new UnmodifiableMapBuilder<String, Object>(0)
        .build())
      .build(), true)
    };

    final Optional<Resources> resources;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Resources resources) {
      this.resources = Optional.ofNullable(resources);
    }

    /**
     * Query Resources by applying one or more filters
     * ResourceConnection returns the edges whose type is of Resource.
     */
    public Optional<Resources> resources() {
      return this.resources;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], resources.isPresent() ? resources.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "resources=" + resources
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
        return this.resources.equals(that.resources);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= resources.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Resources.Mapper resourcesFieldMapper = new Resources.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Resources resources = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Resources>() {
          @Override
          public Resources read(ResponseReader reader) {
            return resourcesFieldMapper.map(reader);
          }
        });
        return new Data(resources);
      }
    }
  }

  public static class Resources {
    static final ResponseField[] $responseFields = {
      ResponseField.forObjectList("edges", "edges", null, true),
      ResponseField.forObject("pageInfo", "pageInfo", null, true)
    };

    final Optional<List<Edge>> edges;

    final Optional<PageInfo> pageInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Resources(@Nullable List<Edge> edges, @Nullable PageInfo pageInfo) {
      this.edges = Optional.ofNullable(edges);
      this.pageInfo = Optional.ofNullable(pageInfo);
    }

    public Optional<List<Edge>> edges() {
      return this.edges;
    }

    public Optional<PageInfo> pageInfo() {
      return this.pageInfo;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], edges.isPresent() ? new ResponseWriter.ListWriter() {
            @Override
            public void write(ResponseWriter.ListItemWriter listItemWriter) {
              for (Edge $item : edges.get()) {
                listItemWriter.writeObject($item.marshaller());
              }
            }
          } : null);
          writer.writeObject($responseFields[1], pageInfo.isPresent() ? pageInfo.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Resources{"
          + "edges=" + edges + ", "
          + "pageInfo=" + pageInfo
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Resources) {
        Resources that = (Resources) o;
        return this.edges.equals(that.edges)
         && this.pageInfo.equals(that.pageInfo);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= edges.hashCode();
        h *= 1000003;
        h ^= pageInfo.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Resources> {
      final Edge.Mapper edgeFieldMapper = new Edge.Mapper();

      final PageInfo.Mapper pageInfoFieldMapper = new PageInfo.Mapper();

      @Override
      public Resources map(ResponseReader reader) {
        final List<Edge> edges = reader.readList($responseFields[0], new ResponseReader.ListReader<Edge>() {
          @Override
          public Edge read(ResponseReader.ListItemReader reader) {
            return reader.readObject(new ResponseReader.ObjectReader<Edge>() {
              @Override
              public Edge read(ResponseReader reader) {
                return edgeFieldMapper.map(reader);
              }
            });
          }
        });
        final PageInfo pageInfo = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<PageInfo>() {
          @Override
          public PageInfo read(ResponseReader reader) {
            return pageInfoFieldMapper.map(reader);
          }
        });
        return new Resources(edges, pageInfo);
      }
    }
  }

  public static class Edge {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("cursor", "cursor", null, true)
    };

    final Optional<String> cursor;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Edge(@Nullable String cursor) {
      this.cursor = Optional.ofNullable(cursor);
    }

    public Optional<String> cursor() {
      return this.cursor;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], cursor.isPresent() ? cursor.get() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Edge{"
          + "cursor=" + cursor
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Edge) {
        Edge that = (Edge) o;
        return this.cursor.equals(that.cursor);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= cursor.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Edge> {
      @Override
      public Edge map(ResponseReader reader) {
        final String cursor = reader.readString($responseFields[0]);
        return new Edge(cursor);
      }
    }
  }

  public static class PageInfo {
    static final ResponseField[] $responseFields = {
      ResponseField.forBoolean("hasPreviousPage", "hasPreviousPage", null, true),
      ResponseField.forBoolean("hasNextPage", "hasNextPage", null, true)
    };

    final Optional<Boolean> hasPreviousPage;

    final Optional<Boolean> hasNextPage;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public PageInfo(@Nullable Boolean hasPreviousPage, @Nullable Boolean hasNextPage) {
      this.hasPreviousPage = Optional.ofNullable(hasPreviousPage);
      this.hasNextPage = Optional.ofNullable(hasNextPage);
    }

    public Optional<Boolean> hasPreviousPage() {
      return this.hasPreviousPage;
    }

    public Optional<Boolean> hasNextPage() {
      return this.hasNextPage;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeBoolean($responseFields[0], hasPreviousPage.isPresent() ? hasPreviousPage.get() : null);
          writer.writeBoolean($responseFields[1], hasNextPage.isPresent() ? hasNextPage.get() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PageInfo{"
          + "hasPreviousPage=" + hasPreviousPage + ", "
          + "hasNextPage=" + hasNextPage
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PageInfo) {
        PageInfo that = (PageInfo) o;
        return this.hasPreviousPage.equals(that.hasPreviousPage)
         && this.hasNextPage.equals(that.hasNextPage);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= hasPreviousPage.hashCode();
        h *= 1000003;
        h ^= hasNextPage.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<PageInfo> {
      @Override
      public PageInfo map(ResponseReader reader) {
        final Boolean hasPreviousPage = reader.readBoolean($responseFields[0]);
        final Boolean hasNextPage = reader.readBoolean($responseFields[1]);
        return new PageInfo(hasPreviousPage, hasNextPage);
      }
    }
  }
}
