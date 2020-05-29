package com.intuit.platform.integration.rpasClient.service;

import com.apollographql.apollo.api.Response;
import com.coxautodev.java.graphql.client.tests.queries.GetActionsQuery;
import com.coxautodev.java.graphql.client.tests.queries.GetPermissionsQuery;
import com.coxautodev.java.graphql.client.tests.queries.GetResourcesQuery;
import com.coxautodev.java.graphql.client.tests.queries.GetRolesQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RpasClientQueryServiceImpl implements RpasClientQueryService {


    @Override
    public Optional<GetResourcesQuery.Data> getResources() {
        return Optional.empty();
    }

    @Override
    public Optional<GetRolesQuery.Data> getRoles() {
        return Optional.empty();
    }

    @Override
    public Optional<GetActionsQuery.Data> getActions() {
        return Optional.empty();
    }

    @Override
    public Optional<GetPermissionsQuery.Data> getPermissions() {
        return Optional.empty();
    }
}
