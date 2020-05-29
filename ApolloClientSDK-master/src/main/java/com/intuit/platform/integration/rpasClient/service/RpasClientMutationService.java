package com.intuit.platform.integration.rpasClient.service;

import com.apollographql.apollo.api.Response;
import com.coxautodev.java.graphql.client.tests.mutations.*;

import java.util.Optional;

public interface RpasClientMutationService {


    public Response<Optional<CreateActionMutation.Data>>  createAction();

    public Response<Optional<CreateResourceMutation.Data>>  createResource();

    public Response<Optional<CreateRoleMutation.Data>>  createRole();

    public Response<Optional<UpdateActionMutation.Data>>  updateAction();

    public Response<Optional<UpdateResourceMutation.Data>>  updateResource();

    public Response<Optional<UpdateRoleMutation.Data>>  updateRole();

    public Response<Optional<AssignRoleMutation.Data>>  assignRole();


}
