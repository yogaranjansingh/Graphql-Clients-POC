package com.intuit.platform.integration.rpasClient.service;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.coxautodev.java.graphql.client.tests.mutations.*;
import com.intuit.platform.integration.rpasClient.client.BaseApolloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RpasClientMutationServiceImpl implements RpasClientMutationService {


    @Override
    public Response<Optional<CreateActionMutation.Data>> createAction() {
        return null;
    }

    @Override
    public Response<Optional<CreateResourceMutation.Data>> createResource() {
        return null;
    }

    @Override
    public Response<Optional<CreateRoleMutation.Data>> createRole() {
        return null;
    }

    @Override
    public Response<Optional<UpdateActionMutation.Data>> updateAction() {
        return null;
    }

    @Override
    public Response<Optional<UpdateResourceMutation.Data>> updateResource() {
        return null;
    }

    @Override
    public Response<Optional<UpdateRoleMutation.Data>> updateRole() {
        return null;
    }

    @Override
    public Response<Optional<AssignRoleMutation.Data>> assignRole() {
        return null;
    }

}
