package com.intuit.platform.integration.rpasClient.client;

import com.apollographql.apollo.ApolloClient;
import com.intuit.platform.integration.rpasClient.exception.GraphqlClientException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import javax.validation.constraints.NotEmpty;

import org.apache.felix.scr.annotations.Component;
import org.springframework.http.HttpHeaders;

@Component
public class BaseApolloClient {

    protected final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

    protected void addInterceptor(Interceptor interceptor) {
        okHttpClientBuilder.addInterceptor(interceptor);
    }

    ApolloClient initializeApolloClient(String graphQLHostname, @NotEmpty String graphQLEndpoint) throws GraphqlClientException {
        String fqlUrl = graphQLHostname + graphQLEndpoint;
        if (graphQLHostname.isEmpty() || !graphQLHostname.startsWith("https://") && !graphQLHostname.startsWith("http://")) {
            throw new GraphqlClientException("invalid.protocol", "GraphlQL hostname should start with http:// or https://");
        }
        addHttpLogger();
        return ApolloClient.builder()
                .serverUrl(fqlUrl)
                .okHttpClient(okHttpClientBuilder.build())
                .build();
    }

    void addHttpLogger() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        addInterceptor(logging);
    }

    Interceptor addHeaders(HttpHeaders headers) {
        return chain -> {
            final Request request = chain.request();
            Request.Builder builder = request.newBuilder().method(request.method(), request.body());
            Headers headerBuilder = Headers.of(headers.toSingleValueMap());
            builder.headers(headerBuilder);
            return chain.proceed(builder.build());
        };
    }


}