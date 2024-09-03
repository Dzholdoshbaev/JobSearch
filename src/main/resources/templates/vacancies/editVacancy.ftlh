<#import "../layout.ftlh" as main>

<@main.layout>

    <form action="/vacancies/edit/${vacancyId}" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="title">Name</span>
            <input type="text" class="form-control" aria-label="Name" aria-describedby="title" name="name" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="description">Description</span>
            <input type="text" class="form-control" aria-label="Description" aria-describedby="description" name="description" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="salary">Salary</span>
            <input type="number" class="form-control" aria-label="Salary" aria-describedby="salary" name="salary" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expFrom">Experience From</span>
            <input type="number" class="form-control" aria-label="Experience From" aria-describedby="expFrom" name="expFrom" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expTo">Experience To</span>
            <input type="number" class="form-control" aria-label="Experience To" aria-describedby="expTo" name="expTo" />
        </div>
        <div class="form-check mb-3">
            <input class="form-check-input" type="checkbox" id="isActive" name="isActive">
            <label class="form-check-label" for="isActive">
                Active
            </label>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

    </form>

</@main.layout>
