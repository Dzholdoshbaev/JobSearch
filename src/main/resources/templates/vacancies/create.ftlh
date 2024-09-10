<#import "../layout.ftlh" as main>

<@main.layout ; spring>

    <form action="/vacancies/create" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="title">Name</span>
            <@spring.formInput "vacancies.name" 'class="form-control" aria-label="Name" aria-describedby="name" name="name"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="description">Description</span>
            <@spring.formInput "vacancies.description" 'class="form-control" aria-label="Description" aria-describedby="Description" name="name"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="categories">Category ID</span>
            <select class="form-select" aria-label="categories" aria-describedby="categories" name="categories">
                <option selected>Open this select menu</option>
                <#list categoriesDto as item>
                    <option value="${item.id}">${item.name}</option>
                </#list>
            </select>
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="salary">Salary</span>
            <@spring.formInput "vacancies.salary" 'class="form-control" aria-label="Salary" aria-describedby="Salary" name="salary"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expFrom">Experience From</span>
            <@spring.formInput "vacancies.expFrom" 'class="form-control" aria-label="expFrom" aria-describedby="expFrom" name="expFrom"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expTo">Experience To</span>
            <@spring.formInput "vacancies.expTo" 'class="form-control" aria-label="expTo" aria-describedby="expTo" name="expTo"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="form-check mb-3">
            <input class="form-check-input" type="checkbox" id="isActive" name="isActive">
            <label class="form-check-label" for="isActive">
                Active
            </label>
        </div>

        <button type="submit" class="btn btn-outline-info m-2">Submit</button>

    </form>

</@main.layout>
