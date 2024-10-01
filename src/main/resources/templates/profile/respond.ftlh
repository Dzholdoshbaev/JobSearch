<#import "../layout.ftlh" as main>

<@main.layout ; spring>

    <div class="row">
        <#list respondedApplicantsList as respond>
            <div class="col-12 mb-4">
                <div class="d-flex align-items-center p-3 border rounded">
                    <div class="flex-grow-1">
                        <p class="mb-1"><@spring.message "profile.respond.resumes_name"/>: ${respond.resumes.name!""}</p>
                        <p class="mb-1"><@spring.message "profile.respond.categories"/>: ${respond.resumes.categories.name!""}</p>
                        <p class="mb-1"><@spring.message "profile.respond.salary"/>: ${respond.resumes.salary!""}</p>
                    </div>
                    <div class="flex-grow-1">
                        <p class="mb-1"><@spring.message "profile.respond.vacancies_name"/>: ${respond.vacancies.name!""}</p>
                        <p class="mb-1"><@spring.message "profile.respond.salary"/>: ${respond.vacancies.salary!""}</p>
                        <p class="mb-1"><@spring.message "profile.respond.categories"/>: ${respond.vacancies.categories.name!""}</p>
                        <p class="mb-1"><@spring.message "profile.respond.description"/>: ${respond.vacancies.description!""}</p>
                    </div>
                    <div class="flex-grow-1">
                        <#if respond.confirmation>
                            <p class="card-text"><@spring.message "profile.respond.true"/></p>
                        <#else>
                            <p class="card-text"><@spring.message "profile.respond.false"/></p>
                        </#if>
                    </div>

                    <#if users.authorities.id == 2>
                        <div class="flex-shrink-0 ms-3">
                            <a href="/applicants/confirm/${respond.id}" class="btn btn-outline-info m-2"><@spring.message "profile.respond.confirm"/></a>
                        </div>
                    </#if>
                </div>
            </div>
        </#list>
    </div>



</@main.layout>