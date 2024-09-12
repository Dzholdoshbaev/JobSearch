<#import "../layout.ftlh" as main>

<@main.layout ; spring>



    <div class="container my-4">
        <div class="row d-flex justify-content-center">
            <div class="card col-md-8 col-lg-6 mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title"><@spring.message "vacancies.vacancy.title"/> : ${vacancy.name!""}</h5>
                    <p class="card-text"><@spring.message "vacancies.vacancy.description"/> : ${vacancy.description!""}</p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.salary"/>:</strong> ${vacancy.salary!""}</p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.status"/>:</strong>
                        <#if vacancy.isActive>
                            <@spring.message "vacancies.vacancy.vacancy_is_active"/>
                        <#else>
                            <@spring.message "vacancies.vacancy.vacancy_is_not_active"/>
                        </#if>
                    </p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.categories"/>:</strong> ${vacancy.categories.name!""}</p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.created_date"/>:</strong> ${vacancy.createdDate!""}</p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.update_time"/>:</strong> ${vacancy.updateTime!""}</p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.experience_from"/>:</strong> ${vacancy.expFrom!""}</p>
                    <p class="card-text"><strong><@spring.message "vacancies.vacancy.experience_to"/>:</strong> ${vacancy.expTo!""}</p>
                    <div class="d-flex justify-content-between mt-4">
                        <a href="#" class="btn btn-outline-info m-2"><@spring.message "vacancies.vacancy.respond_to_vacancy"/></a>
                        <a href="/vacancies" class="btn btn-outline-info m-2"><@spring.message "vacancies.vacancy.back_to_vacancies"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>



</@main.layout>