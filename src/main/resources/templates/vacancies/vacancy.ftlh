<#import "../layout.ftlh" as main>

<@main.layout>




    <div class="row d-flex justify-content-between">
            <div class="card col-6 m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${vacancy.name!"Not specified"}</h5>
                    <p class="card-text">${vacancy.description!"Not specified"}</p>
                    <p class="card-text">Salary ${vacancy.salary!"Not specified"}</p>
                    <#if vacancy.isActive>
                        <p class="card-text">Vacancy is active</p>
                    <#else>
                        <p class="card-text">Vacancy is not active</p>
                    </#if>
                    <p class="card-text">Categories ${vacancy.categories.name!"Not specified"}</p>
                    <p class="card-text">Created Date ${vacancy.createdDate!"Not specified"}</p>
                    <p class="card-text">Update time  ${vacancy.updateTime!"Not update yet"}</p>
                    <p class="card-text">Exp from ${vacancy.expFrom!"Not specified"}</p>
                    <p class="card-text">Exp to ${vacancy.expTo!"Not specified"}</p>
                    <a href="#" class="btn btn-primary">respond to vacancy</a>
                    <a href="/vacancies" class="btn btn-primary">Back to Vacancies</a>
                </div>
            </div>
    </div>


</@main.layout>