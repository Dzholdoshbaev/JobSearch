<#import "../layout.ftlh" as main>

<@main.layout ; spring>

    <form action="/vacancies/edit/${vacancyId}" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="title"><@spring.message "vacancies.editVacancy.name"/></span>
            <@spring.formInput "vacancies.name" 'class="form-control" aria-label="Name" aria-describedby="name" name="name"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="description"><@spring.message "vacancies.editVacancy.description"/></span>
            <@spring.formInput "vacancies.description" 'class="form-control" aria-label="Description" aria-describedby="Description" name="description"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="categories"><@spring.message "vacancies.editVacancy.category_id"/></span>
            <select class="form-select" aria-label="categories" aria-describedby="categories" name="categories">
                <option selected><@spring.message "vacancies.editVacancy.open_this_select_menu"/></option>
                <#list categoriesDto as item>
                    <option value="${item.id}">${item.name}</option>
                </#list>
            </select>
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="salary"><@spring.message "vacancies.editVacancy.salary"/></span>
            <@spring.formInput "vacancies.salary" 'class="form-control" aria-label="Salary" aria-describedby="Salary" name="salary"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expFrom"><@spring.message "vacancies.editVacancy.experience_from"/></span>
            <@spring.formInput "vacancies.expFrom" 'class="form-control" aria-label="expFrom" aria-describedby="expFrom" name="expFrom"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expTo"><@spring.message "vacancies.editVacancy.experience_to"/></span>
            <@spring.formInput "vacancies.expTo" 'class="form-control" aria-label="expTo" aria-describedby="expTo" name="expTo"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="form-check mb-3">
            <input class="form-check-input" type="checkbox" id="isActive" name="isActive">
            <label class="form-check-label" for="isActive">
                <@spring.message "vacancies.editVacancy.active"/>
            </label>
        </div>

        <button type="submit" class="btn btn-outline-info m-2"><@spring.message "vacancies.editVacancy.submit"/></button>

    </form>

</@main.layout>
