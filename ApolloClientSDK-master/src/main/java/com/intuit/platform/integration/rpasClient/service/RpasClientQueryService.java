package com.intuit.platform.integration.rpasClient.service;

import com.coxautodev.java.graphql.client.tests.queries.GetActionsQuery;
import com.coxautodev.java.graphql.client.tests.queries.GetPermissionsQuery;
import com.coxautodev.java.graphql.client.tests.queries.GetResourcesQuery;
import com.coxautodev.java.graphql.client.tests.queries.GetRolesQuery;

public interface RpasClientQueryService {

    public java.util.Optional<GetResourcesQuery.Data> getResources();

    public java.util.Optional<GetRolesQuery.Data> getRoles();

    public java.util.Optional<GetActionsQuery.Data> getActions();

    public java.util.Optional<GetPermissionsQuery.Data> getPermissions();

}
