// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerregistry.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.containerregistry.fluent.models.TaskInner;
import com.azure.resourcemanager.containerregistry.models.TaskUpdateParameters;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in TasksClient. */
public interface TasksClient {
    /**
     * Lists all the tasks for a specified container registry.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the collection of tasks.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<TaskInner> listAsync(String resourceGroupName, String registryName);

    /**
     * Lists all the tasks for a specified container registry.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the collection of tasks.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TaskInner> list(String resourceGroupName, String registryName);

    /**
     * Lists all the tasks for a specified container registry.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the collection of tasks.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TaskInner> list(String resourceGroupName, String registryName, Context context);

    /**
     * Get the properties of a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of a specified task.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<TaskInner>> getWithResponseAsync(String resourceGroupName, String registryName, String taskName);

    /**
     * Get the properties of a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of a specified task.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<TaskInner> getAsync(String resourceGroupName, String registryName, String taskName);

    /**
     * Get the properties of a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of a specified task.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TaskInner get(String resourceGroupName, String registryName, String taskName);

    /**
     * Get the properties of a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of a specified task.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TaskInner> getWithResponse(
        String resourceGroupName, String registryName, String taskName, Context context);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> createWithResponseAsync(
        String resourceGroupName, String registryName, String taskName, TaskInner taskCreateParameters);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<TaskInner>, TaskInner> beginCreateAsync(
        String resourceGroupName, String registryName, String taskName, TaskInner taskCreateParameters);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TaskInner>, TaskInner> beginCreate(
        String resourceGroupName, String registryName, String taskName, TaskInner taskCreateParameters);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TaskInner>, TaskInner> beginCreate(
        String resourceGroupName,
        String registryName,
        String taskName,
        TaskInner taskCreateParameters,
        Context context);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<TaskInner> createAsync(
        String resourceGroupName, String registryName, String taskName, TaskInner taskCreateParameters);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TaskInner create(String resourceGroupName, String registryName, String taskName, TaskInner taskCreateParameters);

    /**
     * Creates a task for a container registry with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskCreateParameters The task that has the ARM resource and task properties. The task will have all
     *     information to schedule a run against it.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TaskInner create(
        String resourceGroupName,
        String registryName,
        String taskName,
        TaskInner taskCreateParameters,
        Context context);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> deleteWithResponseAsync(
        String resourceGroupName, String registryName, String taskName);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<Void>, Void> beginDeleteAsync(String resourceGroupName, String registryName, String taskName);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String registryName, String taskName);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String registryName, String taskName, Context context);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String registryName, String taskName);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String registryName, String taskName);

    /**
     * Deletes a specified task.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String registryName, String taskName, Context context);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> updateWithResponseAsync(
        String resourceGroupName, String registryName, String taskName, TaskUpdateParameters taskUpdateParameters);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<TaskInner>, TaskInner> beginUpdateAsync(
        String resourceGroupName, String registryName, String taskName, TaskUpdateParameters taskUpdateParameters);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TaskInner>, TaskInner> beginUpdate(
        String resourceGroupName, String registryName, String taskName, TaskUpdateParameters taskUpdateParameters);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TaskInner>, TaskInner> beginUpdate(
        String resourceGroupName,
        String registryName,
        String taskName,
        TaskUpdateParameters taskUpdateParameters,
        Context context);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<TaskInner> updateAsync(
        String resourceGroupName, String registryName, String taskName, TaskUpdateParameters taskUpdateParameters);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TaskInner update(
        String resourceGroupName, String registryName, String taskName, TaskUpdateParameters taskUpdateParameters);

    /**
     * Updates a task with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param taskUpdateParameters The parameters for updating a task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TaskInner update(
        String resourceGroupName,
        String registryName,
        String taskName,
        TaskUpdateParameters taskUpdateParameters,
        Context context);

    /**
     * Returns a task with extended information that includes all secrets.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<TaskInner>> getDetailsWithResponseAsync(
        String resourceGroupName, String registryName, String taskName);

    /**
     * Returns a task with extended information that includes all secrets.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<TaskInner> getDetailsAsync(String resourceGroupName, String registryName, String taskName);

    /**
     * Returns a task with extended information that includes all secrets.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TaskInner getDetails(String resourceGroupName, String registryName, String taskName);

    /**
     * Returns a task with extended information that includes all secrets.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param taskName The name of the container registry task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the task that has the ARM resource and task properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TaskInner> getDetailsWithResponse(
        String resourceGroupName, String registryName, String taskName, Context context);
}