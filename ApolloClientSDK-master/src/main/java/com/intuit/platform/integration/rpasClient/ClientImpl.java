package com.intuit.platform.integration.rpasClient;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.coxautodev.java.graphql.client.tests.mutations.CreateActionMutation;
import com.coxautodev.java.graphql.client.tests.queries.GetResourcesQuery;
import com.coxautodev.java.graphql.client.tests.type.ActionInput;

import com.coxautodev.java.graphql.client.tests.type.ResourceInput;
import com.intuit.platform.integration.rpasClient.client.BaseApolloClient;
import okhttp3.*;
import org.apache.felix.scr.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Component
public class ClientImpl  {


    static String address = "localhost:8080";

    static String graphQLEndpointUrl = "http://" + address + "/graphql";

    public static void main(String[] args) throws ApolloException {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl(graphQLEndpointUrl)
                .okHttpClient(httpClientBuilder.build())
                .logger((i, s, optional, objects) -> {
                    try {
                        String throwableTrace = "";
                        if (optional.isPresent()) {
                            throwableTrace = optional.get().getMessage();
                        }
                        final String message = String.format(s, objects) + " " + throwableTrace;
                        System.out.println("message");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                .build();


        GetResourcesQuery getResourcesQuery = new GetResourcesQuery();

        com.apollographql.apollo.api.Response<Optional<GetResourcesQuery.Data>> execute = null;
        try {
            execute = apolloClient.query(getResourcesQuery).execute();
            System.out.println(execute.toString());
            java.util.Optional<GetResourcesQuery.Data> data = execute.data();
            if (data != null && data.isPresent()) {
                Optional<GetResourcesQuery.Resources> appExperiences = data.get().resources();
                GetResourcesQuery.Resources appExperience = appExperiences.get();
                System.out.println(appExperience);
            }
        } catch (ApolloException e) {
            e.printStackTrace();
        }
        //Mutation Example

        ActionInput.Builder actionInput = ActionInput.builder();
        actionInput.name("a2");
        actionInput.canonicalName("c2");
        CreateActionMutation mutation = new CreateActionMutation(actionInput.build());
        Response<Optional<CreateActionMutation.Data>> mutationResponse = apolloClient.mutate(mutation).execute();
        System.out.println(mutationResponse.toString());


    }





}
