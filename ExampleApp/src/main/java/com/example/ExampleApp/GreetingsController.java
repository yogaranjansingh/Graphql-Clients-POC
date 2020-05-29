package com.example.ExampleApp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.intuit.graphql.rpas.*;
import com.intuit.rpas.RPASClientSDKConfiguration;
import com.intuit.rpas.client.RPASClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Import(RPASClientSDKConfiguration.class)
public class GreetingsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Autowired
    RPASClient client;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/getAction")
    public Set<Action> getAction() {
        ActionFilter actionFilter = new ActionFilter();
        ActionResponseProjection actionResponseProjection = new ActionResponseProjection();
        actionResponseProjection.canonicalName();
        actionResponseProjection.name();
        actionResponseProjection.description();
        Set<Action> actions = client.getActions(actionFilter,actionResponseProjection,new HttpHeaders());
        return actions;
    }

    @GetMapping("/getPermission")
    public Set<Permission> getPermission() {

       PermissionResponseProjection permissionResponseProjection = new PermissionResponseProjection();
       permissionResponseProjection.canonicalName();
       PermissionFilter permissionFilter = new PermissionFilter();
       HttpHeaders httpHeaders = new HttpHeaders();
       return client.getPermissions(permissionFilter, permissionResponseProjection,httpHeaders);
    }

    @GetMapping("/getResource")
    public List<Resource> getResource() {
        ResourceResponseProjection resourceResponseProjection = new ResourceResponseProjection();
        resourceResponseProjection.canonicalName();
        resourceResponseProjection.name();
        resourceResponseProjection.description();
        ResourceFilter resourceFilterTO = new ResourceFilter();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.getResources(resourceFilterTO, resourceResponseProjection,httpHeaders);
    }

    @GetMapping("/getRole")
    public List<Role> getRole() {
        RoleResponseProjection roleResponseProjection = new RoleResponseProjection();
        roleResponseProjection.canonicalName();
        roleResponseProjection.name();
        roleResponseProjection.description();
        RoleFilter roleFilter = new RoleFilter();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.getRoles(roleFilter, roleResponseProjection,httpHeaders);
    }

    @GetMapping("/getResourceWithoutProjection")
    public List<Resource> getResourceWithoutProjection() {
        ResourceFilter resourceFilterTO = new ResourceFilter();
        resourceFilterTO.setCanonicalName("ygyg");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.getResources(resourceFilterTO,httpHeaders);
    }

    @GetMapping("/getRoleWithoutProjection")
    public List<Role> getRoleWithoutProjection() {
        RoleFilter roleFilter = new RoleFilter();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.getRoles(roleFilter,httpHeaders);
    }

    @GetMapping("/getPermissionWithoutProjection")
    public Set<Permission> getPermissionWithoutProjection() {
        PermissionFilter permissionFilter = new PermissionFilter();
        HttpHeaders httpHeaders = new HttpHeaders();
        return client.getPermissions(permissionFilter,httpHeaders);
    }

    @GetMapping("/getActionWithoutProjection")
    public Set<Action> getActionWithoutProjection() {
        ActionFilter actionFilter = new ActionFilter();
        Set<Action> actions = client.getActions(actionFilter,new HttpHeaders());
        return actions;
    }

    /*
    Mutation
     */

    @GetMapping("/createAction")
    public Action createAction() {
        ActionResponseProjection actionResponseProjection = new ActionResponseProjection();
        ActionInput actionInput = new ActionInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                                                            .setCanonicalName(RandomStringUtils.random(10,alphabet))
                                                            .setDescription(RandomStringUtils.random(10,alphabet)).build();
        actionResponseProjection.canonicalName();
        actionResponseProjection.name();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.createAction(actionInput, actionResponseProjection,httpHeaders);
    }

    @GetMapping("/createActionWithoutProjection")
    public Action createActionWithoutProjection() {

        ActionInput actionInput = new ActionInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName(RandomStringUtils.random(10,alphabet))
                .setDescription(RandomStringUtils.random(10,alphabet)).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.createAction(actionInput,httpHeaders);
    }

    @GetMapping("/createRole")
    public Role createRole() {
        RoleResponseProjection roleResponseProjection = new RoleResponseProjection();
        roleResponseProjection.name().canonicalName().description();
        RoleInput roleInput = new RoleInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName(RandomStringUtils.random(10,alphabet))
                .setDescription(RandomStringUtils.random(10,alphabet)).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.createRole(roleInput, roleResponseProjection,httpHeaders);
    }

    @GetMapping("/createRoleWithoutProjection")
    public Role createRoleWithoutProjection() {
        RoleInput roleInput = new RoleInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName(RandomStringUtils.random(10,alphabet))
                .setDescription(RandomStringUtils.random(10,alphabet)).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.createRole(roleInput,httpHeaders);
    }

    @GetMapping("/createResource")
    public Resource createResource() {
        ResourceResponseProjection resourceResponseProjection = new ResourceResponseProjection();
        resourceResponseProjection.name().canonicalName().description();
        ResourceInput resourceInput = new ResourceInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName(RandomStringUtils.random(10,alphabet))
                .setDescription(RandomStringUtils.random(10,alphabet)).setParentCanonicalName("huhu")//parentCanonicalName is mandatory, a resource with this canonicalName should be present in db , also it must not have a parent resource
                        .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.createResource(resourceInput, resourceResponseProjection,httpHeaders);
    }

    @GetMapping("/createResourceWithoutProjection")
    public Resource createResourceWithoutProjection() {
        ResourceInput resourceInput = new ResourceInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName(RandomStringUtils.random(10,alphabet))
                .setDescription(RandomStringUtils.random(10,alphabet)).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.createResource(resourceInput,httpHeaders);
    }

    @GetMapping("/updateResource")
    public Resource updateResource() {
        ResourceResponseProjection resourceResponseProjection = new ResourceResponseProjection();
        resourceResponseProjection.name().canonicalName().description();
        ResourceInput resourceInput = new ResourceInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName("huhu")
                .setDescription(RandomStringUtils.random(10,alphabet))
                .setName(RandomStringUtils.random(10,alphabet))
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.updateResource(null,resourceInput, resourceResponseProjection,httpHeaders);
    }

    @GetMapping("/updateResourceWithoutProjection")
    public Resource updateResourceWithoutProjection() {
        ResourceInput resourceInput = new ResourceInput.Builder().setName(RandomStringUtils.random(10,alphabet))
                .setCanonicalName("huhu")
                .setDescription(RandomStringUtils.random(10,alphabet))
                .setName(RandomStringUtils.random(10,alphabet))
                .build();
        Resource updatedResource = getResourceWithoutProjection().get(0); //resourceInput resource is updated with the data of updatdResource
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.updateResource(Long.valueOf(updatedResource.getId()),resourceInput,httpHeaders);
    }

    @GetMapping("/updateAction")
    public Action updateAction() {
        ActionResponseProjection actionResponseProjection = new ActionResponseProjection();
        actionResponseProjection.name().canonicalName().description();
        ActionInput actionInput = new ActionInput.Builder()
                .setCanonicalName("slap")
                .setDescription(RandomStringUtils.random(10,alphabet))
                .setName(RandomStringUtils.random(10,alphabet))
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.updateAction(null,actionInput, actionResponseProjection,httpHeaders);
    }

    @GetMapping("/updateActionWithoutProjection")
    public Action updateActionWithoutProjection() {
        ActionInput actionInput = new ActionInput.Builder()
                .setCanonicalName("slap")
                .setDescription(RandomStringUtils.random(10,alphabet))
                .setName(RandomStringUtils.random(10,alphabet))
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.updateAction(null,actionInput,httpHeaders);
    }

    @GetMapping("/updateRole")
    public Role updateRole() {
        RoleResponseProjection roleResponseProjection = new RoleResponseProjection();
        roleResponseProjection.name().canonicalName().description();
        RoleInput roleInput = new RoleInput.Builder()
                .setCanonicalName("fdfgd")
                .setDescription(RandomStringUtils.random(10,alphabet))
                .setName(RandomStringUtils.random(10,alphabet))
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.updateRole(null,roleInput, roleResponseProjection,httpHeaders);
    }

    @GetMapping("/updateRoleWithoutProjection")
    public Role updateRoleWithoutProjection() {
        RoleInput roleInput = new RoleInput.Builder()
                .setCanonicalName("fdfgd")
                .setDescription(RandomStringUtils.random(10,alphabet))
                .setName(RandomStringUtils.random(10,alphabet))
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.updateRole(null,roleInput,httpHeaders);
    }

    @GetMapping("/assignRole")
    public UserAssignment assignRole() {
        AssignRole assignRole = new AssignRole();
        assignRole.setAccountId("1");
        assignRole.setProfileId("2");
        Role role = new Role.Builder().setCanonicalName("fdfgd").build();
        HashSet<String> roles = new HashSet<String>();
        roles.add("fdfgd");
        roles.add("rnugjkkcqt");
        assignRole.setRoles(roles);
        UserAssignment userAssignment = new UserAssignment();
        UserAssignmentResponseProjection userAssignmentResponseProjection = new UserAssignmentResponseProjection();
        userAssignmentResponseProjection.id().updatedBy().updatedAt().isActive().createdBy().
                createdAt().profileId().roles(new RoleResponseProjection().canonicalName().description().name().id());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Intuit_IAM_Authentication intuit_appid='Intuit.identity.authz.rpastestclient',intuit_app_secret='preprdyKPnQJCBcqpBi5amhBwZjK0QBj29Y1e183',intuit_token='V1-156-X3ai3bd6zit6sb32a0xsuf',intuit_userid='9130346920313776',intuit_token_type=IAM-Ticket");
        return client.assignRole(assignRole, userAssignmentResponseProjection,httpHeaders);
    }

}
